package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.entitites.Customer;
import edu.iit.cs445.exception.DataNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by YongYang on 11/4/16.
 */
public class CustomerManager {
    private Map<String, Customer> customers = Database.getCustomers();

    public List<Customer> getAllCustomers() {

        return new ArrayList<Customer>(customers.values());
    }

    public Customer addCustomer(Customer customer) {
        customer.setCid(String.valueOf(customers.size()+1));
        customers.put(customer.getCid(),customer);
        return customer;
    }

    public Customer getCustomerById(String cid) {
        Customer customer = customers.get(cid);
        if(customer==null){
            throw new DataNotFoundException();
        }
        return customer;
    }

    public Customer updateCustomer(Customer customer) {

        customers.put(customer.getCid(), customer);
        return customer;
    }
}
