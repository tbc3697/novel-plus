package com.java2nb.novel.core.schedule.xxl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component(CrawExecJobHandler.NAME)
@RequiredArgsConstructor
public class CrawExecJobHandler extends AbstractJobHandler {
    public final static String NAME = "CrawExecJobHandler";


    @Override
    protected String innerExecute(String param) {

        return null;
    }

    @Override
    public String getJobName() {
        return NAME;
    }
}
