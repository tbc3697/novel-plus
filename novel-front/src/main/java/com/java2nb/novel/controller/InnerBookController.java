package com.java2nb.novel.controller;

import com.java2nb.novel.entity.Book;
import com.java2nb.novel.entity.BookContent;
import com.java2nb.novel.entity.BookIndex;
import com.java2nb.novel.service.BookContentService;
import com.java2nb.novel.service.BookService;
import com.java2nb.novel.vo.BookSpVO;
import io.github.xxyopen.model.page.PageBean;
import io.github.xxyopen.model.page.builder.pagehelper.PageBuilder;
import io.github.xxyopen.model.resp.RestResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 11797
 */
@RequestMapping("inner/book")
@RestController
@Slf4j
@RequiredArgsConstructor
public class InnerBookController extends BaseController {

    private final BookService bookService;
    private final Map<String, BookContentService> bookContentServiceMap;

    /**
     * 分页搜索
     */
    @GetMapping("searchByPage")
    public RestResult<?> searchByPage(BookSpVO bookSP,
                                      @RequestParam(value = "curr", defaultValue = "1") int page,
                                      @RequestParam(value = "limit", defaultValue = "20") int pageSize,
                                      HttpServletRequest request) {
        return RestResult.ok(bookService.searchByPage(bookSP, page, pageSize));
    }

    /**
     * 查询小说详情信息
     */
    @GetMapping("queryBookDetail/{id}")
    public RestResult<Book> queryBookDetail(@PathVariable("id") Long id) {
        return RestResult.ok(bookService.queryBookDetail(id));
    }

    /**
     * 目录
     */
    @GetMapping("/queryIndexList")
    public RestResult<PageBean<BookIndex>> indexList(Long bookId,
                                                     @RequestParam(value = "curr", defaultValue = "1") int page,
                                                     @RequestParam(value = "limit", defaultValue = "5") int pageSize,
                                                     @RequestParam(value = "orderBy", defaultValue = "index_num desc") String orderBy) {
        return RestResult.ok(PageBuilder.build(bookService.queryIndexList(bookId, orderBy, page, pageSize)));
    }


    /**
     * 目录
     */
    @SneakyThrows
    @RequestMapping("/book/indexList-{bookId}/all")
    public List<BookIndex> indexList(@PathVariable("bookId") Long bookId, Model model) {
        return bookService.queryIndexList(bookId, null, 1, null);
    }

    /**
     * 内容
     */
    @SneakyThrows
    @RequestMapping("/book/{bookId}/{bookIndexId}/content")
    public BookContent bookContent(@PathVariable("bookId") Long bookId, @PathVariable("bookIndexId") Long bookIndexId) {
        return bookContentServiceMap.get("db").queryBookContent(bookId, bookIndexId);
    }

}
