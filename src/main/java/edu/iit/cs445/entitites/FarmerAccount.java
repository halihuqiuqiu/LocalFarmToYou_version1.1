package edu.iit.cs445.entitites;

import edu.iit.cs445.exception.BadRequestException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YongYang on 10/3/16.
 */
public class FarmerAccount {

    private String name;
    private String fid;
    private Farm farm_info;
    private Farmer personal_info;
    private List<String> delivers_to=new ArrayList<String>();
    private Map<String,Product> productsMap = new HashMap<String, Product>();
    private double delivery_charge;


    public FarmerAccount() {
        this.delivery_charge=0.00;
    }

    public FarmerAccount(String name, String fid, Farm farm_info, Farmer personal_info, List<String> delivers_to, Map<String, Product> productsMap, double delivery_charge) {
        this.name = name;
        this.fid = fid;
        this.farm_info = farm_info;
        this.personal_info = personal_info;
        this.delivers_to = delivers_to;
        this.productsMap = productsMap;
        this.delivery_charge = delivery_charge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Map<String, Product> getProductsMap() {
        return productsMap;
    }

    public void setProductsMap(Map<String, Product> productsMap) {
        this.productsMap = productsMap;
    }

    public double getDelivery_charge() {
        return delivery_charge;
    }

    public void setDelivery_charge(double delivery_charge) {
        if (delivery_charge<0){
            throw new BadRequestException();    //delivery_charge should >=0
        }
        this.delivery_charge = delivery_charge;
    }

    public void validateEntity(){
        boolean b = getFarm_info()==null ||
                getPersonal_info()==null ||
                getDelivers_to().isEmpty();
        if(b){
            throw new BadRequestException();
        }

        boolean c =getFarm_info().getName()==null ||
                getFarm_info().getAddress()==null||
                getFarm_info().getPhone()==null||
                getFarm_info().getWeb()==null;


        boolean d= getPersonal_info().getEmail()==null||
                getPersonal_info().getName()==null||
                getPersonal_info().getPhone()==null;

        if(c||d){
            throw new BadRequestException();
        }
    }

}
