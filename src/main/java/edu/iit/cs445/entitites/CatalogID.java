package edu.iit.cs445.entitites;

/**
 * Created by YongYang on 11/7/16.
 */
public class CatalogID {
    private String gcpid;
    public CatalogID(String gcpid) {
        this.gcpid = gcpid;
    }

    public CatalogID() {

    }

    public String getGcpid() {

        return gcpid;
    }

    public void setGcpid(String gcpid) {
        this.gcpid = gcpid;
    }
}
