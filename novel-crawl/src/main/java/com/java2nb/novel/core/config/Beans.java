package com.java2nb.novel.core.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    // @Bean
    public XxlJobSpringExecutor xxlJobExecutor(IConfigService configService) {
        var xxlConfig = configService.getXxlConfig();
        final XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor(xxlConfig.isEnable());
        xxlJobSpringExecutor.setAdminAddresses(xxlConfig.getAdminAddresses());
        xxlJobSpringExecutor.setAppname(xxlConfig.getAppName());
        xxlJobSpringExecutor.setIp(xxlConfig.getIp());
        xxlJobSpringExecutor.setPort(xxlConfig.getPort());
        xxlJobSpringExecutor.setAccessToken(xxlConfig.getAccessToken());
        xxlJobSpringExecutor.setLogPath(xxlConfig.getLogPath());
        xxlJobSpringExecutor.setLogRetentionDays(xxlConfig.getLogRetentionDays());
        return xxlJobSpringExecutor;
    }
}
