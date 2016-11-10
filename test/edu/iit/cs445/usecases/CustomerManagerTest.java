package edu.iit.cs445.usecases;

import edu.iit.cs445.entitites.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YongYang on 11/6/16.
 */
public class CustomerManagerTest {


    CustomerManager cm= new CustomerManager();
    @Before
    public void setup(){

        Customer c1= new Customer(1l, "a", "b", "c", "d", "e");
        Customer c2= new Customer(2l, "A", "B", "C", "D", "E");
        cm.addCustomer(c1);
        cm.addCustomer(c2);
    }

    @org.junit.Test
    public void addCustomer() throws Exception {
        assertEquals(2,cm.getAllCustomers().size());

    }

    @Test
    public void updateCustomer() throws Exception {

        Customer customerUpdate= new Customer(1l,"aa","bb","cc","dd","ee");
        cm.updateCustomer(customerUpdate);
        assertEquals(customerUpdate,cm.getCustomerById(1l));
    }

}