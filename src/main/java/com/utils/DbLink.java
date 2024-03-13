package com.utils;

import com.alibaba.fastjson.JSONObject;
import com.dao.User1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbLink {
    public static Connection con;

    public Connection dbLink() {
        try {
            Class.forName(new PropertiesParam().getDriverClassName());
            con = DriverManager.getConnection(new PropertiesParam().getUrl(), new PropertiesParam().getUsername(),
                    new PropertiesParam().getPassword());
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
            return null;
        }
    }
}
