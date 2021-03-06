package edu.iit.cs445.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import edu.iit.cs445.entitites.*;
import edu.iit.cs445.exception.BadRequestException;
import edu.iit.cs445.exception.DataNotFoundException;
import edu.iit.cs445.usecases.CustomerManager;
import edu.iit.cs445.usecases.OrderManager;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

/**
 * Created by YongYang on 11/4/16.
 */

@Path("/customers")
public class CustomerController {

    private CustomerManager cm = new CustomerManager();
    private OrderManager om = new OrderManager();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomers() {

        List<Customer> customerList = cm.getAllCustomers();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String json = gson.toJson(customerList);

        return Response.status(200).entity(json).build();
    }


    @Path("/{cid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("cid") String cid) {
        Customer customer = cm.getCustomerById(cid);         // if not find gcpid, throw DataNotFoundException
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String json = gson.toJson(customer);
        return Response.status(200).entity(json).build();


    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCustomer(Customer customer) {
        cm.addCustomer(customer);
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Customer.class, "cid");
        String res = JSON.toJSONString(customer, filter);
        return Response.status(201).entity(res).build();
    }


    @Path("/{cid}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCustomer(@PathParam("cid") String cid, Customer customer) {
        if (cm.getCustomerById(cid) == null) {
            throw new DataNotFoundException();
        }
        customer.validateEntity(); //throw exception if missing value
        customer.setCid(cid);
        cm.updateCustomer(customer);
        return Response.status(200).build();
    }


    @POST
    @Path("/{cid}/orders")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addOrder(@PathParam("cid") String cid, Order order) {

        om.addCustomerOrder(cid, order); // if not find fid, throw DataNotFoundException
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Order.class, "oid");
        String res = JSON.toJSONString(order, filter);
        return Response.status(201).entity(res).build();
    }

    @Path("/{cid}/orders")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerOrders(@PathParam("cid") String cid) {

        if (om.getAllCustomerOrders(cid) == null) {
            throw new DataNotFoundException();
        }
        List<Order> orderList = om.getAllCustomerOrders(cid);

        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try{

            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(orderList);

        }catch (IOException e){

        }
        return Response.status(200).entity(json).build();


    }

    @Path("/{cid}/orders/{oid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerOrderById(@PathParam("cid") String cid, @PathParam("oid") String oid) {
        Order order = om.getCustomerOrderById(cid, oid);

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String json = gson.toJson(order);

        return Response.status(200).entity(json).build();

    }

    @Path("/{cid}/orders/{oid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response cancelOrder(@PathParam("cid") String cid, @PathParam("oid") String oid, Order order) {

        order.setOid(oid);
        om.cancelOrder(cid,order);
        return Response.status(200).build();


    }




}

