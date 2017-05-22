package com.qyer.javaapi.rest.dao;

import com.qyer.javaapi.rest.entity.City;
import org.springframework.stereotype.Repository;

/**
 * Created by panqiang on 2017/5/16.
 */
@Repository
public interface Location {
    City getCityById(int id);
    City getCityByName(String cityName);
    Integer createCity(City city);
    Integer updateCity(City city);
}
