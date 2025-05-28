package com.java2nb.novel.fanqie;

import com.java2nb.novel.service.CrawlService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CrawlFanQieImpl {

    private final CrawlService crawlService;

    public void crawl() {
        // 列表页
        // 书页
        // index


        //
        crawlService.parseBookAndSave(1, null, 99, null);
    }
}
