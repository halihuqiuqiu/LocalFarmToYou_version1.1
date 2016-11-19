package edu.iit.cs445.entitites;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YongYang on 11/17/16.
 */
public class ReportFarmerForDelivey {
    private String frid;
    private String name;
    private List<OrderForReport> orders = new ArrayList<OrderForReport>();

    public ReportFarmerForDelivey() {
    }

    public ReportFarmerForDelivey(String frid, String name, List<OrderForReport> orders) {
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

    public List<OrderForReport> getOrderList() {
        return orders;
    }

    public void setOrders(List<OrderForReport> orders) {
        this.orders = orders;
    }
}
