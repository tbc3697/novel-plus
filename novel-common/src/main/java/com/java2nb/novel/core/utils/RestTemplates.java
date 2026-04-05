package com.java2nb.novel.core.utils;

import com.java2nb.novel.core.config.HttpProxyProperties;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.hc.client5.http.auth.AuthScope;
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.socket.ConnectionSocketFactory;
import org.apache.hc.client5.http.socket.PlainConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.config.Registry;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.ssl.SSLContexts;
import org.apache.hc.core5.ssl.TrustStrategy;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.net.http.HttpClient;
import java.nio.charset.Charset;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

@Component
public class RestTemplates {

    private static HttpProxyProperties httpProxyProperties;

    RestTemplates(HttpProxyProperties properties) {
        httpProxyProperties = properties;
    }

    @SneakyThrows
    public static RestTemplate newInstance(String charset) {

        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

        // 忽略证书
        SSLContext sslContext = SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", csf)
                .build();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);

        // 连接池的最大连接数，0代表不限；如果取0，需要考虑连接泄露导致系统崩溃的后果
        connectionManager.setMaxTotal(1000);
        // 每个路由的最大连接数,如果只调用一个地址,可以将其设置为最大连接数
        connectionManager.setDefaultMaxPerRoute(300);

        HttpClientBuilder clientBuilder = HttpClients.custom();
        // 禁用 Cookie 管理
        clientBuilder.disableCookieManagement();
        if (Objects.nonNull(httpProxyProperties) && Boolean.TRUE.equals(httpProxyProperties.getEnabled())) {
            HttpHost proxy = new HttpHost(httpProxyProperties.getIp(), httpProxyProperties.getPort());
            clientBuilder.setProxy(proxy);
            if (StringUtils.isNotBlank(httpProxyProperties.getUsername()) && StringUtils.isNotBlank(
                    httpProxyProperties.getPassword())) {
                // 创建CredentialsProvider实例并添加代理认证信息
                BasicCredentialsProvider provider = new BasicCredentialsProvider();
                UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(
                        httpProxyProperties.getUsername(), httpProxyProperties.getPassword().toCharArray());
                provider.setCredentials(new AuthScope(null, -1), credentials);
                clientBuilder.setDefaultCredentialsProvider(provider);
            }
        }
        CloseableHttpClient httpClient = clientBuilder.setConnectionManager(connectionManager)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpClient);
        requestFactory.setConnectionRequestTimeout(3000);
        requestFactory.setConnectTimeout(3000);
        requestFactory.setReadTimeout(30000);

        RestTemplate restTemplate = new RestTemplate(requestFactory);
        List<HttpMessageConverter<?>> list = restTemplate.getMessageConverters();
        for (HttpMessageConverter<?> httpMessageConverter : list) {
            if (httpMessageConverter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter) httpMessageConverter).setDefaultCharset(Charset.forName(charset));
                break;
            }
        }
        return restTemplate;
    }

    // 1. 配置 JDK 11+ 自带的 HttpClient（可自定义超时、Cookie 管理等）
    static HttpClient jdkHttpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10)) // 连接超时
//                .timeout(Duration.ofSeconds(10)) // 响应超时
            .followRedirects(HttpClient.Redirect.NORMAL) // 跟随重定向（和之前适配逻辑一致）
            // 若需 Cookie 管理，添加 CookieHandler（和 JDK HttpClient 配置一致）
            // .cookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_ALL))
            .build();

    // 2. 创建 JDK HttpClient 适配工厂（Spring 5.3+ 提供）
    static JdkClientHttpRequestFactory requestFactory = new JdkClientHttpRequestFactory(jdkHttpClient);


    @SneakyThrows
    public static RestTemplate newInstance2(String charset) {


        // 3. 构建 RestTemplate，绑定适配工厂
        var restTemplate = new RestTemplate(requestFactory);
        List<HttpMessageConverter<?>> list = restTemplate.getMessageConverters();
        for (HttpMessageConverter<?> httpMessageConverter : list) {
            if (httpMessageConverter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter) httpMessageConverter).setDefaultCharset(Charset.forName(charset));
                break;
            }
        }

        // interceptors
        // restTemplate.getInterceptors().add((request, body, execution) -> {
        //     // System.out.println("=== Outgoing Request Headers ===");
        //     // request.getHeaders().forEach((key, value) -> System.out.println(key + ": " + value));
        //
        //     var response = execution.execute(request, body);
        //     // 打印响应头
        //     // System.out.println("=== Incoming Response Headers ===");
        //     // response.getHeaders().forEach((key, value) -> System.out.println(key + ": " + value));
        //     return response;
        // });
        return restTemplate;
    }

}
