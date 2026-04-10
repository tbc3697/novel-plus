package com.java2nb.novel.controller.mcp;

import com.java2nb.novel.entity.Book;
import com.java2nb.novel.entity.BookContent;
import com.java2nb.novel.entity.BookIndex;
import com.java2nb.novel.service.BookContentService;
import com.java2nb.novel.service.BookService;
import com.java2nb.novel.vo.BookSpVO;
import com.java2nb.novel.vo.BookVO;
import io.github.xxyopen.model.page.PageBean;
import io.github.xxyopen.model.resp.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author mcp
 */
@Component
@Slf4j
public class McpBookController {

    private final BookService bookService;
    private final BookContentService bookContentService;

    public McpBookController(BookService bookService,
                             @Qualifier("db") BookContentService contentService) {
        this.bookService = bookService;
        this.bookContentService = contentService;
    }

    @McpTool(name = "book_list", description = "查询book列表（支持关键词搜索和分页，关键字可以匹配名称或者作者）")
    public PageBean<?> bookList(@ToolParam(description = "检索关键字，可以模糊匹配书籍名称或者作者名称，允许为空", required = false) String keyword,
                                @ToolParam(description = "页码,允许不传，不传默认是1", required = false) int page,
                                @ToolParam(description = "每次条数,允许不传，默认是20", required = false) int pageSize) {
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

    @McpTool(name = "book_index_all", description = "根据bookId获取该book的章节列表")
    public List<BookIndex> indexList(@ToolParam(description = "bookId，必传") Long bookId) {
        return logRun("book_index_all", ()->bookService.queryIndexList(bookId, null, 1, null));
    }

    @McpTool(name = "book_index_content", description = "根据章节ID获取该章节内容")
    public BookContent bookContent(@ToolParam(description = "bookIndexId，不能为空") Long bookIndexId) {
        return logRun("book_index_content", ()->bookContentService.queryBookContent(null, bookIndexId));
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
