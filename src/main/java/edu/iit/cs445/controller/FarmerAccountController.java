package edu.iit.cs445.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import edu.iit.cs445.entitites.*;
import edu.iit.cs445.exception.*;
import edu.iit.cs445.usecases.FarmerAccountManager;
import edu.iit.cs445.usecases.FarmerProductManager;
import edu.iit.cs445.usecases.MakeReportFarmerForDelivery;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

/**
 * Created by YongYang on 11/7/16.
 */

@Path("/farmers")
public class FarmerAccountController {
    private FarmerAccountManager fam = new FarmerAccountManager();
    private FarmerProductManager fpm = new FarmerProductManager();

    @Path("/{fid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFarmerAccount(@PathParam("fid") String fid) {

        FarmerAccount farmerAccount = fam.getFarmerAccountById(fid); // if not find fid, throw DataNotFoundException
        ObjectMapper mapper = new ObjectMapper();

        String json=null;
        try{
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(farmerAccount);

        }catch (IOException e){

        }
        return Response.status(200).entity(json).build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFarmerAccountByZip(@QueryParam("zip") String zip) {
        if (zip == null) {  //return all
            List<FarmerAccount> farmerAccountList = fam.getAllFarmerAccounts();
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
            String json = gson.toJson(farmerAccountList);
            return Response.status(200).entity(json).build();

        } else {
            List<FarmerAccount> result = fam.findFarmerAccountByZip(zip);
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
            String json = gson.toJson(result);
            return Response.status(200).entity(json).build();

        }
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addFarmerAccount(FarmerAccount farmerAccount) {
        farmerAccount.validateEntity();

        fam.addFarmerAccount(farmerAccount);
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(FarmerAccount.class, "fid");
        String res = JSON.toJSONString(farmerAccount, filter);

        return Response.status(201).entity(res).build();
    }

    @Path("/{fid}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addFarmerAccount(@PathParam("fid") String fid, FarmerAccount farmerAccount) {
        farmerAccount.setFid(fid);
        farmerAccount.validateEntity();
        fam.updateFarmerAccount(farmerAccount);    // if not find fid, throw DataNotFoundException
        return Response.status(200).build();
    }


    @Path("/{fid}/products")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFarmerProdutcs(@PathParam("fid") String fid) {

        if (fam.getFarmerAccountById(fid) == null) {
            throw new DataNotFoundException();
        }
        List<Product> productList = fpm.getAllFarmerProducts(fid);

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String json = gson.toJson(productList);

        return Response.status(200).entity(json).build();


    }

    @Path("/{fid}/products/{fspid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFarmerProdutcs(@PathParam("fid") String fid, @PathParam("fspid") String fspid) {

        if (fam.getFarmerAccountById(fid) == null || fpm.getFarmerProductById(fid, fspid) == null) {
            throw new DataNotFoundException();
        }
        Product product = fpm.getFarmerProductById(fid, fspid);

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String json = gson.toJson(product);

        return Response.status(200).entity(json).build();


    }


    @POST
    @Path("/{fid}/products")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(@PathParam("fid") String fid, Product product) {

        fpm.addFarmerProdcut(fid, product); // if not find fid, throw DataNotFoundException
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Product.class, "fspid");
        String res = JSON.toJSONString(product, filter);
        return Response.status(201).entity(res).build();
    }

    @POST
    @Path("/{fid}/products/{fspid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("fid") String fid, @PathParam("fspid") String fspid, Product product) {

        if (fam.getFarmerAccountById(fid) == null || fpm.getFarmerProductById(fid, fspid) == null) {
            throw new DataNotFoundException();
        }

        product.setFspid(fspid);
        fpm.partialUpdateFarmerProduct(fid, product);
        return Response.status(200).build();
    }

    @POST
    @Path("/{fid}/delivery_charge")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDelivery_charge(@PathParam("fid") String fid, FarmerAccount f) {

        FarmerAccount farmerAccount=fam.getFarmerAccountById(fid);// if not find fid, throw DataNotFoundException

        farmerAccount.setDelivery_charge(f.getDelivery_charge());

        return Response.status(204).build();
    }

    @Path("/{fid}/delivery_charge")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDelivery_charge(@PathParam("fid") String fid) {
        FarmerAccount farmerAccount=fam.getFarmerAccountById(fid);// if not find fid, throw DataNotFoundException
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(FarmerAccount.class,"delivery_charge");
        String res = JSON.toJSONString(farmerAccount,filter);

        return Response.status(200).entity(res).build();


    }
    @Path("/{fid}/reports")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReports(@PathParam("fid") String fid) {
        FarmerAccount farmerAccount=fam.getFarmerAccountById(fid);// if not find fid, throw DataNotFoundException
        List<ReportFarmer> reportFarmersList= farmerAccount.returnAllKindReports();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(reportFarmersList);
        return Response.status(200).entity(json).build();


    }

    @Path("/{fid}/reports/{frid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReports(@PathParam("fid") String fid, @PathParam("frid") String frid) {
        FarmerAccount farmerAccount=fam.getFarmerAccountById(fid);// if not find fid, throw DataNotFoundException
        ReportFarmerForDelivey reportFarmerForDelivey = MakeReportFarmerForDelivery.returnReport(fid, frid);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(reportFarmerForDelivey);

        return Response.status(200).entity(json).build();


    }
}
