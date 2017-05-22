package com.qyer.javaapi.rest.service;

import com.qyer.javaapi.rest.dao.Location;
import com.qyer.javaapi.rest.dao.Person;
import com.qyer.javaapi.rest.entity.City;
import com.qyer.javaapi.rest.entity.User;
import dynamicDataSource.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.sql.DataSourceDefinition;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by panqiang on 2017/5/14.
 */


@Service
@Path("/users")
public class UserService {

    @Autowired
    private Location location;
    @Autowired
    private Person person;


    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.TEXT_HTML})
    public Response createPersonFromForm(
            @FormParam("name") String name,
            @FormParam("id") int id,
            @FormParam("account") String account,
            @FormParam("city") int city
    ) {
//        DataSourceContextHolder.setDbType(DataSourceContextHolder.dataSourceUser);
        User user = new User();
        user.setID(id);
        user.setName(name);
        user.setAccount(account);
        user.setCityId(city);
        person.createPerson(user);
        return Response.status(201).entity("A new person has been created"+user.toString()).build();
    }


    @Path("id/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response findById(@NotNull @PathParam("id") Integer id) {
        User user;
        City city;
        try {
            user = person.getPersonById(id);
            DataSourceContextHolder.setDbType(DataSourceContextHolder.dataSourceCity);
            city=location.getCityById(user.getCityId());

        }catch (NullPointerException e){
            return Response.status(404).entity("The user with the id " + id + " does not exist").build();
        }
            return Response.status(200).entity(user.toString()+city.toString()).build();
    }

    @Path("id/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.TEXT_HTML})
    public Response updateUser(@NotNull @PathParam("id") Integer id,
                               @FormParam("name") String name,
                               @FormParam("account") String account,
                               @FormParam("cityId") int cityId){
        User user=new User();
        user.setID(id);
        user.setCityId(cityId);
        user.setAccount(account);
        user.setName(name);
        try {
            person.updatePerson(user);
        }catch (NullPointerException e){
            return Response.status(404).entity("The user with the id " + id + " does not exist").build();
        }
        return Response.status(201).entity("update sucess ").build();
    }

    @Path("account/{account}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response findByAccount(@PathParam("account") String account) {
        User user;
        try {
            user = person.getPersonByAccount(account);
        }catch (NullPointerException e){
            return Response.status(404).entity("The user with the id " + account + " does not exist").build();
        }
        return Response.status(200).entity(user).build();
    }

}
