package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.database.Helper;
import edu.iit.cs445.entitites.Customer;
import edu.iit.cs445.entitites.FarmerAccount;
import edu.iit.cs445.entitites.Order;
import edu.iit.cs445.entitites.Product;
import edu.iit.cs445.exception.DataNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by YongYang on 11/17/16.
 */
public class OrderManager {
    private Map<String, Customer> customers = Database.getCustomers();
    private Map<String, FarmerAccount> farmerAccounts= Database.getFarmerAccounts();

    public List<Order> getAllCustomerOrders(String cid) {
        if(customers.get(cid)==null){
            throw new DataNotFoundException();
        }
        return new ArrayList<Order>(customers.get(cid).getOrderMap().values());
    }

    public Order addCustomerOrder(String cid, Order order) {
        if(customers.get(cid)==null){
            throw new DataNotFoundException();
        }
        order.setOid(String.valueOf(customers.get(cid).getOrderMap().size()+1));
        order.setOrder_date(HelperDate.getTodayDateyyyyMMdd());
        order.setPlanned_delivery_date(HelperDate.getTomorrowDateyyyyMMdd());
        order.setActual_delivery_date("");
        order.setStatus("open");

        //order.setFarm_info();

        customers.get(cid).getOrderMap().put(order.getOid(),order);
        return order;
    }

}
