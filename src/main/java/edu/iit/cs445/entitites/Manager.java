package edu.iit.cs445.entitites;

/**
 * Created by YongYang on 11/16/16.
 */
public class Manager {
    private String mid;
    private String name;
    private String created_by;
    private String create_date;
    private String phone;
    private String email;

    public Manager() {
    }

    public Manager(String mid, String name, String created_by, String create_date, String phone, String email) {
        this.mid = mid;
        this.name = name;
        this.created_by = created_by;
        this.create_date = create_date;
        this.phone = phone;
        this.email = email;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
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
}
