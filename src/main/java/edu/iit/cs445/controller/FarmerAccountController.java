package edu.iit.cs445.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import edu.iit.cs445.entitites.*;
import edu.iit.cs445.exception.*;
import edu.iit.cs445.exception.BadRequestException;
import edu.iit.cs445.usecases.FarmerAccountManager;
import edu.iit.cs445.usecases.FarmerProductManager;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
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
    public Response getCustomer(@PathParam("fid") String fid) {

        FarmerAccount farmerAccount = fam.getFarmerAccountById(fid); // if not find fid, throw DataNotFoundException
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(FarmerAccount.class, "fid", "farm_info", "personal_info", "delivers_to");
        String res = JSON.toJSONString(farmerAccount,filter);
        return Response.status(Response.Status.OK).entity(res).build();


    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerByZip(@QueryParam("zip") String zip) {
        if (zip == null) {  //return all
            List<FarmerAccount> farmerAccountList = fam.getAllFarmerAccounts();
            SimplePropertyPreFilter filter = new SimplePropertyPreFilter(FarmerAccount.class, "fid", "name");
            String res = JSON.toJSONString(farmerAccountList,filter);
            return Response.status(Response.Status.OK).entity(res).build();
        } else {
            List<FarmerAccount> result = fam.findFarmerAccountByZip(zip);
            SimplePropertyPreFilter filter = new SimplePropertyPreFilter(FarmerAccount.class, "fid", "name");
            String res = JSON.toJSONString(result,filter);
            return Response.status(Response.Status.OK).entity(res).build();

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
        return Response.status(Response.Status.CREATED).entity(res).build();
    }

    @Path("/{fid}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addFarmerAccount(@PathParam("fid") String fid, FarmerAccount farmerAccount) {
        farmerAccount.setFid(fid);
        farmerAccount.validateEntity();
        fam.updateFarmerAccount(farmerAccount);    // if not find fid, throw DataNotFoundException
        return Response.status(Response.Status.OK).build();
    }


    @Path("/{fid}/products")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFarmerProdutcs(@PathParam("fid") String fid) {

        if (fam.getFarmerAccountById(fid) == null) {
            throw new DataNotFoundException();
        }
        List<Product> ProductList = fpm.getAllFarmerProducts(fid);
        GenericEntity<List<Product>> list = new GenericEntity<List<Product>>(ProductList) {
        };
        return Response.status(Response.Status.OK).entity(list).build();


    }

    @Path("/{fid}/products/{fspid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFarmerProdutcs(@PathParam("fid") String fid, @PathParam("fspid") String fspid) {

        if (fam.getFarmerAccountById(fid) == null || fpm.getFarmerProductById(fid, fspid) == null) {
            throw new DataNotFoundException();
        }
        Product product = fpm.getFarmerProductById(fid, fspid);

        return Response.status(Response.Status.OK).entity(product).build();


    }


    @POST
    @Path("/{fid}/products")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(@PathParam("fid") String fid, Product product) {

        fpm.addFarmerProdcut(fid, product); // if not find fid, throw DataNotFoundException
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Product.class, "fspid");
        String res = JSON.toJSONString(product, filter);
        return Response.status(Response.Status.CREATED).entity(res).build();
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
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/{fid}/delivery_charge")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDelivery_charge(@PathParam("fid") String fid, FarmerAccount f) {

        FarmerAccount farmerAccount=fam.getFarmerAccountById(fid);// if not find fid, throw DataNotFoundException

        farmerAccount.setDelivery_charge(f.getDelivery_charge());

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @Path("/{fid}/delivery_charge")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDelivery_charge(@PathParam("fid") String fid) {
        FarmerAccount farmerAccount=fam.getFarmerAccountById(fid);// if not find fid, throw DataNotFoundException
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(FarmerAccount.class,"delivery_charge");
        String res = JSON.toJSONString(farmerAccount,filter);
        return Response.status(Response.Status.OK).entity(res).build();


    }
}
