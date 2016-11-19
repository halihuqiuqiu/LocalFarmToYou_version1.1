package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.entitites.Customer;
import edu.iit.cs445.entitites.FarmerAccount;
import edu.iit.cs445.entitites.Order;
import edu.iit.cs445.entitites.ReportFarmerForDelivey;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YongYang on 11/17/16.
 */
public class MakeReportFarmerForDelivery {
    public static ReportFarmerForDelivey returnReport(String fid, String frid){
        ReportFarmerForDelivey report = new ReportFarmerForDelivey();
        String deliverDate="";
        CustomerManager cm = new CustomerManager();

        report.setFrid(frid);
        if(frid.equals("1")){
            report.setName("Orders to deliver today");
            deliverDate = HelperDate.getTodayDateyyyyMMdd();

        }else if (frid.equals("2")){
            report.setName("Orders to deliver tomorrow");
            deliverDate = HelperDate.getTomorrowDateyyyyMMdd();
        }

        List<Order> orders = new ArrayList<Order>();
        List<Order> orderList = new ArrayList<Order>(Database.getOrderMap().values());
        for(Order order: orderList){
            if(order.getFid().equals(fid)&& order.getPlanned_delivery_date().equals(deliverDate)){  //order of this fid and date
                Order o = new Order();
                o = (Order)order.clone();
                o.setCid(null);
                o.setFid(null);
                o.setFarm_info(null);
                o.setNote(o.getDelivery_note());
                o.setDelivery_note(null);

                Customer customer = cm.getCustomerById(order.getCid());
                String address = customer.getStreet() + " " + customer.getZip();
                order.setDelivery_address(address);

                Customer customerToShow = (Customer) customer.clone();
                customerToShow.setCid(null);
                customerToShow.setZip(null);
                customerToShow.setStreet(null);
                customerToShow.setOrderMap(null);
                order.setOrder_by(customer);

            }

        }

        report.setOrders(orders);

        return report;
    }
}
