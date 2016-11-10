package edu.iit.cs445.entitites;

/**
 * Created by YongYang on 11/7/16.
 */
public class ProductID {
    private long fspid;

    public ProductID() {
    }

    public ProductID(long fspid) {

        this.fspid = fspid;
    }

    public long getFspid() {
        return fspid;
    }

    public void setFspid(long fspid) {
        this.fspid = fspid;
    }
}
