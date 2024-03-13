package com.dao;

public class User1 {
    private String qydm;
    private String qlr;
    private String zjh;

    public String getQydm() {
        return qydm;
    }

    public void setQydm(String qydm) {
        this.qydm = qydm;
    }

    public String getQlr() {
        return qlr;
    }

    public void setQlr(String qlr) {
        this.qlr = qlr;
    }

    public String getZjh() {
        return zjh;
    }

    public void setZjh(String zjh)
    {
        this.zjh = zjh;
    }


    public User1() {
    }

    public User1(String qydm, String qlr, String zjh) {
        this.qydm = qydm;
        this.qlr = qlr;
        this.zjh = zjh;
    }

    @Override
    public String toString() {
        return "User1{" +
                "qydm='" + qydm + '\'' +
                ", qlr='" + qlr + '\'' +
                ", zjh='" + zjh + '\'' +
                '}';
    }
}
