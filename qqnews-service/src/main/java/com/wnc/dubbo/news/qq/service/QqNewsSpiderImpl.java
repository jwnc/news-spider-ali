package com.wnc.dubbo.news.qq.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.crawl.core.util.HttpClientUtil;
import com.wnc.dubbo.spider.news.qq.api.AbstractSpiderExecutor;
import com.wnc.dubbo.spider.news.qq.api.QqNewsSpider;
import com.wnc.dubbo.spider.news.qq.api.SpiderTaskEnv;
import com.wnc.dubbo.spider.news.qq.api.SpiderTaskResult;

import java.io.IOException;

@Service
public class QqNewsSpiderImpl extends AbstractSpiderExecutor implements QqNewsSpider {

    @Override
    public SpiderTaskResult doTask() {
        System.out.println("QqNewsSpiderImpl doTask..");
        try {
            String webPage = HttpClientUtil.getWebPage("http://www.baidu.com");
            System.out.println(webPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.execute();
    }

    @Override
    public SpiderTaskEnv beforeTask() {
        return null;
    }

    @Override
    public SpiderTaskResult doTask(SpiderTaskEnv spiderTaskEnv) {
        return null;
    }

    @Override
    public void afterTask(SpiderTaskResult spiderTaskResult, SpiderTaskEnv spiderTaskEnv) {

    }
}
