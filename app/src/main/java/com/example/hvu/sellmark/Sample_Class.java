package com.example.hvu.sellmark;

public class Sample_Class {
    private String sid;
    private String sname;
    private String sdescription;
    private String simage;

    public Sample_Class(String sid, String sname, String sdescription, String simage) {
        this.sid = sid;
        this.sname = sname;
        this.sdescription = sdescription;
        this.simage = simage;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSdescription() {
        return sdescription;
    }

    public void setSdescription(String sdescription) {
        this.sdescription = sdescription;
    }

    public String getSimage() {
        return simage;
    }

    public void setSimage(String simage) {
        this.simage = simage;
    }
}
