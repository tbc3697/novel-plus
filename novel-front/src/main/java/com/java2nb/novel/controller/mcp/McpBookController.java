package com.java2nb.novel.controller.mcp;

import com.java2nb.novel.entity.BookIndex;
import com.java2nb.novel.service.BookContentService;
import com.java2nb.novel.service.BookService;
import com.java2nb.novel.vo.BookContentVo;
import com.java2nb.novel.vo.BookIndexSimpleVo;
import com.java2nb.novel.vo.BookSpVO;
import com.java2nb.novel.vo.BookVO;
import io.github.xxyopen.model.page.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author mcp
 */
@RestController
@Slf4j
@RequestMapping("/mcp")
public class McpBookController {

    private final BookService bookService;
    private final BookContentService bookContentService;

    public McpBookController(BookService bookService,
                             @Qualifier("db") BookContentService contentService) {
        this.bookService = bookService;
        this.bookContentService = contentService;
    }

    @GetMapping("/book_list")
    @McpTool(name = "book_list", description = "查询book列表（支持关键词搜索和分页，关键字可以匹配名称或者作者）")
    public PageBean<?> bookList(@ToolParam(description = "检索关键字，可以模糊匹配书籍名称或者作者名称，允许为空", required = false) @RequestParam(required = false) String keyword,
                                @ToolParam(description = "页码,允许不传，不传默认是1", required = false) @RequestParam(required = false) int page,
                                @ToolParam(description = "每次条数,允许不传，默认是20", required = false) @RequestParam(required = false) int pageSize) {
        var pageNum = getIntOrDef(page, 1);
        var limit = getIntOrDef(pageSize, 20);
        var queryResult = bookService.searchByPage(BookSpVO.builder().keyword(keyword).build(), pageNum, limit);
        var list = queryResult.getList();
        var resultList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (BookVO bookVO : list) {
                resultList.add(bookVO.toSimple());
            }
        }
        return logRun("book_list", () -> PageBean.of(pageNum, limit, queryResult.getTotal(), resultList));
    }

    // @McpTool(name = "book_detail_tool", description = "查询数据列表（支持关键词搜索和分页）")
    // public RestResult<Book> bookDetailTool(@ToolParam(description = "id") Long bookId) {
    //     return bookDetail(bookId);
    // }

    @GetMapping("/book_index_all")
    @McpTool(name = "book_index_all", description = "根据bookId获取该book的章节列表")
    public List<BookIndexSimpleVo> indexList(@ToolParam(description = "bookId，必传") @RequestParam Long bookId) {
        return logRun("book_index_all", () -> {
            List<BookIndex> list = bookService.queryIndexList(bookId, null, 1, null);
            if (list == null || list.isEmpty()) {
                return List.of();
            }
            return list.stream().map(bi -> {
                return BookIndexSimpleVo.builder()
                        .bookId(bi.getBookId())
                        .bookIndexId(bi.getId())
                        .indexName(bi.getIndexName())
                        .wordCount(bi.getWordCount())
                        .build();
            }).toList();
        });
    }

    @McpTool(name = "book_index_content", description = "根据章节ID获取该章节内容")
    public BookContentVo bookContent(@ToolParam(description = "bookIndexId，不能为空") @RequestParam Long bookIndexId) {
        return logRun("book_index_content", () -> {
            var qr = bookContentService.queryBookContent(null, bookIndexId);
            if (qr == null) {
                return null;
            }
            return BookContentVo.builder().content(qr.getContent()).id(qr.getId()).indexId(qr.getIndexId()).build();
        });
    }

    // private RestResult<Book> bookDetail(@PathVariable("id") Long id) {
    //     return RestResult.ok(bookService.queryBookDetail(id));
    // }

    private <R> R logRun(String tool, Supplier<R> runner) {
        var beginTime = System.currentTimeMillis();
        R r = runner.get();
        log.info("call tool:{}, time:{}, result:{}", tool, System.currentTimeMillis() - beginTime, r);
        return r;
    }

    private int getIntOrDef(int value, int def) {
        return value == 0 ? def : value;
    }

}
