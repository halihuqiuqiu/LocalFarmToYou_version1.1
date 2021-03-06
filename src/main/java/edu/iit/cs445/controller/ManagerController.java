package edu.iit.cs445.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import edu.iit.cs445.entitites.*;
import edu.iit.cs445.usecases.CatalogManager;
import edu.iit.cs445.usecases.MakeReportFarmerForDelivery;
import edu.iit.cs445.usecases.MakeReportManagerForDelivery;
import edu.iit.cs445.usecases.MangerService;
import groovy.servlet.AbstractHttpServlet;

import javax.servlet.*;

import javax.servlet.http.HttpServletResponse;
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
    private CatalogManager manager = new CatalogManager();
    private MangerService ms = new MangerService();

    @GET
    @Path("/catalog")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCatalog() {

        List<Catalog> catalogList = manager.getAllCatalogs();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(catalogList);
        return Response.status(200).status(Response.Status.OK).entity(prettyJson).build();

    }

    @POST
    @Path("/catalog")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCatalog(Catalog catalog) {
        manager.addCatalog(catalog);
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Catalog.class, "gcpid");
        String res = JSON.toJSONString(catalog, filter);
        return Response.status(201).entity(res).build();
    }

    @Path("/catalog/{gcpid}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCustomer(@PathParam("gcpid") String gcpid, Catalog catalog) {
        catalog.setGcpid(gcpid);
        manager.updateCatalog(catalog);   // if not find gcpid, throw DataNotFoundException
        return Response.status(200).build();
    }

    @GET
    @Path("/accounts")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllManagerAccounts() {
        List<Manager> managerList = ms.getAllManagers();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(managerList);

        return Response.status(200).entity(prettyJson).build();

    }

    @Path("/accounts/{mid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getManagerAccount(@PathParam("mid") String mid){

        Manager manager = ms.getManagerById(mid); // if not find fid, throw DataNotFoundException

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(manager);

        return Response.status(200).entity(prettyJson).build();


    }

    @Path("/reports")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReports() {
        List<ReportManager> reportList= Manager.returnAllKindReports();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(reportList);

        return Response.status(200).entity(prettyJson).build();


    }
    @Path("/reports/{mrid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReportById(@PathParam("mrid") String mrid) {
        ReportManagerForDelivery report = MakeReportManagerForDelivery.makeReport(mrid);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(report);

        return Response.status(200).entity(json).build();

    }



}
