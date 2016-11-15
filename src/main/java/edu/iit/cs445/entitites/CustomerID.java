package edu.iit.cs445.entitites;

/**
 * Created by YongYang on 11/6/16.
 */
public class CustomerID {
    private String cid;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public CustomerID(){

    }
    public CustomerID(String s){
        this.cid=s;
    }
}
