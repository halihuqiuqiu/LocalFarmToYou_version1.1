package edu.iit.cs445.entitites;

/**
 * Created by YongYang on 11/7/16.
 */
public class Farm {
    private String fid;
    private String name;
    private String address;
    private String phone;
    private String web;

    public Farm() {
    }

    public Farm(String fid, String name, String address, String phone, String web) {
        this.fid = fid;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.web = web;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
