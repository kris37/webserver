package com.qyer.javaapi.rest.dao;

import com.qyer.javaapi.rest.entity.TestPersonBean;

import java.util.List;

/**
 * Created by panqiang on 2017/5/2.
 */
public interface TestDao {

     List<TestPersonBean> getPersons();
    /**
     * Returns a podcast given its id
     *
     * @param id
     * @return
     */
    public TestPersonBean getPersonById(Long id);

    public Long deletePersonById(Long id);

    public Long createPerson(TestPersonBean tbp);

    public int updatePerson(TestPersonBean tbp);

    /** removes all podcasts */
    public void deletePersons();
}
