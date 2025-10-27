package com.java2nb.novel.fanqie;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FanQieConfig {
    private String baseUrl;
    private BookConfig bookConfig;
    private int begin = 1;
    private int end = 399;


    class BookConfig {
        private String baseUrl;
        private String detailUrl;
    }

    // https://fanqienovel.com/page/7280064899676376064?enter_from=stack-room&force_mobile=1



}
