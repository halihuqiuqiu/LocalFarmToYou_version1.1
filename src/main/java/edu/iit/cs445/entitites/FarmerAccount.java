package edu.iit.cs445.entitites;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YongYang on 10/3/16.
 */
public class FarmerAccount {

    private long fid;
    private Farm farm_info;
    private Farmer personal_info;
    private List<String> deliver_to;
    private static Map<Long, Product> products = new HashMap<Long, Product>();


    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
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

    public List<String> getDeliver_to() {
        return deliver_to;
    }

    public void setDeliver_to(List<String> deliver_to) {
        this.deliver_to = deliver_to;
    }

    public static Map<Long, Product> getProducts() {
        return products;
    }

    public static void setProducts(Map<Long, Product> products) {
        edu.iit.cs445.entitites.FarmerAccount.products = products;
    }
}
