package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.database.Helper;
import edu.iit.cs445.entitites.*;
import edu.iit.cs445.exception.DataNotFoundException;
import edu.iit.cs445.exception.UnprocessableEntityException;

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
        FarmerAccount farmerAccount= farmerAccounts.get(order.getFid());
        Farm farm = farmerAccount.getFarm_info();

        List<String> a = farmerAccount.getDelivers_to();
        String b = customers.get(cid).getZip();
        if(!a.contains(b)){
            throw new UnprocessableEntityException();     // Farmer account cannot deliver to this customer zip
        }


        order.setOid(String.valueOf(customers.get(cid).getOrderMap().size()+1));
        order.setOrder_date(HelperDate.getTodayDateyyyyMMdd());
        order.setPlanned_delivery_date(HelperDate.getTomorrowDateyyyyMMdd());
        order.setActual_delivery_date("");
        order.setStatus("open");



        farm.setFid(order.getFid());
        order.setFarm_info(farm);

        double totalProduct=0;

        List<OrderDetail> orderDetails = order.getOrder_detail();
        for(OrderDetail orderDetail : orderDetails){
            Product product = farmerAccount.getProductsMap().get(orderDetail.getFspid());
            orderDetail.setName(product.getName());
            double totalPerProduct = Double.parseDouble(orderDetail.getAmount()) *product.getPrice();

            orderDetail.setAmount(orderDetail.getAmount()+" " + product.getProduct_unit());
            orderDetail.setPrice(String.valueOf(product.getPrice()) +" per " + product.getProduct_unit());

            orderDetail.setLine_item_total(totalPerProduct);

            totalProduct+=totalProduct;

        }

        order.setProducts_total(totalProduct);
        order.setDelivery_charge(5.00);
        order.setOrder_total(totalProduct+5.00);


        customers.get(cid).getOrderMap().put(order.getOid(),order);
        return order;
    }

    public Order getCustomerOrderById(String cid, String oid) {
        if (customers.get(cid)==null||customers.get(cid).getOrderMap().get(oid)==null) {
            throw new DataNotFoundException();
        }
        Order order = customers.get(cid).getOrderMap().get(oid);
        return order;
    }

    public void cancelOrder(String cid, Order order){
        String oid = order.getOid();
        Order original = getCustomerOrderById(cid, oid);

        if(order.getStatus().equals("cancelled")){
            original.setStatus("cancelled");
        }
    }

}
