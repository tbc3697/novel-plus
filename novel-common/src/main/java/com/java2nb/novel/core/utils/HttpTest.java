package com.java2nb.novel.core.utils;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.apache.hc.client5.http.impl.LaxRedirectStrategy;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.protocol.HttpClientContext;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;
import java.util.Random;

public class HttpTest {
    public static void main(String[] args) throws Exception {
        String targetUrl = "https://www.uaa.com/novel/list";
//        jdk(targetUrl);
        httpClient5(targetUrl);
    }

    private static void jdk(String url) throws IOException, InterruptedException {
        // 1. 配置 HttpClient（模仿 Postman：Cookie 管理+重定向+超时）
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        HttpClient httpClient = HttpClient.newBuilder()
                .cookieHandler(cookieManager)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        // 2. 第一步：GET 请求（模仿 Postman 先访问页面，获取 Cookie 和 CSRF Token）
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                .header("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8")
//                .header("Referer", url)
                .header("Referer", "www.uaa.com")
//                .header("Connection", "keep-alive")
                .GET()
                .build();

        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("GET 响应状态码：" + getResponse.statusCode());
//        System.out.println("GET 响应：" + getResponse.body());

    }

    private static void httpClient5(String url) throws IOException, InterruptedException {
// 1. 配置 Cookie 存储
        BasicCookieStore cookieStore = new BasicCookieStore();

        // 2. 构建 HttpClient（5.x 配置方式略有调整）
        try (CloseableHttpClient httpClient = HttpClients.custom()
//                .setCookieStore(cookieStore)
                .setDefaultCookieStore(cookieStore)
                .setRedirectStrategy(new LaxRedirectStrategy()) // 跟随重定向
//                .setConnectionTimeToLive(TimeValue.ofSeconds(10)) // 连接超时
                .disableAutomaticRetries()
                .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36")
                .addRequestInterceptorFirst((request, detail, context) -> {
                    Arrays.stream(request.getHeaders()).forEach(header -> {
                        System.out.println(header.getName() + ": " + header.getValue());
                    });
                    request.removeHeaders("Via");
                    request.removeHeaders("X-Forwarded-For");
                    request.removeHeaders("X-Requested-With"); // 避免被识别为 AJAX 爬虫
                    request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36");
                })
                .build()) {

            // 3. 随机延迟（防频率限制）
            Thread.sleep(new Random().nextInt(1000) + 500);

            // 4. 构建 GET 请求（复制 Postman 请求头）
            HttpGet httpGet = new HttpGet(url);
            // 强制重复设置 UA（防止 5.4.x 底层覆盖）
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36");
            httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
            httpGet.setHeader("Accept-Encoding", "gzip, deflate, br, zstd"); // 5.4.x 支持自动解压，无需手动处理
            httpGet.setHeader("Referer", "www.uaa.com"); // 适配目标域名，避免来源校验失败
            httpGet.setHeader("Connection", "keep-alive");
            httpGet.setHeader("Upgrade-Insecure-Requests", "1");
            // 补充 Chrome 特有头（5.4.x 需显式添加，JDK  HttpClient 会自动携带）
            httpGet.setHeader("Sec-Fetch-Dest", "document");
            httpGet.setHeader("Sec-Fetch-Mode", "navigate");
            httpGet.setHeader("Sec-Fetch-Site", "none");
            httpGet.setHeader("Sec-Fetch-User", "?1");
            httpGet.setHeader("Sec-Ch-Ua", "\"Chromium\";v=\"138\", \"Google Chrome\";v=\"138\", \"Not=A?Brand\";v=\"99\""); // 5.4.x 需手动添加 UA 品牌头
            httpGet.setHeader("Sec-Ch-Ua-Mobile", "?0");
            httpGet.setHeader("Sec-Ch-Ua-Platform", "\"Windows\"");

            // 5. 发送请求
            HttpClientContext context = HttpClientContext.create();
            try (CloseableHttpResponse response = httpClient.execute(httpGet, context)) {
                // 6. 打印结果
                System.out.println("响应状态码：" + response.getCode());
//                HttpEntity entity = response.getEntity();
//                String responseBody = entity != null ? EntityUtils.toString(entity, "UTF-8") : "";
//                System.out.println("响应体：" + responseBody);

            }
        }
    }
}
