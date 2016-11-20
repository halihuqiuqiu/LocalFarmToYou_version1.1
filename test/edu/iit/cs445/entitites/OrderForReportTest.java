package edu.iit.cs445.entitites;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YongYang on 11/19/16.
 */
public class OrderForReportTest {
    OrderForReport orderForReport = new OrderForReport();
    @Test
    public void getStatus() throws Exception {
        orderForReport.setStatus("status");
        assertEquals("status",orderForReport.getStatus());

    }

    @Test
    public void setStatus() throws Exception {
        orderForReport.setStatus("status");
        assertEquals("status",orderForReport.getStatus());

    }

}