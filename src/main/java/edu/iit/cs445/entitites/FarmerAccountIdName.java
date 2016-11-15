package edu.iit.cs445.entitites;

/**
 * Created by YongYang on 11/15/16.
 */
public class FarmerAccountIdName {
    private String fid;
    private String name;

    public FarmerAccountIdName() {
    }

    public FarmerAccountIdName(String fid, String name) {
        this.fid = fid;
        this.name = name;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
