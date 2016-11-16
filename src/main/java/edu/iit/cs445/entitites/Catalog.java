package edu.iit.cs445.entitites;

/**
 * Created by YongYang on 11/7/16.
 */
public class Catalog {
    private String gcpid;
    private String name;

    public Catalog(String gcpid, String name) {
        this.gcpid = gcpid;
        this.name = name;
    }

    public Catalog() {

    }

    public String getGcpid() {

        return gcpid;
    }

    public void setGcpid(String gcpid) {
        this.gcpid = gcpid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
