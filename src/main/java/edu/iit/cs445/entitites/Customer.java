package edu.iit.cs445.entitites;


/**
 * Created by YongYang on 11/4/16.
 */

public class Customer {
    private long cid;
    private String name;
    private String street;
    private String zip;
    private String phone;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getID() {
        return cid;
    }

    public void setID(long ID) {
        this.cid = ID;
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

    public Customer(){
    }
    public Customer(long ID, String name, String street, String zip, String phone, String email) {

        this.cid=ID;
        this.name=name;
        this.street=street;
        this.zip=zip;
        this.phone=phone;
        this.email=email;

    }


    public boolean matchesId(long cid) {
        return(cid == this.cid);
    }

    public boolean isNil() {
        return false;
    }
}
