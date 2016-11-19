package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.entitites.*;

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

        List<OrderForReport> orders = new ArrayList<OrderForReport>();
        List<Order> orderList = new ArrayList<Order>(Database.getOrderMap().values());
        for(Order order: orderList){
            if(order.getFid().equals(fid)&& order.getPlanned_delivery_date().equals(deliverDate)){  //order of this fid and date
                OrderForReport o = new OrderForReport();
                o.setOid(order.getOid());
                o.setProducts_total(order.getProducts_total());
                o.setDelivery_charge(order.getDelivery_charge());
                o.setOrder_total(order.getOrder_total());
                o.setStatus(order.getStatus());
                o.setOrder_date(order.getOrder_date());
                o.setPlanned_delivery_date(order.getPlanned_delivery_date());
                o.setActual_delivery_date(order.getActual_delivery_date());

                Customer customer = cm.getCustomerById(order.getCid());
                CustomerForReport customerForReport = new CustomerForReport();
                customerForReport.setName(customer.getName());
                customerForReport.setEmail(customer.getEmail());
                customerForReport.setPhone(customer.getPhone());

                o.setOrder_by(customerForReport);

                String address = customer.getStreet() + " " + customer.getZip();
                o.setDelivery_address(address);

                o.setNote(order.getDelivery_note());
                o.setOrder_detail(order.getOrder_detail());

                orders.add(o);

            }

        }

        report.setOrders(orders);


        return report;
    }
}
