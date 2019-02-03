
package com.wnc.dubbo.news.qq.jpa.repo;

import com.wnc.dubbo.news.qq.jpa.entity.QqUser;
import org.springframework.data.repository.CrudRepository;

public interface QQUserRepository
        extends CrudRepository<QqUser, String>
{
}