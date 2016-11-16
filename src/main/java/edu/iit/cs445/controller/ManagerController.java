package edu.iit.cs445.controller;

import edu.iit.cs445.entitites.Catalog;
import edu.iit.cs445.entitites.CatalogID;
import edu.iit.cs445.exception.BadRequestException;
import edu.iit.cs445.exception.DataNotFoundException;
import edu.iit.cs445.usecases.Manager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by YongYang on 11/7/16.
 */

@Path("/managers")
public class ManagerController {
    private Manager manager= new Manager();

    @GET
    @Path("/catalog")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Catalog> getAllCustomers(){
        return manager.getAllCatalogs();
    }

    @POST
    @Path("/catalog")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCatalog (Catalog catalog) {
        manager.addCatalog(catalog);
        String gcpid = String.valueOf(catalog.getGcpid());
        CatalogID catalogID= new CatalogID(gcpid);
        return Response.status(Response.Status.CREATED).entity(catalogID).build();
    }

    @Path("/catalog/{gcpid}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCustomer (@PathParam("gcpid") String gcpid,Catalog catalog) {
        if (manager.getCatalogById(gcpid)== null) {
            throw new DataNotFoundException();
        }

        catalog.setGcpid(gcpid);
        if(catalog.getName()==null){
            throw new BadRequestException();
        }

        manager.updateCatalog(catalog);
        return Response.status(Response.Status.OK).build();
    }

}
