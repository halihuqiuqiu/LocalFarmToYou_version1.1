package edu.iit.cs445.entitites;

/**
 * Created by YongYang on 11/6/16.
 */
public class CustomerID {
    private long cid;

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public CustomerID(){

    }
    public CustomerID(long s){
        this.cid=s;
    }
}
