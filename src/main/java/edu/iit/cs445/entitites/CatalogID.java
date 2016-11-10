package edu.iit.cs445.entitites;

/**
 * Created by YongYang on 11/7/16.
 */
public class CatalogID {
    private long gcpid;
    public CatalogID(long gcpid) {
        this.gcpid = gcpid;
    }

    public CatalogID() {

    }

    public long getGcpid() {

        return gcpid;
    }

    public void setGcpid(long gcpid) {
        this.gcpid = gcpid;
    }
}
