package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.database.Helper;
import edu.iit.cs445.entitites.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by YongYang on 11/19/16.
 */
public class MangerServiceTest {

    private MangerService ms = new MangerService();
    @Before
    public void setup() {
        Database.setCustomers(new HashMap<String, Customer>());
        Database.setCatalogs(new HashMap<String, Catalog>());
        Database.setFarmerAccounts(new HashMap<String, FarmerAccount>());
        Database.setManagerMap(Helper.getManagerMapWithSystemManager());
        Database.setProductsMap(new HashMap<String, Product>());
        Database.setOrderMap(new HashMap<String, Order>());
    }
    @Test
    public void getAllManagers() throws Exception {

        List<Manager> managerList = ms.getAllManagers();
        assertEquals(1,managerList.size());
        assertEquals("Super User", managerList.get(0).getName());
    }

    @Test
    public void getManagerById() throws Exception {
        Manager manager = ms.getManagerById("0");
        assertEquals("Super User", manager.getName());
    }

}