package edu.iit.cs445.entitites;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YongYang on 11/19/16.
 */
public class OrderDetailTest {
    private OrderDetail orderDetail = new OrderDetail();
    @Test
    public void getLine_item_total() throws Exception {
        orderDetail.setLine_item_total(5.00);
        assertEquals("5.0", String.valueOf(orderDetail.getLine_item_total()));
        orderDetail.setLine_item_total(1.237);
        assertEquals("1.24", String.valueOf(orderDetail.getLine_item_total()));

    }

}