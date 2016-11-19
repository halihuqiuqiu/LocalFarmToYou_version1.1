package edu.iit.cs445.entitites;

import com.google.gson.annotations.Expose;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YongYang on 11/19/16.
 */
public class CustomerForReport {
    private String name;
    private String email;
    private String phone;

    public CustomerForReport() {
    }

    public CustomerForReport(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
