package edu.iit.cs445.entitites;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YongYang on 11/17/16.
 */
public class ReportFarmerForDelivey {
    private String frid;
    private String name;
    private List<Order> orderList = new ArrayList<Order>();

    public ReportFarmerForDelivey() {
    }

    public ReportFarmerForDelivey(String frid, String name, List<Order> orderList) {
        this.frid = frid;
        this.name = name;
        this.orderList = orderList;
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
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
