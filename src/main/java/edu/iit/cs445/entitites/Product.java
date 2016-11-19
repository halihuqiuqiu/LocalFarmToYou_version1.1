package edu.iit.cs445.entitites;

import com.google.gson.annotations.Expose;

/**
 * Created by YongYang on 11/7/16.
 */
public class Product {
    @Expose private String fspid;
    private String gcpid;
    @Expose private String name;
    @Expose private String note;
    @Expose private String start_date;
    @Expose private String end_date;
    @Expose private double price;
    @Expose private String product_unit;
    @Expose private String image;

    public Product() {
    }

    public Product(String fspid, String gcpid, String name, String note, String start_date, String end_date, double price, String product_unit, String image) {
        this.fspid = fspid;
        this.gcpid = gcpid;
        this.name =name;
        this.note = note;
        this.start_date = start_date;
        this.end_date = end_date;
        this.price = price;
        this.product_unit = product_unit;
        this.image = image;
    }


    public String getFspid() {
        return fspid;
    }

    public void setFspid(String fspid) {
        this.fspid = fspid;
    }

    public String getGcpid() {
        return gcpid;
    }

    public void setGcpid(String gcpid) {
        this.gcpid = gcpid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProduct_unit() {
        return product_unit;
    }

    public void setProduct_unit(String product_unit) {
        this.product_unit = product_unit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}