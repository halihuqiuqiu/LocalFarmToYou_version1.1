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
        ReportFarmerForDelivey reportFarmerForDelivey = new ReportFarmerForDelivey();
        String deliverDate="";
        CustomerManager cm = new CustomerManager();

        reportFarmerForDelivey.setFrid(frid);
        if(frid.equals("1")){
            reportFarmerForDelivey.setName("Orders to deliver today");
            deliverDate = HelperDate.getTodayDateyyyyMMdd();

        }else if (frid.equals("2")){
            reportFarmerForDelivey.setName("Orders to deliver tomorrow");
            deliverDate = HelperDate.getTomorrowDateyyyyMMdd();
        }

        List<Order> orders = new ArrayList<Order>();
        List<Order> allOrderList = new ArrayList<Order>(Database.getOrderMap().values());
        for(Order o: allOrderList){
            if(o.getFid().equals(fid)&& o.getPlanned_delivery_date().equals(deliverDate)){  //order of this fid and date
                Order order = new Order();
                order = (Order)o.clone();
                order.setCid(null);
                order.setFid(null);
                order.setFarm_info(null);
                order.setDelivery_note(null);
                order.setNote(o.getDelivery_note());

                Customer customer = cm.getCustomerById(o.getCid());
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

        reportFarmerForDelivey.setOrders(orders);

        return reportFarmerForDelivey;
    }
}
