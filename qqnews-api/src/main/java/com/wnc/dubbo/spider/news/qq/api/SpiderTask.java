package com.wnc.dubbo.spider.news.qq.api;

public interface SpiderTask {
    SpiderTaskEnv beforeTask();

    SpiderTaskResult doTask(SpiderTaskEnv spiderTaskEnv);

    void afterTask(SpiderTaskResult spiderTaskResult, SpiderTaskEnv spiderTaskEnv);
}
