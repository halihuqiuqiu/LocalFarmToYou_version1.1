package edu.iit.cs445.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import edu.iit.cs445.entitites.Catalog;
import edu.iit.cs445.entitites.FarmerAccount;
import edu.iit.cs445.exception.BadRequestException;
import edu.iit.cs445.exception.DataNotFoundException;
import edu.iit.cs445.usecases.Manager;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by YongYang on 11/7/16.
 */

@Path("/managers")
public class ManagerController {
    private Manager manager = new Manager();

    @GET
    @Path("/catalog")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCatalog() {

        List<Catalog> catalogList = manager.getAllCatalogs();
        GenericEntity<List<Catalog>> list = new GenericEntity<List<Catalog>>(catalogList){};
        return Response.status(Response.Status.OK).entity(list).build();

    }

    @POST
    @Path("/catalog")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCatalog(Catalog catalog) {
        manager.addCatalog(catalog);
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Catalog.class, "gcpid");
        String res = JSON.toJSONString(catalog, filter);
        return Response.status(Response.Status.CREATED).entity(res).build();
    }

    @Path("/catalog/{gcpid}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCustomer(@PathParam("gcpid") String gcpid, Catalog catalog) {
        catalog.setGcpid(gcpid);
        manager.updateCatalog(catalog);   // if not find gcpid, throw DataNotFoundException
        return Response.status(Response.Status.OK).build();
    }

}
