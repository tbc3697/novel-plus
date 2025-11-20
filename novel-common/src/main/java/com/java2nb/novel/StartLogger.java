package com.java2nb.novel;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

import java.util.List;

@Slf4j
public class StartLogger {
    public static List<String> LOGGING_EVN_KEY = List.of(
            "spring.data.redis.host",
            "spring.data.redis.port"
    );

    public static void started(ApplicationContext context) {
        var environment = context.getEnvironment();
        for (String s : LOGGING_EVN_KEY) {
            log.info("{}: {}", s, environment.getProperty(s));
        }
    }
}
