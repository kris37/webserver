package com.qyer.javaapi.rest.service;

import com.qyer.javaapi.rest.dao.Location;
import com.qyer.javaapi.rest.dao.Person;
import com.qyer.javaapi.rest.entity.City;
import dynamicDataSource.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by panqiang on 2017/5/21.
 */
@Path("city")
@Service
public class CityService {

    @Autowired
    private Location location;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.TEXT_HTML})
    public Response createCityFromForm(
            @FormParam("country") String country,
            @FormParam("id") int id,
            @FormParam("province") String province,
            @FormParam("cityName") String cityName) {
        DataSourceContextHolder.setDbType(DataSourceContextHolder.dataSourceCity);
        City city =new City();
        city.setCity(cityName);
        city.setCountry(country);
        city.setId(id);
        city.setProvince(province);
        location.createCity(city);
        return Response.status(201).entity("A new person has been created"+city.toString()).build();
    }

    @Path("id/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response findById(@NotNull @PathParam("id") Integer id) {
        DataSourceContextHolder.setDbType(DataSourceContextHolder.dataSourceCity);
        City city;
        try {
            city = location.getCityById(id);
        }catch (NullPointerException e){
            return Response.status(404).entity("The city with the id " + id + " does not exist").build();
        }
        return Response.status(200).entity(city).build();
    }
}
