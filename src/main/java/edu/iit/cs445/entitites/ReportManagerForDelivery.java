package edu.iit.cs445.entitites;

/**
 * Created by YongYang on 11/18/16.
 */
public class ReportManagerForDelivery {
    private String mrid;
    private String name;
    private int orders_placed;

    public ReportManagerForDelivery() {
    }

    public ReportManagerForDelivery(String mrid, String name, int orders_placed) {
        this.mrid = mrid;
        this.name = name;
        this.orders_placed = orders_placed;
    }

    public String getMrid() {
        return mrid;
    }

    public void setMrid(String mrid) {
        this.mrid = mrid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrders_placed() {
        return orders_placed;
    }

    public void setOrders_placed(int orders_placed) {
        this.orders_placed = orders_placed;
    }
}
