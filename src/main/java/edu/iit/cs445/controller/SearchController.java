package edu.iit.cs445.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
            SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Customer.class, "cid","name","street","zip","phone","email");
            String res = JSON.toJSONString(customerList, filter);

            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
            String indented = null;
            try{
                Object json = mapper.readValue(res, new TypeReference<List<Customer>>(){});
                indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);

            }catch (IOException e){

            }

            return Response.status(200).entity(indented).build();

        }

        if(topic.equals("farm")){
            List<FarmerAccount> farmerAccountList = Search.getFarmerAccountsByKey(key);
            SimplePropertyPreFilter filter = new SimplePropertyPreFilter(FarmerAccount.class, "fid", "farm_info", "delivers_to","personal_info");
            String res = JSON.toJSONString(farmerAccountList, filter);

            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
            String indented = null;
            try{
                Object json = mapper.readValue(res, new TypeReference<List<FarmerAccount>>(){});
                indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);

            }catch (IOException e){

            }

            return Response.status(200).entity(indented).build();

        }

        if(topic.equals("order")){
            List<Order> orderList = Search.getOrdersByKey(key);

            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
            String indented = null;
            try{
                Object json = mapper.writeValueAsString(orderList);
                indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);

            }catch (IOException e){

            }

            return Response.status(200).entity(indented).build();

        }


        throw new BadRequestException();  // wrong topic
    }
}
