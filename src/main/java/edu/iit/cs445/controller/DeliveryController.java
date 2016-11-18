package edu.iit.cs445.controller;

import edu.iit.cs445.entitites.Order;
import edu.iit.cs445.usecases.OrderManager;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by YongYang on 11/17/16.
 */

@Path("/delivery")
public class DeliveryController {
    OrderManager om = new OrderManager();

    @Path("{oid}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response cancelOrder(@PathParam("oid") String oid, Order order) {

        order.setOid(oid);
        om.deliveredOrder(order);
        return Response.status(200).build();


    }
}
