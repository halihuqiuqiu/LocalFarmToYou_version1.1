package edu.iit.cs445.entitites;

/**
 * Created by YongYang on 11/7/16.
 */
public class ProductID {
    private String fspid;

    public ProductID() {
    }

    public ProductID(String fspid) {

        this.fspid = fspid;
    }

    public String getFspid() {
        return fspid;
    }

    public void setFspid(String fspid) {
        this.fspid = fspid;
    }
}
