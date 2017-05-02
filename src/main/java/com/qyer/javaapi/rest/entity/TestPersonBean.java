package com.qyer.javaapi.rest.entity;

/**
 * Created by panqiang on 2017/5/2.
 */

import com.oracle.webservices.internal.api.databinding.Databinding;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class TestPersonBean implements Serializable {

    public TestPersonBean(){}
    public TestPersonBean(String name,int age,String gender){
        this.name=name;
        this.age=age;
        this.gender=gender;
    }
    public static class createBean{

    }
    public static TestPersonBean TestPersonBuild(){

    }

    private static final long serialVersionUID=-8039625376076337053L;
    private String name;
    private String gender;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name+"\t"+this.gender+"\t"+this.age;
    }
}
