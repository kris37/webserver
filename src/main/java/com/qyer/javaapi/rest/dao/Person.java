package com.qyer.javaapi.rest.dao;

import com.qyer.javaapi.rest.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by panqiang on 2017/5/2.
 * Repository标签是用来给持久层的类定义一个名字，让Spring根据这个名字关联到这个类。
    例如：
    Repository("userDao")
 */

@Repository
public interface Person {

     String getInfoById(Integer id);//一并获取关联表字段信息，例如城市详情
    /**
     * @param id
     * @return
     */
    User getPersonById(Integer id);
    User getPersonByAccount(String tel);
    Integer deletePersonById(Integer id);
    Integer createPerson(User user);
    Integer updatePerson(User user);

}
