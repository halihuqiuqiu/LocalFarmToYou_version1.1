package edu.iit.cs445.entitites;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YongYang on 11/19/16.
 */
public class CustomerForReportTest {

    CustomerForReport customerForReport = new CustomerForReport();
    @Test
    public void getName() throws Exception {
        customerForReport.setName("report");
        assertEquals("report",customerForReport.getName());

    }

    @Test
    public void setName() throws Exception {
        customerForReport.setName("report");
        assertEquals("report",customerForReport.getName());

    }

    @Test
    public void getEmail() throws Exception {
        customerForReport.setEmail("email");
        assertEquals("email",customerForReport.getEmail());

    }

    @Test
    public void setEmail() throws Exception {
        customerForReport.setEmail("email");
        assertEquals("email",customerForReport.getEmail());

    }

    @Test
    public void getPhone() throws Exception {
        customerForReport.setPhone("phone");
        assertEquals("phone",customerForReport.getPhone());

    }

    @Test
    public void setPhone() throws Exception {
        customerForReport.setPhone("phone");
        assertEquals("phone",customerForReport.getPhone());

    }

}