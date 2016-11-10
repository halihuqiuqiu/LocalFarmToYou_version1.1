package edu.iit.cs445.entitites;

/**
 * Created by YongYang on 11/7/16.
 */
public class Farmer {
    private String name;
    private String email;
    private String phone;

    public Farmer() {
    }

    public Farmer(String name, String email, String phone) {
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
