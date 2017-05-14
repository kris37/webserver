package com.qyer.javaapi.rest.service;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by panqiang on 2017/5/14.
 */
@Component
@Path("/")
public class HomeServer {
    // This method is called if TEXT_PLAIN is request
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHomeGet() {
        return "qyer-api";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHomePost() {
        return "qyer-api";
    }

}
