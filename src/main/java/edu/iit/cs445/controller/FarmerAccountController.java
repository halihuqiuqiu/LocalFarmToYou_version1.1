package edu.iit.cs445.controller;

import edu.iit.cs445.entitites.Product;
import edu.iit.cs445.usecases.FarmerAccountManager;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by YongYang on 11/7/16.
 */

@Path("/farmers")
public class FarmerAccountController {
    private FarmerAccountManager fcm= new FarmerAccountManager();

    @POST
    @Path("/{fid}/products")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct (Product product) {

        return null;
    }
}
