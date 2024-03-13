package com.test2;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.ApiEncryptInfoDTO;
import com.bw.SM2Utils;
import com.dao.User1;
import com.utils.Return31;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

@RestController
public class TestRestful2 {
    @RequestMapping("/ree/app/api/kq2")
    public String test4(@RequestBody String str) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println("3.2||" + formatter.format(date));

        JSONObject jsonObject = JSONObject.parseObject(str);
        Object encryptParam = jsonObject.get("encryptParam");
        String encryptParamString = encryptParam.toString();
        System.out.println("encrypt=" + encryptParamString);
        ApiEncryptInfoDTO dto2 = new ApiEncryptInfoDTO();
        dto2.setDataHex(encryptParamString);
        dto2 = SM2Utils.decrypt2Data(dto2);
        System.out.println("after_decrypt=" + dto2.getData());

        JSONObject jsonObject1 = JSONObject.parseObject(dto2.getData());
//        String qlr = jsonObject1.get("qlr").toString();
//        String zjh = jsonObject1.get("zjh").toString();
        String qydm = jsonObject1.get("qydm").toString();
        JSONObject js2 = new Return31().Return31(new User1(qydm, "qlr", "zjh"));

        System.out.println("js2.toJSONString()="+js2.toJSONString());
        return js2.toJSONString();

    }
}
