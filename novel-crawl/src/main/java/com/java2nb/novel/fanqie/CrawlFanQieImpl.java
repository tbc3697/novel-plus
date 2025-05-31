package com.java2nb.novel.fanqie;

import com.alibaba.fastjson2.JSON;
import com.java2nb.novel.service.CrawlService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RequiredArgsConstructor
public class CrawlFanQieImpl {
    private final String baseUrl = "https://fanqienovel.com/api/author/library/book_list/v0/?page_count=18&page_index=0&gender=-1&category_id=91&creation_status=0&word_count=-1&book_type=-1";

    private final CrawlService crawlService;

    public static void main(String[] args) {

    }

    @SneakyThrows
    public void crawl(Integer sourceId) {
        var source = crawlService.getCrawlSource(sourceId);

        // 列表页
        // 书页
        // index
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder().GET().uri(new URI(baseUrl)).build();
        var r = client.send(request, HttpResponse.BodyHandlers.ofString());
        var body = r.body();
        FanqieResp bodyObj = JSON.parseObject(body, FanqieResp.class);
//        var decodedBody = FontUtil.decode(JSON.toJSONString(bodyObj.getData().getBook_list().get(0)));
        var list = bodyObj.getData().getBook_list();
        if (list != null && !list.isEmpty()) {
            for (BookListItem item : list) {
                var bookId = item.getBook_id();
                crawlService.parseBookAndSave(1, null, sourceId, bookId);
            }
        }

    }
}
