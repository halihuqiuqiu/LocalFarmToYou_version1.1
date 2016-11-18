package edu.iit.cs445.entitites;

/**
 * Created by YongYang on 11/17/16.
 */
public class ReportFarmer {
    private String frid;
    private String name;

    public ReportFarmer() {
    }

    public ReportFarmer(String frid, String name) {
        this.frid = frid;
        this.name = name;
    }

    public String getFrid() {
        return frid;
    }

    public void setFrid(String frid) {
        this.frid = frid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
