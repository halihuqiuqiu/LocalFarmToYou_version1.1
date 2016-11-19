package edu.iit.cs445.entitites;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YongYang on 11/19/16.
 */
public class OrderForReport {
    private String oid;
    private double products_total;
    private double delivery_charge;
    private double order_total;
    private String status;
    private String order_date;
    private String planned_delivery_date;
    private String actual_delivery_date;
    private CustomerForReport order_by;
    private String delivery_address;
    private String note;
    private List<OrderDetail> order_detail = new ArrayList<OrderDetail>();

    public OrderForReport() {
    }

    public OrderForReport(String oid, double products_total, double delivery_charge, double order_total,
                          String status, String order_date, String planned_delivery_date,
                          String actual_delivery_date, CustomerForReport order_by, String delivery_address,
                          String note, List<OrderDetail> order_detail) {
        this.oid = oid;
        this.products_total = products_total;
        this.delivery_charge = delivery_charge;
        this.order_total = order_total;
        this.status = status;
        this.order_date = order_date;
        this.planned_delivery_date = planned_delivery_date;
        this.actual_delivery_date = actual_delivery_date;
        this.order_by = order_by;
        this.delivery_address = delivery_address;
        this.note = note;
        this.order_detail = order_detail;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public double getProducts_total() {
        return products_total;
    }

    public void setProducts_total(double products_total) {
        this.products_total = products_total;
    }

    public double getDelivery_charge() {
        return delivery_charge;
    }

    public void setDelivery_charge(double delivery_charge) {
        this.delivery_charge = delivery_charge;
    }

    public double getOrder_total() {
        return order_total;
    }

    public void setOrder_total(double order_total) {
        this.order_total = order_total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getPlanned_delivery_date() {
        return planned_delivery_date;
    }

    public void setPlanned_delivery_date(String planned_delivery_date) {
        this.planned_delivery_date = planned_delivery_date;
    }

    public String getActual_delivery_date() {
        return actual_delivery_date;
    }

    public void setActual_delivery_date(String actual_delivery_date) {
        this.actual_delivery_date = actual_delivery_date;
    }

    public CustomerForReport getOrder_by() {
        return order_by;
    }

    public void setOrder_by(CustomerForReport order_by) {
        this.order_by = order_by;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<OrderDetail> getOrder_detail() {
        return order_detail;
    }

    public void setOrder_detail(List<OrderDetail> order_detail) {
        this.order_detail = order_detail;
    }
}
