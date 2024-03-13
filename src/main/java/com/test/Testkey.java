package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
//import com.bw.test;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//接口
@RestController
public class Testkey {
    @RequestMapping("/str22.do")
    public void test4(@RequestBody String str) {//多个参数 body
        System.out.println("Str=" + str);
//        JSON json = JSON.parseObject(str);
//        System.out.println("jsontoJSONString=" + json.toJSONString());
//        test ts=new test();
//        ts.jiemi(str);

    }
}
