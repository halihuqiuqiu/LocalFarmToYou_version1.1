package edu.iit.cs445.controller;

import edu.iit.cs445.entitites.Customer;
import edu.iit.cs445.entitites.CustomerID;
import edu.iit.cs445.exception.BadRequestException;
import edu.iit.cs445.exception.DataNotFoundException;
import edu.iit.cs445.usecases.CustomerManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by YongYang on 11/4/16.
 */

@Path("/customer")
public class CustomerController {

    private CustomerManager cm= new CustomerManager();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomers(){
        return cm.getAllCustomers();
    }

    @Path("/{cid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("cid") String cid){

        if (cm.getCustomerById(cid) == null) {
            throw new DataNotFoundException();
        }
        Customer c =cm.getCustomerById(cid);
        return Response.status(Response.Status.OK).entity(c).build();


    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCustomer (Customer customer) {
        cm.addCustomer(customer);
        String cid = customer.getID();
        CustomerID customerID= new CustomerID(cid);
        return Response.status(Response.Status.CREATED).entity(customerID).build();
    }


    @Path("/{cid}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCustomer (@PathParam("cid") String cid,Customer customer) {
        if (cm.getCustomerById(cid) == null) {
            throw new DataNotFoundException();
        }

        customer.setID(cid);

        boolean b = customer.getName()==null ||
                    customer.getPhone()==null ||
                    customer.getEmail()==null ||
                    customer.getStreet()==null ||
                    customer.getZip()==null;

        if(b){
            throw new BadRequestException();
        }


        cm.updateCustomer(customer);
        return Response.status(Response.Status.OK).build();
        }


}

