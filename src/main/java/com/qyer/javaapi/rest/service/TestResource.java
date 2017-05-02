package com.qyer.javaapi.rest.service;

import com.qyer.javaapi.rest.entity.TestPersonBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Created by panqiang on 2017/4/29.
 */

@Path("/test")
public class TestResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getHeaders(@Context HttpHeaders hh){
        MultivaluedMap<String, String> headerParams = hh.getRequestHeaders();
        return headerParams.toString();
    }

    @Autowired(required=false) //@Qualifier("注释，required 为false 说明可以为null")
            TestPersonBean tpb;
    @Path("/api")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TestPersonBean getPerson(){
        tpb.setName("xie");
        tpb.setAge(23);
        tpb.setGender("male");
        return tpb;
    }



}
