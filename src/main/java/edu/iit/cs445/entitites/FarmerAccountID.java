package edu.iit.cs445.entitites;

/**
 * Created by YongYang on 11/7/16.
 */
public class FarmerAccountID {
    long fid;

    public FarmerAccountID() {
    }

    public FarmerAccountID(long fid) {
        this.fid = fid;
    }

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }
}
