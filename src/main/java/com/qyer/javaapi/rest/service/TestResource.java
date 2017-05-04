package com.qyer.javaapi.rest.service;

import com.qyer.javaapi.rest.dao.TestDao;
import com.qyer.javaapi.rest.entity.TestPersonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

/**
 * Created by panqiang on 2017/4/29.
 */

@Path("/test")
public class TestResource {
/**
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getHeaders(@Context HttpHeaders hh){
        MultivaluedMap<String, String> headerParams = hh.getRequestHeaders();
        return headerParams.toString();
    }
*/


    @Autowired(required=false) //@Qualifier("注释，required 为false 说明可以为null")
    TestDao dao;

    @Path("/api")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_HTML})
    @Transactional
    public Response createPod(TestPersonBean tpb) {
        dao.createPerson(tpb);
        return Response.status(201).entity("A new person has been created").build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.TEXT_HTML})
    @Transactional
    public Response createPodcastFromForm(
            @FormParam("name") String name,
            @FormParam("gender") String gender,
            @FormParam("age") int age,
            @FormParam("id") long id
    ) {
        TestPersonBean tpb = new TestPersonBean();
        tpb.setID(id);
        tpb.setName(name);
        tpb.setGender(gender);
        tpb.setAge(age);
        dao.createPerson(tpb);
        return Response.status(201).entity("A new person has been created").build();
    }


    /************************************ READ ************************************/
    /**
     * Returns all resources (podcasts) from the database
     * @return
     */
    @GET
    @Path("list")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<TestPersonBean> getPersons() {
        return dao.getPersons();
    }
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response findById(@QueryParam("id") Long id) {
        TestPersonBean podcastById;
        try {
            podcastById = dao.getPersonById(id);
        }catch (NullPointerException e){
            return Response.status(404).entity("The podcast with the id " + id + " does not exist").build();
        }
            return Response.status(200).entity(podcastById).build();
    }

/*
    @Path("/api")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TestPersonBean getPerson(){
        tpb.setID(5337);
        tpb.setName("kris");
        tpb.setGender("male");
        tpb.setAge(23);
        return tpb;
    }
    */



}
