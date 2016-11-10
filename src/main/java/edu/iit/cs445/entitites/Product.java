package edu.iit.cs445.entitites;

/**
 * Created by YongYang on 11/7/16.
 */
public class Product {
    private long fspid;
    private String gfcid;
    private String note;
    private String start_date;
    private String end_date;
    private Double price;
    private String product_unit;
    private String image;

    public Product() {
    }

    public Product(long fspid, String gfcid, String note, String start_date, String end_date, Double price, String product_unit, String image) {
        this.fspid = fspid;
        this.gfcid = gfcid;
        this.note = note;
        this.start_date = start_date;
        this.end_date = end_date;
        this.price = price;
        this.product_unit = product_unit;
        this.image = image;
    }

    public long getFspid() {
        return fspid;
    }

    public void setFspid(long fspid) {
        this.fspid = fspid;
    }

    public String getGfcid() {
        return gfcid;
    }

    public void setGfcid(String gfcid) {
        this.gfcid = gfcid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProduct_unit() {
        return product_unit;
    }

    public void setProduct_unit(String product_unit) {
        this.product_unit = product_unit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}