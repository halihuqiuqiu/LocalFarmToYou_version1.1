package edu.iit.cs445.entitites;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by YongYang on 11/4/16.
 */

public class Customer {
    private String cid;
    private String name;
    private String street;
    private String zip;
    private String phone;
    private String email;
    private Map<String,Order> orderMap = new HashMap<String, Order>();

    public Customer(){
    }

    public Customer(String cid, String name, String street, String zip, String phone, String email, Map<String, Order> orderMap) {
        this.cid = cid;
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.orderMap = orderMap;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Order> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<String, Order> orderMap) {
        this.orderMap = orderMap;
    }
}
