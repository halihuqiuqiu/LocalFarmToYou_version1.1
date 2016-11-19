package edu.iit.cs445.entitites;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YongYang on 10/3/16.
 */
public class Order implements Cloneable {
    private String cid;
    private Customer order_by;
    private String delivery_address;
    @Expose private String oid;
    @Expose private String order_date;
    @Expose private String planned_delivery_date;
    @Expose private String actual_delivery_date = "default";
    @Expose private String status;
    @Expose private String fid;
    private Farm farm_info;
    private List<OrderDetail> order_detail = new ArrayList<OrderDetail>();
    private String delivery_note;
    private String note;
    private double products_total;
    private double delivery_charge;
    private double order_total;

    public Order() {
    }

    public Order(String cid, Customer order_by, String delivery_address, String oid, String fid, String order_date, String planned_delivery_date, String actual_delivery_date, String status, Farm farm_info, List<OrderDetail> order_detail, String delivery_note, String note, double products_total, double delivery_charge, double order_total) {
        this.cid = cid;
        this.order_by = order_by;
        this.delivery_address = delivery_address;
        this.oid = oid;
        this.fid = fid;
        this.order_date = order_date;
        this.planned_delivery_date = planned_delivery_date;
        this.actual_delivery_date = actual_delivery_date;
        this.status = status;
        this.farm_info = farm_info;
        this.order_detail = order_detail;
        this.delivery_note = delivery_note;
        this.note = note;
        this.products_total = products_total;
        this.delivery_charge = delivery_charge;
        this.order_total = order_total;
    }

    @Override
    public Object clone() {
        Order order = null;
        try{
            order =(Order) super.clone();
        }catch (CloneNotSupportedException e){

        }
        return order;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Farm getFarm_info() {
        return farm_info;
    }

    public void setFarm_info(Farm farm_info) {
        this.farm_info = farm_info;
    }

    public List<OrderDetail> getOrder_detail() {
        return order_detail;
    }

    public void setOrder_detail(List<OrderDetail> order_detail) {
        this.order_detail = order_detail;
    }

    public String getDelivery_note() {
        return delivery_note;
    }

    public void setDelivery_note(String delivery_note) {
        this.delivery_note = delivery_note;
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

    public Customer getOrder_by() {
        return order_by;
    }

    public void setOrder_by(Customer order_by) {
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
}
