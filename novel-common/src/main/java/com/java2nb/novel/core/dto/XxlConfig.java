package com.java2nb.novel.core.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class XxlConfig {
    private String adminAddresses;
    private String appName;
    private String ip;
    private int port;
    private String accessToken;
    private String logPath;
    private int logRetentionDays;

    private boolean enable;

}
