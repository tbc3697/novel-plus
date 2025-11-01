package com.java2nb.novel.core.config;

import com.alibaba.fastjson2.JSON;
import com.java2nb.novel.core.dto.XxlConfig;
import org.springframework.stereotype.Service;

@Service
public class ApolloConfigServiceImpl implements IConfigService {

    @Override
    public XxlConfig getXxlConfig() {
//        return ApolloUtils.getObjConfig("xxl.job.config", XxlConfig.class);
        return JSON.parseObject("{\n" +
                "    \"adminAddresses\": \"http://localhost:8001/xxl-job-admin\",\n" +
                "    \"appName\": \"homeSmart\",\n" +
                "    \"ip\": \"\",\n" +
                "    \"port\": 8009,\n" +
                "    \"accessToken\": \"t!b@c#123\",\n" +
                "    \"logPath\": \"/Users/tbc/opt/homesmart/logs/jobhandler\",\n" +
                "    \"logRetentionDays\": 3,\n" +
                "    \"enable\": true\n" +
                "}", XxlConfig.class);
    }
}
