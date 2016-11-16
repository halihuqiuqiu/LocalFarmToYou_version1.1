package edu.iit.cs445.controller;

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
    private FarmerAccountManager fam= new FarmerAccountManager();
    private FarmerProductManager fpm = new FarmerProductManager();

    @Path("/{fid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("fid") String fid){

        FarmerAccount farmerAccount = fam.getFarmerAccountById(fid);
        return Response.status(Response.Status.OK).entity(farmerAccount).build();


    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerByZip(@QueryParam("zip") String zip){
        if (zip==null){
            List<FarmerAccount> farmerAccountList = fam.getAllFarmerAccounts();
            GenericEntity<List<FarmerAccount>> list= new GenericEntity<List<FarmerAccount>>(farmerAccountList) {
            };
            return Response.status(Response.Status.OK).entity(list).build();
        }else{
            List<FarmerAccountIdName> result = fam.findFarmerAccountByZip(zip);
            GenericEntity<List<FarmerAccountIdName>> list= new GenericEntity<List<FarmerAccountIdName>>(result) {
            };
            return Response.status(Response.Status.OK).entity(list).build();

        }
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addFarmerAccount (FarmerAccount farmerAccount) {
        boolean b = farmerAccount.getFarm_info()==null ||
                farmerAccount.getPersonal_info()==null ||
                farmerAccount.getDelivers_to().isEmpty();
        if(b){
            throw new BadRequestException();
        }

        boolean c =farmerAccount.getFarm_info().getName()==null ||
                   farmerAccount.getFarm_info().getAddress()==null||
                    farmerAccount.getFarm_info().getPhone()==null||
                farmerAccount.getFarm_info().getWeb()==null;


        boolean d= farmerAccount.getPersonal_info().getEmail()==null||
                farmerAccount.getPersonal_info().getName()==null||
                farmerAccount.getPersonal_info().getPhone()==null;

        if(c||d){
            throw new BadRequestException();
        }

        fam.addFarmerAccount(farmerAccount);
        String fid = String.valueOf(farmerAccount.getFid());
        FarmerAccountID farmerAccountID = new FarmerAccountID(fid);
        return Response.status(Response.Status.CREATED).entity(farmerAccountID).build();
    }

    @Path("/{fid}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addFarmerAccount (@PathParam("fid") String fid,FarmerAccount farmerAccount) {
        if (fam.getFarmerAccountById(fid)==null) {
            throw new DataNotFoundException();
        }

        farmerAccount.setFid(fid);

        boolean b = farmerAccount.getFarm_info()==null ||
                farmerAccount.getPersonal_info()==null ||
                farmerAccount.getDelivers_to().isEmpty();
        if(b){
            throw new BadRequestException();
        }

        boolean c =farmerAccount.getFarm_info().getName()==null ||
                farmerAccount.getFarm_info().getAddress()==null||
                farmerAccount.getFarm_info().getPhone()==null||
                farmerAccount.getFarm_info().getWeb()==null;


        boolean d= farmerAccount.getPersonal_info().getEmail()==null||
                farmerAccount.getPersonal_info().getName()==null||
                farmerAccount.getPersonal_info().getPhone()==null;

        if(c||d){
            throw new BadRequestException();
        }

        fam.updateFarmerAccount(farmerAccount);
        return Response.status(Response.Status.OK).build();
    }


    @Path("/{fid}/products")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFarmerProdutcs(@PathParam("fid") String fid){

        if (fam.getFarmerAccountById(fid)==null) {
            throw new DataNotFoundException();
        }
        List<Product> ProductList = fpm.getAllFarmerProducts(fid);
        GenericEntity<List<Product>> list= new GenericEntity<List<Product>>(ProductList) {
        };
        return Response.status(Response.Status.OK).entity(list).build();


    }

    @Path("/{fid}/products/{fspid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFarmerProdutcs(@PathParam("fid") String fid,@PathParam("fspid") String fspid){

        if (fam.getFarmerAccountById(fid)==null||fpm.getFarmerProductById(fid,fspid)==null) {
            throw new DataNotFoundException();
        }
        Product product = fpm.getFarmerProductById(fid,fspid);

        return Response.status(Response.Status.OK).entity(product).build();


    }



    @POST
    @Path("/{fid}/products")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct (@PathParam("fid") String fid,Product product) {

        fpm.addFarmerProdcut(fid, product);
        String fspid=String.valueOf(product.getFspid());
        ProductID productID = new ProductID(fspid);
        return Response.status(Response.Status.CREATED).entity(productID).build();
    }

    @POST
    @Path("/{fid}/products/{fspid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uppdateProduct (@PathParam("fid") String fid,@PathParam("fspid") String fspid,Product product) {

        if (fam.getFarmerAccountById(fid)==null||fpm.getFarmerProductById(fid,fspid)==null) {
            throw new DataNotFoundException();
        }


        product.setFspid(fspid);
        fpm.partialUpdateFarmerProduct(fid,product);
        return Response.status(Response.Status.OK).build();
    }
}
