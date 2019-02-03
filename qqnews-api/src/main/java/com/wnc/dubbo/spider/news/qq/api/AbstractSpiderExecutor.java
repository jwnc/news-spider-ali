package com.wnc.dubbo.spider.news.qq.api;

public abstract class AbstractSpiderExecutor implements SpiderTask{

    public SpiderTaskResult execute(){
        SpiderTaskEnv spiderTaskEnv = beforeTask();
        SpiderTaskResult spiderTaskResult = doTask(spiderTaskEnv);
        afterTask(spiderTaskResult, spiderTaskEnv);
        return  spiderTaskResult;
    }

}
