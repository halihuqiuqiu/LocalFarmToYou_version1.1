package edu.iit.cs445.entitites;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YongYang on 10/3/16.
 */
public class FarmerAccount {

    private String fid;
    private Farm farm_info;
    private Farmer personal_info;
    private List<String> delivers_to= new ArrayList<String>();


    public FarmerAccount() {
    }

    public FarmerAccount(String fid, Farm farm_info, Farmer personal_info, List<String> delivers_to) {
        this.fid = fid;
        this.farm_info = farm_info;
        this.personal_info = personal_info;
        this.delivers_to = delivers_to;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public Farm getFarm_info() {
        return farm_info;
    }

    public void setFarm_info(Farm farm_info) {
        this.farm_info = farm_info;
    }

    public Farmer getPersonal_info() {
        return personal_info;
    }

    public void setPersonal_info(Farmer personal_info) {
        this.personal_info = personal_info;
    }

    public List<String> getDelivers_to() {
        return delivers_to;
    }

    public void setDelivers_to(List<String> deliver_to) {
        this.delivers_to = delivers_to;
    }

}
