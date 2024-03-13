package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//接口
@RestController
public class Testjk3 {

    //    @RequestMapping("/str.do")
//    public void test2(String str){//单个参数 params
//        System.out.println("Str="+str);
//    }
//    @RequestMapping("/str1.do")
//    public void test3(@RequestBody String str){//单个参数 body
//        System.out.println("Str1="+str);
//    }estMapping("/str2.do")
    public String test4(@RequestBody String str) {//多个参数 body
        System.out.println("StrA=" + str);
        JSONObject json = JSON.parseObject(str);


//        ///////////////////////////////
//        Object ijs = json.get("ijs");
//        String ijsstr = ijs.toString();//Object转String只能用.toString
//        JSONObject ijsstrjsonObject = JSONObject.parseObject(ijsstr);
//        Object array = ijsstrjsonObject.get("array");
//        String arraystr = array.toString();
//        JSONArray arrayjs = JSONArray.parseArray(arraystr);
//        Object o = arrayjs.get(2);
//        String arraystro = o.toString();
//        JSONObject jsonObject = JSONObject.parseObject(arraystro);
//        Object name = jsonObject.get("name");
//        String namestr = name.toString();
//        Object age = jsonObject.get("age");
//        String agestr = age.toString();
//        System.out.println("agestr="+agestr+";namestr="+namestr);
    return "{\"name\":\"张三\",\"age\":\"14\"}";
    }


    //    @RequestMapping("/str3.do")
//    public void test5(@RequestBody User user){//对象参数 body
//        System.out.println("getStr="+user.getStr());
//        System.out.println("getStr2="+user.getStr2());
//    }
//
//    @RequestMapping("/str4.do")
//    public void test6(@RequestBody Map<String,Object> paramMap ){//MAP参数 body
//        System.out.println(paramMap.get("str"));
//        System.out.println(paramMap.get("str2"));
//    }
//    @RequestMapping("/str5.do")
//    public String test5(@RequestBody String str1, String str2, String st) {//多个参数 body +params +反射
//        JSONObject jsonObject = JSONObject.parseObject(str1);
//
//        jsonObject.put("test", str1);
//        System.out.println("str1=" + str1);
//        System.out.println("str2=" + str2);
//
//        System.out.println("st=" + st);
//        System.out.println("jsonObject.toJSONString()=" + jsonObject.toJSONString());
//        return jsonObject.toJSONString();
//    }
}
