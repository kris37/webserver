package com.qyer.javaapi.rest.entity;

/**
 * Created by panqiang on 2017/5/2.
 */

import com.oracle.webservices.internal.api.databinding.Databinding;
import com.sun.tools.corba.se.idl.StringGen;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class TestPersonBean implements Serializable {


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
    private static final long serialVersionUID=-8039625376076337053L;
    private String u_name;
    private String gender;
    private int age;
    private long ID;


    public String getName() {
        return u_name;
    }

    public void setName(String name) {
        this.u_name = name;
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

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return this.u_name+"\t"+this.gender+"\t"+this.age;
    }
}
