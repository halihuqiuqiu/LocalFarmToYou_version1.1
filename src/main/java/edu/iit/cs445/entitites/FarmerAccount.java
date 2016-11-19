package edu.iit.cs445.entitites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;
import edu.iit.cs445.exception.BadRequestException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.PublicKey;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YongYang on 10/3/16.
 */
@JsonIgnoreProperties(value = { "naem","productsMap", "delivery_charge","reportFarmers"})
public class FarmerAccount {
    @Expose private String fid;
    @Expose private String name;
    private Farm farm_info;
    private Farmer personal_info;
    private ArrayList<String> delivers_to= new ArrayList<String>();
    private Map<String,Product> productsMap = new HashMap<String, Product>();
    private double delivery_charge;
    private List<ReportFarmer> reportFarmers= new ArrayList<ReportFarmer>();


    public FarmerAccount() {
        BigDecimal bd = new BigDecimal(0.00).setScale(2,RoundingMode.FLOOR);
        this.delivery_charge = bd.doubleValue();

    }

    public FarmerAccount(String name, String fid, Farm farm_info, Farmer personal_info, ArrayList<String> delivers_to, Map<String, Product> productsMap, double delivery_charge, List<ReportFarmer> reportFarmers) {
        this.name = name;
        this.fid = fid;
        this.farm_info = farm_info;
        this.personal_info = personal_info;
        this.delivers_to = delivers_to;
        this.productsMap = productsMap;
        this.delivery_charge = delivery_charge;
        this.reportFarmers = reportFarmers;
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

    public ArrayList<String> getDelivers_to() {
        return delivers_to;
    }

    public void setDelivers_to(ArrayList<String> delivers_to) {
        this.delivers_to = delivers_to;
    }

    public Map<String, Product> getProductsMap() {
        return productsMap;
    }

    public void setProductsMap(Map<String, Product> productsMap) {
        this.productsMap = productsMap;
    }

    public double getDelivery_charge() {
        DecimalFormat df = new DecimalFormat("0.00");
        Double d = Double.parseDouble(df.format(delivery_charge));

        return d;
    }

    public void setDelivery_charge(double delivery_charge) {
        if (delivery_charge<0){
            throw new BadRequestException();    //delivery_charge should >=0
        }
        this.delivery_charge = delivery_charge;
    }

    public List<ReportFarmer> getReportFarmers() {
        return reportFarmers;
    }

    public void setReportFarmers(List<ReportFarmer> reportFarmers) {
        this.reportFarmers = reportFarmers;
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

    public List<ReportFarmer> returnAllKindReports(){
        reportFarmers.add(new ReportFarmer("1","Orders to deliver today"));
        reportFarmers.add(new ReportFarmer("2","Orders to deliver tomorrow"));
        reportFarmers.add(new ReportFarmer("3","Revenue report"));
        reportFarmers.add(new ReportFarmer("4","Orders delivery report"));
        return reportFarmers;

    }

}
