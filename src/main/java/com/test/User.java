package com.test;

public class User {
    private  String str;
    private  String str2;

    public User(String str, String str2) {
        this.str = str;
        this.str2 = str2;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    @Override
    public String toString() {
        return "User{" +
                "str='" + str + '\'' +
                ", str2='" + str2 + '\'' +
                '}';
    }

    public User() {
    }
}
