package com.java2nb.novel.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.java2nb.novel.core.crawl.CrawlParser;
import com.java2nb.novel.core.crawl.RuleBean;
import com.java2nb.novel.core.enums.ResponseStatus;
import com.java2nb.novel.core.utils.SpringUtil;
import com.java2nb.novel.entity.Book;
import com.java2nb.novel.entity.CrawlSingleTask;
import com.java2nb.novel.entity.CrawlSource;
import com.java2nb.novel.mapper.CrawlSingleTaskDynamicSqlSupport;
import com.java2nb.novel.mapper.CrawlSingleTaskMapper;
import com.java2nb.novel.mapper.CrawlSourceDynamicSqlSupport;
import com.java2nb.novel.mapper.CrawlSourceMapper;
import com.java2nb.novel.service.BookService;
import com.java2nb.novel.service.CrawlService;
import com.java2nb.novel.utils.CrawlHttpClient;
import com.java2nb.novel.vo.CrawlSingleTaskVO;
import com.java2nb.novel.vo.CrawlSourceVO;
import io.github.xxyopen.model.page.PageBean;
import io.github.xxyopen.model.page.builder.pagehelper.PageBuilder;
import io.github.xxyopen.util.IdWorker;
import io.github.xxyopen.web.exception.BusinessException;
import io.github.xxyopen.web.util.BeanUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.java2nb.novel.mapper.CrawlSourceDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.select.SelectDSL.select;

/**
 * @author Administrator
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CrawlServiceImpl implements CrawlService {

    private final CrawlParser crawlParser;

    private final CrawlSourceMapper crawlSourceMapper;

    private final CrawlSingleTaskMapper crawlSingleTaskMapper;

    private final BookService bookService;

    private final IdWorker idWorker = IdWorker.INSTANCE;

    private final CrawlHttpClient crawlHttpClient;

    @Getter
    private final Map<Integer, Integer> sourceOffsetCache = new ConcurrentHashMap<>();

    @Getter
    private final Map<Integer, Map<Integer, Integer>> runningTaskCache = new ConcurrentHashMap<>();
    private final StringRedisTemplate redisTemplate;

    private TimePeriod SLEEP_PERIOD = new TimePeriod(
            LocalTime.of(4, 58),
            LocalTime.of(5, 2)
    );


    @Override
    public void addCrawlSource(CrawlSource source) {
        Date currentDate = new Date();
        source.setCreateTime(currentDate);
        source.setUpdateTime(currentDate);
        crawlSourceMapper.insertSelective(source);

    }

    @Override
    public void updateCrawlSource(CrawlSource source) {
        if (source.getId() != null) {
            Optional<CrawlSource> opt = crawlSourceMapper.selectByPrimaryKey(source.getId());
            if (opt.isPresent()) {
                CrawlSource crawlSource = opt.get();
                if (crawlSource.getSourceStatus() == (byte) 1) {
                    // 关闭
                    openOrCloseCrawl(crawlSource.getId(), (byte) 0);
                }
                Date currentDate = new Date();
                crawlSource.setUpdateTime(currentDate);
                crawlSource.setCrawlRule(source.getCrawlRule());
                crawlSource.setSourceName(source.getSourceName());
                crawlSourceMapper.updateByPrimaryKey(crawlSource);
            }
        }
    }

    @Override
    public PageBean<CrawlSource> listCrawlByPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        SelectStatementProvider render = select(id, sourceName, sourceStatus, createTime, updateTime)
                .from(crawlSource)
                .orderBy(updateTime)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<CrawlSource> crawlSources = crawlSourceMapper.selectMany(render);
        PageBean<CrawlSource> pageBean = PageBuilder.build(crawlSources);
        pageBean.setList(BeanUtil.copyList(crawlSources, CrawlSourceVO.class));
        return pageBean;
    }

    @SneakyThrows
    @Override
    public void openOrCloseCrawl(Integer sourceId, Byte sourceStatus) {

        // 判断是开启还是关闭，如果是关闭，则修改数据库状态后获取该爬虫正在运行的线程集合并全部停止
        // 如果是开启，先查询数据库中状态，判断该爬虫源是否还在运行，如果在运行，则忽略，
        // 如果没有则修改数据库状态，并启动线程爬取小说数据加入到runningCrawlThread中
        if (sourceStatus == (byte) 0) {
            // 关闭,直接修改数据库状态，并直接修改数据库状态后获取该爬虫正在运行的线程集合全部停止
            SpringUtil.getBean(CrawlService.class).updateCrawlSourceStatus(sourceId, sourceStatus);
            runningTaskCache.remove(sourceId);
        } else {
            // 开启
            // 查询爬虫源状态和规则
            CrawlSource source = queryCrawlSource(sourceId);
            Byte realSourceStatus = source.getSourceStatus();

            if (realSourceStatus == (byte) 0) {
                // 该爬虫源已经停止运行了,修改数据库状态，并启动线程爬取小说数据加入到runningCrawlThread中
                SpringUtil.getBean(CrawlService.class).updateCrawlSourceStatus(sourceId, sourceStatus);
                RuleBean ruleBean = new ObjectMapper().readValue(source.getCrawlRule(), RuleBean.class);

                var catIdRule = ruleBean.getCatIdRule();
                if (catIdRule == null || catIdRule.isEmpty()) {
                    return;
                }
                runningTaskCache.put(sourceId, new HashMap<>());
                // 按分类开始爬虫解析任务
                catIdRule.forEach((catIdStr, catIdRuleValue) -> {
                    final int catId = parseCatId(catIdStr);
                    Thread thread = new Thread(() -> parseBookList(catId, ruleBean, sourceId), "craw_" + sourceId + "_" + catId);
                    thread.start();
                });
            }
        }

    }

    private int parseCatId(String catIdStr) {
        try {
            return Integer.parseInt(catIdStr.replace("catId", ""));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    private int getCurrentPage(int catId) {
        try {
            var pageObj = redisTemplate.opsForValue().get("crawl:page:" + catId);
            return Integer.parseInt(pageObj);
        } catch (Throwable e) {
            log.error("error-crawl，解析分页异常: {}", e.getMessage());
        }
        return 0;
    }

    @Override
    public CrawlSource queryCrawlSource(Integer sourceId) {
        SelectStatementProvider render = select(CrawlSourceDynamicSqlSupport.sourceStatus,
                CrawlSourceDynamicSqlSupport.crawlRule)
                .from(crawlSource)
                .where(id, isEqualTo(sourceId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return crawlSourceMapper.selectMany(render).get(0);
    }

    @Override
    public void addCrawlSingleTask(CrawlSingleTask singleTask) {

        if (bookService.queryIsExistByBookNameAndAuthorName(singleTask.getBookName(), singleTask.getAuthorName())) {
            throw new BusinessException(ResponseStatus.BOOK_EXISTS);

        }
        singleTask.setCreateTime(new Date());
        crawlSingleTaskMapper.insertSelective(singleTask);


    }

    @Override
    public PageBean<CrawlSingleTask> listCrawlSingleTaskByPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        SelectStatementProvider render = select(CrawlSingleTaskDynamicSqlSupport.crawlSingleTask.allColumns())
                .from(CrawlSingleTaskDynamicSqlSupport.crawlSingleTask)
                .orderBy(CrawlSingleTaskDynamicSqlSupport.createTime.descending())
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<CrawlSingleTask> crawlSingleTasks = crawlSingleTaskMapper.selectMany(render);
        PageBean<CrawlSingleTask> pageBean = PageBuilder.build(crawlSingleTasks);
        pageBean.setList(BeanUtil.copyList(crawlSingleTasks, CrawlSingleTaskVO.class));
        return pageBean;
    }

    @Override
    public void delCrawlSingleTask(Long id) {
        crawlSingleTaskMapper.deleteByPrimaryKey(id);
    }

    @Override
    public CrawlSingleTask getCrawlSingleTask() {

        List<CrawlSingleTask> list = crawlSingleTaskMapper.selectMany(
                select(CrawlSingleTaskDynamicSqlSupport.crawlSingleTask.allColumns())
                        .from(CrawlSingleTaskDynamicSqlSupport.crawlSingleTask)
                        .where(CrawlSingleTaskDynamicSqlSupport.taskStatus, isEqualTo((byte) 2))
                        .orderBy(CrawlSingleTaskDynamicSqlSupport.createTime)
                        .limit(1)
                        .build()
                        .render(RenderingStrategies.MYBATIS3));

        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public void updateCrawlSingleTask(CrawlSingleTask task, Byte status) {
        byte excCount = task.getExcCount();
        excCount += 1;
        task.setExcCount(excCount);
        if (status == 1 || excCount == 5) {
            // 当采集成功或者采集次数等于5，则更新采集最终状态，并停止采集
            task.setTaskStatus(status);
        }
        crawlSingleTaskMapper.updateByPrimaryKeySelective(task);

    }

    @Override
    public CrawlSource getCrawlSource(Integer id) {
        return crawlSourceMapper.selectByPrimaryKey(id).orElse(null);
    }

    @Override
    public Integer getTaskProgress(Long taskId) {
        return Optional.ofNullable(crawlParser.getCrawlTaskProgress(taskId)).orElse(0);
    }

    /**
     * 解析分类列表
     */
    @Override
    public void parseBookList(int catId, RuleBean ruleBean, Integer sourceId) {

        String catIdRule = ruleBean.getCatIdRule().get("catId" + catId);
        if (StringUtils.isBlank(catIdRule)) {
            return;
        }

        var sourceMap = runningTaskCache.get(sourceId);
        if (sourceMap == null) {
            return;
        }
        // 当前页码1
        var initPage = getCurrentPage(catId);
        if (initPage == 0) {
            initPage = 1;
        }
        sourceMap.putIfAbsent(catId, initPage);
        int totalPage = sourceMap.get(catId);
        int firstTotal = 0;

        Set<String> bookIdSet = new HashSet<>();
        while (sourceMap.get(catId) <= totalPage) {
            var findCount = 0;
            var processCount = 0;
            sourceMap = runningTaskCache.get(sourceId);
            if (sourceMap == null) {
                log.info("任务已终止，sourceId={}", sourceId);
                return;
            }
            var page = sourceMap.get(catId);
            bookIdSet.clear();
            try {
                String catBookListUrl = extractBookUrl(ruleBean, catIdRule, page);
                log.info("catBookListUrl：{}", catBookListUrl);

                String bookListHtml = crawlHttpClient.get(catBookListUrl, ruleBean.getCharset());
                if (bookListHtml != null) {
                    Pattern bookIdPatten = Pattern.compile(ruleBean.getBookIdPatten());
                    Matcher bookIdMatcher = bookIdPatten.matcher(bookListHtml);
                    boolean isFindBookId = bookIdMatcher.find();
                    if (!isFindBookId) {
                        log.error("当前页已采集完，从未发现bookId，catId={}, page={}", catId, page);
                    }
                    while (isFindBookId) {
                        if (SLEEP_PERIOD.isCurrentTimeWithinPeriod()) {
                            try {
                                TimeUnit.SECONDS.sleep(10);
                            } catch (InterruptedException e) {
                                log.error(e.getMessage(), e);
                            }
                            continue;
                        }
                        findCount++;
                        try {
                            // 1.阻塞过程（使用了 sleep,同步锁的 wait,socket 中的 receiver,accept 等方法时）捕获中断异常InterruptedException来退出线程。
                            // 2.非阻塞过程中通过判断中断标志来退出线程。
                            if (Thread.currentThread().isInterrupted()) {
                                log.info("任务已终止，isInterrupted, sourceId={}", sourceId);
                                return;
                            }

                            String bookId = bookIdMatcher.group(1);
                            if (bookIdSet.contains(bookId)) {
                                log.info("重复采集，bookId：{}", bookId);
                            } else {
                                bookIdSet.add(bookId);
                                processCount++;
                                parseBookAndSave(catId, ruleBean, sourceId, bookId, null);
                            }

                        } catch (InterruptedException e) {
                            log.error(e.getMessage(), e);
                            // 1.阻塞过程（使用了 sleep,同步锁的 wait,socket 中的 receiver,accept 等方法时）
                            // 捕获中断异常InterruptedException来退出线程。
                            // 2.非阻塞过程中通过判断中断标志来退出线程。
                            log.info("任务已终止，cache Interrupted, sourceId={}", sourceId);
                            return;
                        } catch (Throwable e) {
                            // todo
                            log.error("Error，msg={}, catId={}, page={}", e.getMessage(), catId, page, e);
                            try {
                                TimeUnit.MINUTES.sleep(1);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        }

                        isFindBookId = bookIdMatcher.find();
                    }
                    log.info("当前页已采集完，catId={}, page={}, 本页共发现：{} , 处理 {} ", catId, page, findCount, processCount);

                    var totalPageValue = ruleBean.catIdTotalPage(catId);
                    if (totalPageValue == null) {
                        Pattern totalPagePatten = Pattern.compile(ruleBean.getTotalPagePatten());
                        Matcher totalPageMatcher = totalPagePatten.matcher(bookListHtml);
                        boolean isFindTotalPage = totalPageMatcher.find();
                        if (isFindTotalPage) {
                            // todo
                            totalPage = Integer.parseInt(totalPageMatcher.group(2));
                        }
                    } else {
                        totalPage = totalPageValue;
                    }

                    // todo 临时修正到了第5页totalPage因重复无法识别的问题
                    if (firstTotal == 0) {
                        firstTotal = totalPage;
                    }
                    if (totalPage < firstTotal) {
                        totalPage = firstTotal;
                    }

                } else {
                    log.error("当前页已采集完（获取列表失败），catId={}, page={}", catId, page);
                }
            } catch (Exception e) {
                log.error("当前页已采集完（发生异常），catId={}, page={}, msg={}, findCount={}, processCount={}", catId, page, e.getMessage(), findCount, processCount, e);
                try {
                    TimeUnit.MINUTES.sleep(2);
                } catch (InterruptedException e1) {
                    e.printStackTrace();
                }
            }
            if (page == totalPage) {
                // 第一遍采集完成，翻到第一页，继续第二次采集，适用于分页数比较少的最近更新列表
//                sourceMap.put(catId, 1);
                log.info("当前cat已采集完所有页，catId={}, page={}", catId, page);
            }
            var nextPage = page + 1;
            sourceMap.put(catId, nextPage);
        }
    }

    @Override
    public boolean parseBookAndSave(int catId, RuleBean ruleBean, Integer sourceId, String bookId, CrawlSingleTask task) throws InterruptedException {

        final AtomicBoolean parseResult = new AtomicBoolean(false);

        crawlParser.parseBook(ruleBean, bookId, book -> {
            if (book.getBookName() == null || book.getAuthorName() == null) {
                return;
            }
            // 这里只做新书入库，查询是否存在这本书
            Book existBook = bookService.queryBookByBookNameAndAuthorName(book.getBookName(), book.getAuthorName());
            // 如果该小说不存在，则可以解析入库，但是标记该小说正在入库，30分钟之后才允许再次入库
            if (existBook == null) {
                // 没有该书，可以入库
                book.setCatId(catId);
                // 根据分类ID查询分类
                book.setCatName(bookService.queryCatNameByCatId(catId));
                if (catId == 7) {
                    // 女频
                    book.setWorkDirection((byte) 1);
                } else {
                    // 男频
                    book.setWorkDirection((byte) 0);
                }
                book.setCrawlBookId(bookId);
                book.setCrawlSourceId(sourceId);
                book.setCrawlLastTime(new Date());
                book.setId(idWorker.nextId());
                // 解析章节目录
                boolean parseIndexContentResult = crawlParser.parseBookIndexAndContent(bookId, book, ruleBean, sourceId,
                        new HashMap<>(0), chapter -> {
                            bookService.saveBookAndIndexAndContent(book, chapter.getBookIndexList(), chapter.getBookContentList());
                        }, task);
                parseResult.set(parseIndexContentResult);

            } else {
                log.info("该小说已存在：{} - {}", bookId, book.getBookName());
                // 只更新书籍的爬虫相关字段
                bookService.updateCrawlProperties(existBook.getId(), sourceId, bookId);
                parseResult.set(true);
            }
        });

        return parseResult.get();

    }

    @Override
    public void updateCrawlSourceStatus(Integer sourceId, Byte sourceStatus) {
        CrawlSource source = new CrawlSource();
        source.setId(sourceId);
        source.setSourceStatus(sourceStatus);
        crawlSourceMapper.updateByPrimaryKeySelective(source);
    }

    @Override
    public List<CrawlSource> queryCrawlSourceByStatus(Byte sourceStatus) {
        SelectStatementProvider render = select(CrawlSourceDynamicSqlSupport.id,
                CrawlSourceDynamicSqlSupport.sourceStatus, CrawlSourceDynamicSqlSupport.crawlRule)
                .from(crawlSource)
                .where(CrawlSourceDynamicSqlSupport.sourceStatus, isEqualTo(sourceStatus))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return crawlSourceMapper.selectMany(render);
    }


    private String extractBookUrl(RuleBean ruleBean, String catIdRule, int page) {
        if (StringUtils.isNotBlank(ruleBean.getBookListUrl())) {
            // 兼容老规则
            // 拼接分类URL
            return ruleBean.getBookListUrl()
                    .replace("{catId}", catIdRule)
                    .replace("{page}", page + "");
        } else {
            // 新规则
            // 拼接分类URL
            return catIdRule.replace("{page}", page + "");
        }
    }

    public static void main(String[] args) {
        var str = """
                    <!-- 推荐标签结束 -->
                    <div class="pagination_box">
                        <div class="content_box">
                            <div class="arrow_box">
                                <a href="/novel/list?keyword=&searchType=1&author=&category=明星&finished=&space=&source=&tag=&sort=2&page=1"
                                   title="上一页">
                                    <img src="/image/pre_page_icon.svg" alt="上一页"/>
                                </a>
                            </div>
                
                                    <div><a href="/novel/list?keyword=&searchType=1&author=&category=明星&finished=&space=&source=&tag=&sort=2&page=1"
                                            class="active">1</a></div>
                                    <div><a href="/novel/list?keyword=&searchType=1&author=&category=明星&finished=&space=&source=&tag=&sort=2&page=2"
                                            class="item">2</a></div>
                                    <div><a href="/novel/list?keyword=&searchType=1&author=&category=明星&finished=&space=&source=&tag=&sort=2&page=3"
                                            class="item">3</a></div>
                                    <div><a href="/novel/list?keyword=&searchType=1&author=&category=明星&finished=&space=&source=&tag=&sort=2&page=4"
                                            class="item">4</a></div>
                
                
                            <div class="arrow_box">
                                <a href="/novel/list?keyword=&searchType=1&author=&category=明星&finished=&space=&source=&tag=&sort=2&page=2"
                                   title="下一页">
                                    <img src="/image/nxt_page_icon.svg" alt="下一页"/>
                                </a>
                            </div>
                        </div>
                """;

        // 修改后的正则表达式，用于匹配最后一个页码链接并捕获页码数字
        var matcher = Pattern.compile("<div><a[^>]*page=(\\d+)\"[^>]*class=\"item\">\\d+</a></div>\\s*$").matcher(str);
        if (matcher.find()) {
            System.out.println("总页数1: " + matcher.group(1)); // 输出 "213"
        }

        // 或者使用另一种方式，匹配包含最大页码的链接
        var matcher2 = Pattern.compile("page=(\\d+)\"[^>]*class=\"item\">(\\d+)</a></div>\\s*<div class=\"arrow_box\">").matcher(str);
        if (matcher2.find()) {
            System.out.println("总页数2: " + matcher2.group(1)); // 输出 "213"
        }
    }

    @Getter
    class TimePeriod {
        private LocalTime startTime;
        private LocalTime endTime;

        public TimePeriod(LocalTime start, LocalTime end) {
            this.startTime = start;
            this.endTime = end;
        }

        // 判断指定时间是否在时间段内
        public boolean isWithinPeriod(LocalTime time) {
            if (startTime.isBefore(endTime)) {
                // 同一天的情况：4:58 - 5:02
                return !time.isBefore(startTime) && time.isBefore(endTime);
            } else {
                // 跨天的情况：23:00 - 1:00
                return !time.isBefore(startTime) || !time.isAfter(endTime);
            }
        }

        // 判断当前时间是否在时间段内
        public boolean isCurrentTimeWithinPeriod() {
            return isWithinPeriod(LocalTime.now());
        }
    }


}
