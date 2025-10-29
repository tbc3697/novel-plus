package com.java2nb.novel.vo;

import lombok.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@RequiredArgsConstructor
@ToString
@Builder(toBuilder = true)
@AllArgsConstructor
public class CrawlRunningTaskVo {
    private final Integer sourceId;
    private Map<Integer, Integer> catPage = new ConcurrentHashMap<>();

    public static CrawlRunningTaskVo init(Integer sourceId) {
        return CrawlRunningTaskVo.builder().sourceId(sourceId).build();
    }

    public void pageIncrease(Integer catId) {

    }

    public Integer getPage(Integer catId) {
        return catPage.getOrDefault(catId, 1);
    }
}
