
package com.wnc.dubbo.news.qq.service;

import com.alibaba.fastjson.JSONObject;
import com.wnc.dubbo.news.qq.jpa.entity.QqNews;
import com.wnc.dubbo.news.qq.jpa.entity.QqUser;
import com.wnc.dubbo.news.qq.jpa.repo.QQCertInfoRepository;
import com.wnc.dubbo.news.qq.jpa.repo.QQNewsImgRepository;
import com.wnc.dubbo.news.qq.jpa.repo.QQNewsRepository;
import com.wnc.dubbo.news.qq.jpa.repo.QQUserRepository;
import com.wnc.dubbo.news.qq.jpa.repo.QqNewsKeywordRepository;
import com.wnc.dubbo.news.qq.jpa.repo.QqNewsTagLabelRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class QqDbService {
    private static Logger logger = Logger.getLogger(QqDbService.class);

    @Autowired
    private QQUserRepository qqUserRepository;
    @Autowired
    private QQCertInfoRepository qqCertInfoRepository;
    @Autowired
    private QQNewsRepository qqNewsRepository;
    @Autowired
    private QQNewsImgRepository qqNewsImgRepository;
    @Autowired
    private QqNewsTagLabelRepository qNewsTagLabelRepository;
    @Autowired
    private QqNewsKeywordRepository qqNewsKeyWordRepository;
    @Transactional
    public synchronized void singleUser(QqUser qqUser) {
        try {
            if (qqUser.getCertinfo() != null) {
                qqCertInfoRepository.save(qqUser.getCertinfo());
            }
            qqUserRepository.save(qqUser);
        } catch (Exception e) {
            logger.error(qqUser.getUserid() + qqUser.getNick() + " 插入失败!", e);
        }
    }
    @Transactional
    public synchronized void singleUser(JSONObject userJO) {
        try {
            QqUser qqUser = JSONObject.parseObject(userJO.toJSONString(), QqUser.class).splitRegion().computeCertId();
            singleUser(qqUser);
        } catch (Exception e) {
            logger.error(userJO.toJSONString() + " 插入QQ用户失败!", e);
        }
    }

    @Transactional
    public synchronized  void singleNews(JSONObject news) {
        try {
            QqNews qqNews = JSONObject.parseObject(news.toJSONString(), QqNews.class).cvtAll();
            if(qqNews.getTagLabelList() != null){
                qNewsTagLabelRepository.saveAll(qqNews.getTagLabelList());
            }
            if(qqNews.getKeywordList() != null){
                qqNewsKeyWordRepository.saveAll(qqNews.getKeywordList());
            }

            qqNewsRepository.save(qqNews);

            if (qqNews.getIrsImgList() != null) {
                qqNewsImgRepository.saveAll(qqNews.getIrsImgList());
            }
        } catch (Exception e) {
            logger.error(news.toJSONString() + " 插入QQ新闻失败!", e);
        }
    }
}
