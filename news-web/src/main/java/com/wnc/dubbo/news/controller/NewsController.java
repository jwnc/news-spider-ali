package com.wnc.dubbo.news.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wnc.dubbo.spider.news.qq.api.QqNewsSearch;
import com.wnc.dubbo.spider.news.qq.api.QqNewsSpider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Reference
    private QqNewsSearch qqNewsSearch;
    @Reference
    private QqNewsSpider qqNewsSpider;

    @Value("${dubbo.application.name}")
    private String a;

    @RequestMapping("/qq")
    @ResponseBody
    public String a(){
        qqNewsSearch.search("title "+ a);
        qqNewsSpider.doTask();
        return  "SUCCESS!";
    }
}
