//package com.test;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.bw.ApiEncryptInfoDTO;
//import com.bw.SM2Utils;
//import com.dao.User1;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class TestRestful {
////    @RequestMapping("/ree/app/api/kq1/{str}")
//    public String test4(@PathVariable("str") String str) {
//        System.out.println(str);
//        JSONObject js = new JSONObject();
//        JSONObject js2 = new JSONObject();
//
//        JSONObject jsonObject = JSONObject.parseObject(str);
//        Object encryptParam = jsonObject.get("encryptParam");
//        String encryptParamString = encryptParam.toString();
//        System.out.println("encryptParamString=" + encryptParamString);
//
//
//        ApiEncryptInfoDTO dto2 = new ApiEncryptInfoDTO();
//        dto2.setDataHex(encryptParamString);
//        dto2 = SM2Utils.decrypt2Data(dto2);
//        System.out.println("dto2.getData=" + dto2.getData());
//
//        User1 u1 = new User1();
//        JSONObject jsonObject1 = JSONObject.parseObject(dto2.getData());
//        Object qydm = jsonObject1.get("qydm");
//        u1.setQydm(qydm.toString());
//        Object qlr = jsonObject1.get("qlr");
//        u1.setQlr(qlr.toString());
//        Object zjh = jsonObject1.get("zjh");
//        u1.setZjh(zjh.toString());
//        Object timestamp = jsonObject1.get("timestamp");
//        u1.setTimestamp(Long.parseLong(timestamp.toString()));
//
//        System.out.println("u1.toString()=" + u1.getTimestamp());
//
//
//        js.put("qlr","江兵");
//        js.put("zjh","370703199205241513");
//        js.put("bdcdyh","371083001005GB09999F00010002");
//        js.put("bdcqzh","45668946s516");
//        js.put("qlxz","102");
//        js.put("qllx","4");
//        js.put("fwxz","0");
//        js.put("fwxzmc","市场化商品房");
//        js.put("zl","测试数据测试数据测试数据");
//        js.put("jzmj",50.23);
//        js.put("yt","10");
//        js.put("ytmc","住宅");
//        js.put("gyfs","单独所有");
//        js.put("jzjg","5");
//        js.put("jzlx","1");
//        js.put("hx","2");
//        js.put("hxjg","1");
//        js.put("qlbsm",1);
//        js.put("jznd","2005-05-30");
//        js.put("xqmc","测试项目");
//        js.put("lc",1);
//        js.put("zc",1);
//        js.put("fzsj","2005-09-30");
//        js.put("qxdm","371083");
//        js.put("zsfj","");
//        js.put("zszt1",0);
//        js.put("zszt2",0);
//        js.put("zszt3",0);
//        js.put("isrestrict",true);
//        js.put("xzsm","");
//
//        JSONArray ja=new JSONArray();
//        ja.add(js);
//        js2.put("data",ja);
//        js2.put("code","200");
//        js2.put("msg","成功");
//
//        System.out.println("toJSONString="+js2.toJSONString());
//
//        ApiEncryptInfoDTO dto = new ApiEncryptInfoDTO();
//        dto.setData(js2.toJSONString());
//        dto = SM2Utils.encrypt2Data(dto);
//        System.out.println("dto.getDataHex()="+dto.getDataHex());
//
//        JSONObject jsonObject2 = JSONObject.parseObject(str);
//        jsonObject2.put("encryptParam",dto.getDataHex());
//        System.out.println(jsonObject2.toJSONString());
//        return jsonObject2.toJSONString();
//
//
//
//    }
//}
