package com.dao;

public class User2 {
    private  String qydm;
    private  String qlbsms;
    private  long timestamp;

    @Override
    public String toString() {
        return "User2{" +
                "qydm='" + qydm + '\'' +
                ", qlbsms='" + qlbsms + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public String getQydm() {
        return qydm;
    }

    public void setQydm(String qydm) {
        this.qydm = qydm;
    }

    public String getQlbsms() {
        return qlbsms;
    }

    public void setQlbsms(String qlbsms) {
        this.qlbsms = qlbsms;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public User2() {
    }

    public User2(String qydm, String qlbsms, long timestamp) {
        this.qydm = qydm;
        this.qlbsms = qlbsms;
        this.timestamp = timestamp;
    }
}
