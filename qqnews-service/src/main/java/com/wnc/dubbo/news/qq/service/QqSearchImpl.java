package com.wnc.dubbo.news.qq.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wnc.dubbo.spider.news.qq.api.QqNewsSearch;

@Service
public class QqSearchImpl implements QqNewsSearch {
    @Override
    public void search(String key) {
        System.out.println("you search " + key + " from qq.");
    }
}
