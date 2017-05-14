package com.qyer.javaapi.rest.entity;

/**
 * Created by panqiang on 2017/5/2.
 */


import org.springframework.stereotype.Service;

import java.io.Serializable;



public class User implements Serializable {


    /*
    public TestPersonBean(CreateBean cb ){
        this.ID=cb.ID;
        this.name=cb.name;
        this.age=cb.age;
        this.gender=cb.gender;
    }
    //静态内部类创建对象
    public static class CreateBean{


        private String name;
        private int age;
        private String gender;
        private long ID;

        public CreateBean(long ID,String name){
            this.ID=ID;
            this.name=name;
        }

        public  CreateBean setAge(int age){
            this.age=age;
            return this;
        }
        public CreateBean setGender(String gender){
            this.gender=gender;
            return this;
        }

        public  TestPersonBean buid(){
            return new TestPersonBean(this);
        }
    }

*/
    private static final long serialVersionUID = -8039625376076337053L;
    private String account;
    private String name;
    private Integer ID;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }



    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", ID=" + ID +
                '}';
    }
}



