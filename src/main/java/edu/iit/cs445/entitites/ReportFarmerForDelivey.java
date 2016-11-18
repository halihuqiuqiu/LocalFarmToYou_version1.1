package edu.iit.cs445.entitites;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YongYang on 11/17/16.
 */
public class ReportFarmerForDelivey {
    private String frid;
    private String name;
    private List<Order> orders = new ArrayList<Order>();

    public ReportFarmerForDelivey() {
    }

    public ReportFarmerForDelivey(String frid, String name, List<Order> orders) {
        this.frid = frid;
        this.name = name;
        this.orders = orders;
    }

    public String getFrid() {
        return frid;
    }

    public void setFrid(String frid) {
        this.frid = frid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrderList() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
