package com.qyer.javaapi.rest.dao;

import java.util.List;

/**
 * Created by panqiang on 2017/5/2.
 */
public interface TestDao {

     List<TestDao> getTestDaos();
    /**
     * Returns a podcast given its id
     *
     * @param id
     * @return
     */
    public TestDao getPodById(Long id);

    public Long deletePodById(Long id);

    public Long createPod(TestDao podcast);

    public int updatePod(TestDao podcast);

    /** removes all podcasts */
    public void deletePodcasts();
}
