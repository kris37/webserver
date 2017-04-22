package com.qyer.javaapi.service;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 * Created by panqiang on 2017/4/22.
 */
@Path("/RestJaxApp")
public class RestJaxApp {

        // This method is called if TEXT_PLAIN is request
        @GET
        @Produces(MediaType.TEXT_PLAIN)
        public String sayPlainTextHello() {
            return "Hello Jersey";
        }
        // This method is called if XML is request
        @GET
        @Produces(MediaType.TEXT_XML)
        public String sayXMLHello() {
            return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
        }
        // This method is called if HTML is request
        @GET
        @Produces(MediaType.TEXT_HTML)
        public String sayHtmlHello() {
            return "<html> " + "<title>" + "Hello Jersey" + "</title>"
                    + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
        }
}
