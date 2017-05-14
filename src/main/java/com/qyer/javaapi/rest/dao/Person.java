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

     List<User> getPersons();
    /**
     * Returns a podcast given its id
     *
     * @param id
     * @return
     */
    public User getPersonById(Integer id);
    public User getPersonByAccount(String tel);

    public Integer deletePersonById(Integer id);

    public Integer createPerson(User user);

    public Integer updatePerson(User user);

}
