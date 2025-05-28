package com.java2nb.novel.fanqie;

import com.java2nb.novel.service.CrawlService;
import com.java2nb.novel.service.impl.CrawlServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RequiredArgsConstructor
public class CrawlFanQieImpl {
    private final String baseUrl = "https://fanqienovel.com/api/author/library/book_list/v0/?page_count=18&page_index=0&gender=-1&category_id=-1&book_type=-1";

    private final CrawlService crawlService;

    public static void main(String[] args) {
        new CrawlFanQieImpl(null).crawl();
    }

    @SneakyThrows
    public void crawl() {
        var map = ForntUtil.getFmS();
        // 列表页
        // 书页
        // index
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder().GET().uri(new URI(baseUrl)).build();
        var r = client.send(request, HttpResponse.BodyHandlers.ofString());
        var body = r.body();
        var l = body.length();
        var result = new StringBuilder();
        for (int i = 0; i < l; i++) {
            var c = body.charAt(i);
            int k = c;
            var v = map.get(String.valueOf(k));
            if (v == null) {
                v = String.valueOf(c);
            }
            result.append(v);
        }
        System.out.println(result.toString());
        //
//        crawlService.parseBookAndSave(1, null, 99, null);
    }
}
