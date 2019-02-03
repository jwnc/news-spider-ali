
package com.wnc.dubbo.news.qq.jpa.repo;

import com.wnc.dubbo.news.qq.jpa.entity.QqNews;
import org.springframework.data.repository.CrudRepository;

public interface QQNewsRepository
        extends CrudRepository<QqNews, String>
{
}