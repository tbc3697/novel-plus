package com.java2nb.novel.core.listener;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.java2nb.novel.core.crawl.CrawlParser;
import com.java2nb.novel.core.crawl.RuleBean;
import com.java2nb.novel.entity.Book;
import com.java2nb.novel.entity.BookIndex;
import com.java2nb.novel.entity.CrawlSingleTask;
import com.java2nb.novel.entity.CrawlSource;
import com.java2nb.novel.service.BookService;
import com.java2nb.novel.service.CrawlService;
import com.java2nb.novel.utils.Constants;
import jakarta.servlet.ServletContext;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class StarterListener implements ServletContextInitializer {

    private final BookService bookService;

    private final CrawlService crawlService;

    private final CrawlParser crawlParser;

    private final RedisTemplate<String, String> redisTemplate;

    @Value("${crawl.update.thread}")
    private int updateThreadCount;

    private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1, new ThreadFactoryBuilder().setNameFormat("crawl-waitingStopFlag-%d").build());

    @Override
    public void onStartup(ServletContext servletContext) {
        processCrawlWaiting();

        var config = getCrawlConfig();
        log.info("crawl config:{}", config);
        for (int i = 0; i < updateThreadCount; i++) {
            new Thread(() -> {
                log.info("程序启动,开始执行自动更新线程。。。");
                while (true) {
                    if (config.isEnableUpdate()) {
                        doUpdate();
                    } else {
                        try {
                            TimeUnit.SECONDS.sleep(config.getUpdateInterval());
                        } catch (InterruptedException e) {
                            log.error(e.getMessage(), e);
                        }
                    }
                }
            }, "crawl-update-" + i).start();
        }

        new Thread(() -> {
            log.info("程序启动,开始执行单本采集任务线程。。。");
            doSingle(config.getSingleInterval());
        }, "crawl-single").start();
    }

    private void processCrawlWaiting() {
        log.info("程序启动,开始启动 waitingStopFlag 任务。。。");
        executor.scheduleAtFixedRate(() -> {
            try {
                var flag = redisTemplate.opsForValue().get("crawl:waiting:stop");
                if ("true".equals(flag)) {
                    crawlParser.stopWaiting();
                    redisTemplate.opsForValue().set("crawl:waiting:stop", "false");
                }
            } catch (Throwable e) {
                log.error("flush waitingStopFlag fail:{}", e.getMessage(), e);
            }
        }, 0, 30, TimeUnit.SECONDS);
        log.info("程序启动, waitingStopFlag 任务已开启");
    }

    private void doUpdate() {
        var config = getCrawlConfig();
        var sleepSeconds = config.getUpdateInterval();
        try {
            // 1.查询最新目录更新时间在一个月之内的前100条需要更新的数据
            Date currentDate = new Date();
            Date startDate = DateUtils.addDays(currentDate, -config.getUpdatePreDays());
            List<Book> bookList;
            synchronized (this) {
                bookList = bookService.queryNeedUpdateBook(startDate, 100);
            }
            for (Book needUpdateBook : bookList) {
                try {
                    // 查询爬虫源规则
                    CrawlSource source = crawlService.queryCrawlSource(needUpdateBook.getCrawlSourceId());
                    RuleBean ruleBean = new ObjectMapper().readValue(source.getCrawlRule(), RuleBean.class);
                    // 解析小说基本信息
                    crawlParser.parseBook(ruleBean, needUpdateBook.getCrawlBookId(), book -> {
                        // 这里只做老书更新
                        book.setId(needUpdateBook.getId());
                        book.setWordCount(needUpdateBook.getWordCount());
                        if (needUpdateBook.getPicUrl() != null && needUpdateBook.getPicUrl()
                                .contains(Constants.LOCAL_PIC_PREFIX)) {
                            // 本地图片则不更新
                            book.setPicUrl(null);
                        }
                        // 查询已存在的章节
                        Map<Integer, BookIndex> existBookIndexMap = bookService.queryExistBookIndexMap(
                                needUpdateBook.getId());
                        // 解析章节目录
                        crawlParser.parseBookIndexAndContent(needUpdateBook.getCrawlBookId(), book,
                                ruleBean, needUpdateBook.getCrawlSourceId(), existBookIndexMap,
                                chapter -> bookService.updateBookAndIndexAndContent(book,
                                        chapter.getBookIndexList(),
                                        chapter.getBookContentList(), existBookIndexMap), null);
                    });
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }

            }
            //  休眠10分钟
            TimeUnit.SECONDS.sleep(sleepSeconds);
        } catch (Throwable e) {
            log.error("更新遇到问题：{}", e.getMessage(), e);
        }
    }

    private void doSingle(long sleepSeconds) {
        while (true) {
            CrawlSingleTask task = null;
            byte crawlStatus = 0;
            try {
                // 获取采集任务
                task = crawlService.getCrawlSingleTask();

                if (task != null) {
                    // 查询爬虫规则
                    CrawlSource source = crawlService.queryCrawlSource(task.getSourceId());
                    RuleBean ruleBean = new ObjectMapper().readValue(source.getCrawlRule(), RuleBean.class);
                    if (crawlService.parseBookAndSave(task.getCatId(), ruleBean, task.getSourceId(),
                            task.getSourceBookId(), task)) {
                        // 采集成功
                        crawlStatus = 1;
                    }

                }

                // 休眠1分钟
                TimeUnit.SECONDS.sleep(sleepSeconds);

            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }

            if (task != null) {
                crawlService.updateCrawlSingleTask(task, crawlStatus);
            }

        }
    }

    private CrawlConfig getCrawlConfig() {
        var configStr = redisTemplate.opsForValue().get("crawl:single:update:config");
        if (configStr == null) {
            return new CrawlConfig();
        }
        return JSON.parseObject(configStr, CrawlConfig.class);
    }

    @Getter
    @ToString
    @RequiredArgsConstructor
    static class CrawlConfig {
        private final boolean enableUpdate = false;
        private final long updateInterval = 120L;

        private final boolean enableSingle = true;
        private final long singleInterval = 120L;

        private final int updatePreDays = 365;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new CrawlConfig()));
    }
}
