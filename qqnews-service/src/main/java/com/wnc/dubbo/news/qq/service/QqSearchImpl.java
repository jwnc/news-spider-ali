package com.wnc.dubbo.news.qq.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wnc.dubbo.spider.news.qq.api.QqNewsSearch;

@Service
public class QqSearchImpl implements QqNewsSearch {
    @Override
    public String search(String key) {
        System.out.println("you search " + key + " from qq.");
        return "qq search return " + key;
    }
}
