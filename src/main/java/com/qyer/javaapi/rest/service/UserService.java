package com.qyer.javaapi.rest.service;

import com.qyer.javaapi.rest.dao.Person;
import com.qyer.javaapi.rest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by panqiang on 2017/5/14.
 */


@Component
@Path("/users")
public class UserService {
    @Autowired
    private Person person;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.TEXT_HTML})
    public Response createPersonFromForm(
            @FormParam("name") String name,
            @FormParam("id") int id,
            @FormParam("account") String account
    ) {
        User user = new User();
        user.setID(id);
        user.setName(name);
        user.setAccount(account);

            person.createPerson(user);

        return Response.status(201).entity("A new person has been created"+user.toString()).build();
    }

    @GET
    @Path("list")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<User> getPodcasts() {
        return person.getPersons();
    }

    @Path("id/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response findById(@NotNull @PathParam("id") Integer id) {
        User user;
        try {
            user = person.getPersonById(id);
        }catch (NullPointerException e){
            return Response.status(404).entity("The user with the id " + id + " does not exist").build();
        }
            return Response.status(200).entity(user).build();
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
