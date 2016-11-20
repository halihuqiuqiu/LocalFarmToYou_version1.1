package edu.iit.cs445.entitites;

import edu.iit.cs445.exception.BadRequestException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by YongYang on 11/19/16.
 */
public class FarmerAccountTest {
    private FarmerAccount farmerAccount = new FarmerAccount();

    @Test(expected = BadRequestException.class)
    public void setDelivery_charge() throws Exception {
        farmerAccount.setDelivery_charge(-0.123);

    }

    @Test
    public void getDelivery_charge() throws Exception {
        farmerAccount.setDelivery_charge(5.00);
        assertEquals("5.0", String.valueOf(farmerAccount.getDelivery_charge()));
        farmerAccount.setDelivery_charge(1.237);
        assertEquals("1.24", String.valueOf(farmerAccount.getDelivery_charge()));

    }

    @Test(expected = BadRequestException.class)
    public void validateEntity() throws Exception {
        farmerAccount.validateEntity();
    }

    @Test
    public void returnAllKindReports() throws Exception {
        List<ReportFarmer> reportFarmers = farmerAccount.returnAllKindReports();
        assertEquals(4,reportFarmers.size());
        assertEquals("1",reportFarmers.get(0).getFrid());
        assertEquals("Orders to deliver today", reportFarmers.get(0).getName());

    }

}