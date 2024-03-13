package com.utils;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesParam {
    private static String driverClassName;
    private static String url;
    private static String username;
    private static String password;
    private static String privateKey;
    private static String publicKey;

    public  String getDriverClassName() {
        return driverClassName;
    }

    public  String getUrl() {
        return url;
    }

    public  String getUsername() {
        return username;
    }

    public  String getPassword() {
        return password;
    }

    public  String getPrivateKey() {
        return privateKey;
    }

    public  String getPublicKey() {
        return publicKey;
    }

    public  PropertiesParam() {
        Properties prop = null;
        try {
            prop = PropertiesLoaderUtils.loadAllProperties("db.properties");
            driverClassName = prop.getProperty("driverClassName");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            privateKey = prop.getProperty("privateKey");
            publicKey = prop.getProperty("publicKey");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
