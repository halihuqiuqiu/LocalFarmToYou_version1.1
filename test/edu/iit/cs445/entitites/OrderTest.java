package edu.iit.cs445.entitites;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YongYang on 11/19/16.
 */
public class OrderTest {
    private Order order = new Order();
    @Test
    public void getProducts_total() throws Exception {
        order.setProducts_total(5.00);
        assertEquals("5.0", String.valueOf(order.getProducts_total()));
        order.setProducts_total(1.237);
        assertEquals("1.24", String.valueOf(order.getProducts_total()));
    }

    @Test
    public void getDelivery_charge() throws Exception {
        order.setDelivery_charge(5.00);
        assertEquals("5.0", String.valueOf(order.getDelivery_charge()));
        order.setDelivery_charge(1.2345);
        assertEquals("1.23", String.valueOf(order.getDelivery_charge()));

    }

    @Test
    public void getOrder_total() throws Exception {
        order.setOrder_total(5.00);
        assertEquals("5.0", String.valueOf(order.getOrder_total()));
        order.setOrder_total(1.2345);
        assertEquals("1.23", String.valueOf(order.getOrder_total()));

    }

}