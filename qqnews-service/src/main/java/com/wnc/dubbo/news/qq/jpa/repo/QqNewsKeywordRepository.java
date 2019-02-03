
package com.wnc.dubbo.news.qq.jpa.repo;

import com.wnc.dubbo.news.qq.jpa.entity.QqNewsKeyWord;
import org.springframework.data.repository.CrudRepository;

public interface QqNewsKeywordRepository
        extends CrudRepository<QqNewsKeyWord, String>
{
}