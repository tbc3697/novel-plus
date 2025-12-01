package com.java2nb.novel.utils;

import com.java2nb.novel.core.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator
 */
@Slf4j
@Component
public class CrawlHttpClient {
    private final CrawSimpleCounter counter = new CrawSimpleCounter();

    private final String DEF_LIMIT = "1000";

    // @Value("${crawl.interval.min}")
    // private Integer intervalMin;

    // @Value("${crawl.interval.max}")
    // private Integer intervalMax;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final Map<String, LocalDateTime> reqTimeMap = new ConcurrentHashMap<>();

    private final Random random = new Random();

    private static final ThreadLocal<Integer> RETRY_COUNT = new ThreadLocal<>();

    public String get(String url, String charset) {
        var success = true;
        try {
            return doGet(url, charset);
        } catch (Throwable throwable) {
            success = false;
            throw throwable;
        } finally {
            counter.add(success);
        }
    }

    public String doGet(String url, String charset) {
        safeFrequencyControl(url);
        String body = HttpUtil.getByHttpClientWithChrome(url, charset, getCookie());
        if (Objects.isNull(body) || body.length() < Constants.INVALID_HTML_LENGTH) {
            return processErrorHttpResult(url, charset);
        }
        // 成功获得html内容
        return body;
    }

    private String getCookie() {
        try {
            return redisTemplate.opsForValue().get("cookie");
        } catch (Throwable throwable) {
            return null;
        }
    }

    private String processErrorHttpResult(String url, String charset) {
        Integer count = RETRY_COUNT.get();
        if (count == null) {
            count = 0;
        }
        if (count < Constants.HTTP_FAIL_RETRY_COUNT) {
            RETRY_COUNT.set(++count);
            return get(url, charset);
        }
        RETRY_COUNT.remove();
        return null;
    }
    private int getReqInterval(String key) {
        return getReqInterval(key, 0);
    }
    private int getReqInterval(String key, int def) {
        var intervalStr = redisTemplate.opsForValue().get(key);
        if (Objects.nonNull(intervalStr)) {
            return Integer.parseInt(intervalStr);
        }
        return def;
    }

    private void safeFrequencyControl() {
        var intervalMin = getReqInterval("req:interval:min");
        var intervalMax = getReqInterval("req:interval:max");
        if (intervalMax > intervalMin) {
            try {
                Thread.sleep(random.nextInt(intervalMax - intervalMin + 1) + intervalMin);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    private void safeFrequencyControl(String url) {
        try {
            frequencyControl(url);
        } catch (Throwable throwable) {
            log.error("frequencyControl error: {}", throwable.getMessage(), throwable);
        }
    }

    private void frequencyControl(String url) {
        var intervalMin = getReqInterval("req:interval:min");
        var intervalMax = getReqInterval("req:interval:max");

        var domain = obtainDomain(url);
        var now = LocalDateTime.now();
        LocalDateTime lastReqTime = reqTimeMap.getOrDefault(domain, now);
        // 生成代码，取lastReqTime跟当前时间的差值毫秒数
        long diff = LocalDateTime.now().toInstant(java.time.ZoneOffset.of("+8")).toEpochMilli() - lastReqTime.toInstant(java.time.ZoneOffset.of("+8")).toEpochMilli();
        if (diff < intervalMin) {
            try {
                var sleepMin = random.nextInt(intervalMax - (int) diff + 1) + diff;
                Thread.sleep(sleepMin);
            } catch (InterruptedException e) {
                log.error("frequencyControl happened InterruptedException: {}", e.getMessage());
            } catch (Throwable throwable) {
                log.error("frequencyControl happened Throwable: {}", throwable.getMessage());
            }
        }
        reqTimeMap.put(domain, now);
    }

    private String obtainDomain(String url) {
        int index = url.indexOf("/", 8);
        if (index == -1) {
            return url;
        }
        return url.substring(0, index);
    }

    public static void main(String[] args) {
        var url = "https://www.uaa.com/novel/list";
        System.out.println(new CrawlHttpClient().obtainDomain( url));
    }

}
