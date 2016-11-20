package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.database.Helper;
import edu.iit.cs445.entitites.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by YongYang on 11/6/16.
 */
public class CustomerManagerTest {

    private CustomerManager cm= new CustomerManager();
    private Customer customer1 = new Customer();
    private Customer customer2 = new Customer();

    @Before
    public void setup(){

        Database.setCustomers(new HashMap<String, Customer>());
        Database.setCatalogs(new HashMap<String, Catalog>());
        Database.setFarmerAccounts(new HashMap<String, FarmerAccount>());
        Database.setManagerMap(Helper.getManagerMapWithSystemManager());
        Database.setProductsMap(new HashMap<String, Product>());
        Database.setOrderMap(new HashMap<String, Order>());

        customer1.setName("customer1");
        customer2.setName("customer2");

        cm.addCustomer(customer1);
        cm.addCustomer(customer2);
    }




    @Test
    public void getAllCustomers() throws Exception {

        assertEquals(2,cm.getAllCustomers().size());
    }

    @Test
    public void addCustomer1() throws Exception {
        assertEquals("1",customer1.getCid());
        assertEquals("2",customer2.getCid());

    }
    @Test
    public void getCustomerById() throws Exception {

        assertEquals("customer1", cm.getCustomerById("1").getName());
        assertEquals("customer2", cm.getCustomerById("2").getName());

    }

    @Test
    public void updateCustomer() throws Exception {
        customer1.setName("customer1(change)");
        cm.updateCustomer(customer1);
        assertEquals("customer1(change)",cm.getCustomerById("1").getName());

    }


}