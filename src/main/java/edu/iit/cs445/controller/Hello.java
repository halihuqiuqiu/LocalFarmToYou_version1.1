package edu.iit.cs445.controller;

import edu.iit.cs445.entitites.Customer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by YongYang on 11/9/16.
 */
@Path("hello")
public class Hello {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(){
        return "hellllllooooooo";
    }
}
