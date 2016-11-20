package edu.iit.cs445.usecases;

import com.alibaba.fastjson.JSON;
import edu.iit.cs445.database.Database;
import edu.iit.cs445.entitites.Customer;
import edu.iit.cs445.entitites.FarmerAccount;
import edu.iit.cs445.entitites.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YongYang on 11/18/16.
 */
public class Search {
    public static List<Customer> getCustomersByKey (String key){
        List<Customer> customers = new ArrayList<Customer>();
        List<Customer> customerList = new ArrayList<Customer>(Database.getCustomers().values());
        if(key.equals("")||key.equals(" ")){
            return customerList;

        }
        for (Customer customer : customerList){
            String json = JSON.toJSONString(customer);
            if(json.contains(key)){
                customers.add(customer);
            }

        }
        return  customers;

    }

    public static List<FarmerAccount> getFarmerAccountsByKey (String key){
        List<FarmerAccount> farmerAccounts = new ArrayList<FarmerAccount>();
        List<FarmerAccount> farmerAccountList = new ArrayList<FarmerAccount>(Database.getFarmerAccounts().values());
        if(key.equals("")||key.equals(" ")){
            return farmerAccountList;

        }
        for (FarmerAccount farmerAccount : farmerAccountList){
            String json = JSON.toJSONString(farmerAccount);
            if(json.contains(key)){
                farmerAccounts.add(farmerAccount);
            }

        }
        return  farmerAccounts;

    }

    public static List<Order> getOrdersByKey (String key){
        List<Order> orders = new ArrayList<Order>();
        List<Order> orderList = new ArrayList<Order>(Database.getOrderMap().values());
        if(key.equals("")||key.equals(" ")){
            return orderList;

        }
        for (Order order : orderList){
            String json = JSON.toJSONString(order);
            if(json.contains(key)){
                orders.add(order);
            }

        }
        return  orders;

    }
}
