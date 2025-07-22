package com.java2nb.novel.fanqie;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class FanqieResp {
    private final int code;
    private final FanQieRespData data;
    private final String message;
    private final String log_id;
}
