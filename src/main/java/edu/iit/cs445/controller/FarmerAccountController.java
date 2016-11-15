package edu.iit.cs445.controller;

import edu.iit.cs445.entitites.*;
import edu.iit.cs445.exception.*;
import edu.iit.cs445.exception.BadRequestException;
import edu.iit.cs445.usecases.FarmerAccountManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by YongYang on 11/7/16.
 */

@Path("/farmers")
public class FarmerAccountController {
    private FarmerAccountManager fcm= new FarmerAccountManager();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FarmerAccount> getAllFarmerAccounts(){
        return fcm.getAllFarmerAccounts();
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

        fcm.addFarmerAccount(farmerAccount);
        String fid = String.valueOf(farmerAccount.getFid());
        FarmerAccountID farmerAccountID = new FarmerAccountID(fid);
        return Response.status(Response.Status.CREATED).entity(farmerAccountID).build();
    }

    @POST
    @Path("/{fid}/products")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct (Product product) {

        return null;
    }
}
