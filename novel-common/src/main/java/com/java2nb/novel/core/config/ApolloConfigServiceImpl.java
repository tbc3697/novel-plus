package com.java2nb.novel.core.config;

import com.java2nb.novel.core.dto.XxlConfig;
import com.java2nb.novel.core.utils.ApolloUtils;
import org.springframework.stereotype.Service;

@Service
public class ApolloConfigServiceImpl implements IConfigService {

    @Override
    public XxlConfig getXxlConfig() {
        return ApolloUtils.getObjConfig("xxl.job.config", XxlConfig.class);
    }
}
