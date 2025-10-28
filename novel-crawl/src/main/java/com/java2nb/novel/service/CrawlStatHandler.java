package com.java2nb.novel.service;

public interface CrawlStatHandler {

    void start(Integer sourceId);

    void stop(Integer sourceId);

    void auto();

    void stopAuto();

    void resetOffset(Integer sourceId, int  offset);

    boolean running(Integer sourceId);

}
