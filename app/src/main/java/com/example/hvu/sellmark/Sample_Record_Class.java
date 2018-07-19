package com.example.hvu.sellmark;

public class Sample_Record_Class {
    private String srid;
    private String ename;
    private String requestby;
    private String quantity;
    private String price;
    private String type;

    public Sample_Record_Class(String srid, String ename, String requestby, String quantity, String price, String type) {
        this.srid = srid;
        this.ename = ename;
        this.requestby = requestby;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }

    public  Sample_Record_Class(String ename){
        this.ename = ename;
    }

    public String getSrid() {
        return srid;
    }

    public void setSrid(String srid) {
        this.srid = srid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getRequestby() {
        return requestby;
    }

    public void setRequestby(String requestby) {
        this.requestby = requestby;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
