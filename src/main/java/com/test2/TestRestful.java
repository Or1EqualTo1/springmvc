package com.test2;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.ApiEncryptInfoDTO;
import com.bw.SM2Utils;
import com.dao.User1;
import com.utils.DbLink;
import com.utils.PropertiesParam;
import com.utils.Return31;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

@RestController
public class TestRestful {
    @RequestMapping("/ree/app/api/kq1")
    public String test4(@RequestBody String str) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println("3.1||" + formatter.format(date));

        JSONObject jsonObject = JSONObject.parseObject(str);
        Object encryptParam = jsonObject.get("encryptParam");
        String encryptParamString = encryptParam.toString();
        System.out.println("encrypt=" + encryptParamString);
        ApiEncryptInfoDTO dto2 = new ApiEncryptInfoDTO();
        dto2.setDataHex(encryptParamString);
        dto2 = SM2Utils.decrypt2Data(dto2);
        System.out.println("after_decrypt=" + dto2.getData());

        JSONObject jsonObject1 = JSONObject.parseObject(dto2.getData());
        String qlr = jsonObject1.get("qlr").toString();
        String zjh = jsonObject1.get("zjh").toString();
        String qydm = jsonObject1.get("qydm").toString();
        JSONObject js2 = new Return31().Return31(new User1(qydm, qlr, zjh));


//        js.put("qlr", "江兵");
//        js.put("zjh", "370703199205241513");
//        js.put("bdcdyh", "371083001005GB09999F00010002");
//        js.put("bdcqzh", "45668946s516");
//        js.put("qlxz", "102");
//        js.put("qllx", "4");
//        js.put("fwxz", "0");
//        js.put("fwxzmc", "市场化商品房");
//        js.put("zl", "测试数据测试数据测试数据");
//        js.put("jzmj", 50.23);
//        js.put("yt", "10");
//        js.put("ytmc", "住宅");
//        js.put("gyfs", "0");
//        js.put("jzjg", "5");
//        js.put("jzlx", "1");
//        js.put("hx", "2");
//        js.put("hxjg", "1");
//        js.put("qlbsm", 1513);
//        js.put("jznd", "2005");
//        js.put("xqmc", "测试项目");
//        js.put("lc", 1);
//        js.put("zc", 1);
//        js.put("fzsj", "2005-09-30");
//        js.put("qxdm", "371083");
//        js.put("zsfj", "");
//        js.put("zszt1", 0);
//        js.put("zszt2", 0);
//        js.put("zszt3", 0);
//        js.put("isrestrict", false);
//        js.put("xzsm", "该房源具备发布条件");

//        ApiEncryptInfoDTO dto = new ApiEncryptInfoDTO();
//        dto.setData(js.toJSONString());
//        dto = SM2Utils.encrypt2Data(dto);
//        String dataHex = dto.getDataHex();
//        System.out.println("返回_未加密=" + js.toJSONString());
//        System.out.println("before_encrypt=" + dto.getDataHex());


        System.out.println("js2.toJSONString()="+js2.toJSONString());
        return js2.toJSONString();

    }
}
