package com.java2nb.novel.core.schedule.xxl;

import com.xxl.job.core.context.XxlJobContext;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.IJobHandler;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public abstract class AbstractJobHandler extends IJobHandler {

    protected abstract String innerExecute(final String param);

    protected abstract String getJobName();

    @Override
    public void execute() {
        try {
            long beginTime = System.currentTimeMillis();
            String taskName = getJobName();
            log.info("task '{}' exec begin", taskName);
            String param = XxlJobHelper.getJobParam() == null ? "" : XxlJobHelper.getJobParam();
            var msg = innerExecute(param);
            log.info("task '{}' exec end，time: {}", taskName, System.currentTimeMillis() - beginTime);
            XxlJobContext.getXxlJobContext().setHandleMsg(msg);
        } catch (Exception e) {
            log.error("task '{}' exec fail: {} ", getJobName(), e.getMessage(), e);
        } catch (Throwable e) {
            log.error("task '{}' exec fail, happened error: {} ", getJobName(), e.getMessage(), e);
        }
    }

}
