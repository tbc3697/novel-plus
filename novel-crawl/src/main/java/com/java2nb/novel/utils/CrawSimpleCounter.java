package com.java2nb.novel.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class CrawSimpleCounter {

    private AtomicInteger successCount = new AtomicInteger(0);
    private AtomicInteger failCount = new AtomicInteger(0);


    public void addSuccess() {
        successCount.incrementAndGet();
    }

    public void addFail() {
        failCount.incrementAndGet();
    }

    public void add(boolean isSuccess) {
        if (isSuccess) {
            addSuccess();
        } else {
            addFail();
        }
    }

    public void reset() {
        successCount.set(0);
        failCount.set(0);
    }

    public Integer getCount() {
        return successCount.get() + failCount.get();
    }

    public String summary() {
        var successCount = this.successCount.get();
        var failCount = this.failCount.get();

        return String.format("successCount:%d,failCount:%d, allCount:%d", successCount, failCount, successCount + failCount);
    }

}
