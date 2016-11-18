package edu.iit.cs445.entitites;

/**
 * Created by YongYang on 11/17/16.
 */
public class ReportManager {

    private String mrid;
    private String name;

    public ReportManager() {
    }

    public ReportManager(String mrid, String name) {
        this.mrid = mrid;
        this.name = name;
    }

    public String getMrid() {
        return mrid;
    }

    public void setMrid(String mrid) {
        this.mrid = mrid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
