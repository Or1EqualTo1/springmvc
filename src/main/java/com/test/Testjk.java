package com.test;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;


@RestController
public class Testjk {
    @RequestMapping("/ys.do")
    public String testjk(String dd,Integer dk) {

        StringBuffer buffer = new StringBuffer();
        String requestURL="http://127.0.0.1:8089/srch.do?srcval="+dd;//请求路径，必填
        String params="asdfsae";//请求参数，必填，数据格式为JSON

        String proxyHost="127.0.0.1";//代理IP，即服务器代理地址，可为null
        Integer proxyPort=dk;//代理端口，可为null
        HttpURLConnection conn = null;
        try {
            URL url = new URL(requestURL);
            // 判断是否需要代理模式请求http
            if (proxyHost != null && proxyPort != null) {
                // 如果是本机自己测试, 不需要代理请求,但发到服务器上的时候需要代理请求
                // 对http开启全局代理
                //System.setProperty("http.proxyHost", proxyHost);
                //System.setProperty("http.proxyPort", proxyPort);
                // 对https开启全局代理
                //System.setProperty("https.proxyHost", proxyHost);
                //System.setProperty("https.proxyPort", proxyPort);
                // 代理访问http请求
  Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
                conn = (HttpURLConnection) url.openConnection(proxy);
            } else {
                // 原生访问http请求，未代理请求
                conn = (HttpURLConnection) url.openConnection();
            }

            // 设置请求的属性
            conn.setDoOutput(true); // 是否可以输出
            conn.setRequestMethod("POST"); // 请求方式, 只包含"GET", "POST", "HEAD", "OPTIONS", "PUT", "DELETE", "TRACE"六种
            conn.setConnectTimeout(60000); // 最高超时时间
            conn.setReadTimeout(60000); // 最高读取时间
            conn.setConnectTimeout(60000); // 最高连接时间

            conn.setDoInput(true); // 是否可以输入
            if (params != null) {
                // 设置参数为json格式
                //设置请求头
                conn.setRequestProperty("Content-type", "application/json");
                OutputStream os = conn.getOutputStream();
                try {
                    os.write(params.getBytes("UTF-8"));

                } catch (Exception e) {
                    System.out.println("HttpPostUtils doPost error: " + e);
                } finally {
                    try {
                        if (os != null) {
                            os.close();
                        }
                    } catch (IOException e) {
                        System.out.println("HttpPostUtils doPost error: " + e);
                    }
                }
            }

            // 读取数据
            InputStream is = null;
            InputStreamReader inputReader = null;
            BufferedReader reader = null;
            try {
                is = conn.getInputStream();
                inputReader = new InputStreamReader(is, "UTF-8");
                reader = new BufferedReader(inputReader);
                String temp;
                while ((temp = reader.readLine()) != null) {
                    buffer.append(temp);
                    StringBuffer append = buffer.append(temp);
                    System.out.println("append.toString()="+append.toString());
                    JSONObject jsonObject = JSONObject.parseObject(append.toString());
                    System.out.println("jsonObject="+jsonObject.toJSONString());

                }
            } catch (Exception e) {
                System.out.println("HttpPostUtils doPost error: " + e);
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                    if (inputReader != null) {
                        inputReader.close();
                    }
                    if (is != null) {
                        is.close();
                    }
                } catch (IOException e) {
                    System.out.println("HttpPostUtils doPost error: " + e);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 当http连接空闲时, 释放资源
            if (conn != null) {
                conn.disconnect();
            }
        }
        return /*buffer.length()==0 ? "" : */buffer.toString();
    }
}
