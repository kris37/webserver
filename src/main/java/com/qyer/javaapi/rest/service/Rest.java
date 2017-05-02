package com.qyer.javaapi.rest.service; /**
 * Created by panqiang on 2017/4/22.
 */
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Created by panqiang on 2017/4/22.
 */
@Path("/bigdata")
public class Rest {


    // This method is called if TEXT_PLAIN is request
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
        return "qyer-bigdata-api";
    }
    // This method is called if XML is request
    @GET
    @Produces(MediaType.TEXT_XML)
    public String sayXMLHello() {
        return "<?xml version=\"1.0\"?>" + "<hello> qyer-bigdata-api" + "</hello>";
    }
    // This method is called if HTML is request
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello() {
        return "<html> " + "<title>" + "qyer-bigdata-api" + "</title>"
                + "<body><h1>" + "qyer-bigdata-api" + "</body></h1>" + "</html> ";
    }


    @Path("/getUser/{username}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getName(@PathParam("username") String username){

        return username;
    }
    @Path("/getHeaders")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Produces("application/json; charset=UTF-8")
    public String getHeader(@Context HttpHeaders hh) {
        MultivaluedMap<String, String> headerParams = hh.getRequestHeaders();
        return headerParams.toString();
    }
    @Path("/getDefaultValue")
    @GET
    public  String getDefaultValue(@DefaultValue("1000") @QueryParam("from")int from,
                                   @DefaultValue("999")@QueryParam("to")int to) {
        return "getDefaultValue is called, from : " + from + ", to : " + to;
    }
}

