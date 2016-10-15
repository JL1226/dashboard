package com.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by apple on 5/12/15.
 */
@Path("/")
public class HelloService {

    @GET
    @Path("/hello")

    public String Hello()
    {
        return "hello";
    }

    @GET
    @Path("/world")

    public String World()
    {
        return "world";
    }
}
