package edu.iit.cs445.entitites;

import com.google.gson.annotations.Expose;

import java.text.DecimalFormat;

/**
 * Created by YongYang on 11/17/16.
 */
public class OrderDetail {
    @Expose private String fspid;
    @Expose private String name;
    @Expose private String amount;
    @Expose private String price;
    @Expose private double line_item_total;

    public OrderDetail() {
    }

    public OrderDetail(String fspid, String name, String amount, String price, double line_item_total) {
        this.fspid = fspid;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.line_item_total = line_item_total;
    }

    public String getFspid() {
        return fspid;
    }

    public void setFspid(String fspid) {
        this.fspid = fspid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public double getLine_item_total() {
        DecimalFormat df = new DecimalFormat("0.00");
        Double d = Double.parseDouble(df.format(line_item_total));

        return d;
    }

    public void setLine_item_total(double line_item_total) {
        this.line_item_total = line_item_total;
    }
}
