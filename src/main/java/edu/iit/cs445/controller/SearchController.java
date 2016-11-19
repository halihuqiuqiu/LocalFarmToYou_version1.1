package edu.iit.cs445.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.iit.cs445.entitites.Customer;
import edu.iit.cs445.entitites.FarmerAccount;
import edu.iit.cs445.entitites.Order;
import edu.iit.cs445.exception.BadRequestException;
import edu.iit.cs445.usecases.Search;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

/**
 * Created by YongYang on 11/18/16.
 */
@Path("search")
public class SearchController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomers(@QueryParam("topic") String topic, @QueryParam("key") String key) {
        if(topic.equals("customer")){
            List<Customer> customerList = Search.getCustomersByKey(key);
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
            String json = gson.toJson(customerList);


            return Response.status(200).entity(json).build();

        }

        else if(topic.equals("farm")){
            List<FarmerAccount> farmerAccountList = Search.getFarmerAccountsByKey(key);
            ObjectMapper mapper = new ObjectMapper();

            String json=null;
            try{
                json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(farmerAccountList);

            }catch (IOException e){

            }

            return Response.status(200).entity(json).build();

        }

        else if(topic.equals("order")){
            List<Order> orderList = Search.getOrdersByKey(key);

            ObjectMapper mapper = new ObjectMapper();
            String indented = null;
            try{
                indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(orderList);

            }catch (IOException e){

            }

            return Response.status(200).entity(indented).build();

        }else {
            throw new BadRequestException();  // wrong topic

        }


    }
}
