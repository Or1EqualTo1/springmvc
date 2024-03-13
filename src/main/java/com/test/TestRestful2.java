//package com.test;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.bw.ApiEncryptInfoDTO;
//import com.bw.SM2Utils;
//import com.dao.User1;
//import com.dao.User2;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class TestRestful2 {
////    @RequestMapping("/ree/app/api/kq2/{str}")
//    public String test4(@PathVariable("str") String str) {
//
//        System.out.println(str);
//        JSONObject js = new JSONObject();
//        JSONObject js2 = new JSONObject();
//
////        ApplicationContext context = new ClassPathXmlApplicationContext("springm.xml");
////        Asd asd = (Asd) context.getBean("asd");
////        asd.asd();
////        js.put("str2", "str22");
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
//        User2 u2 = new User2();
//
//
//        JSONObject jsonObject1 = JSONObject.parseObject(dto2.getData());
//        Object qydm = jsonObject1.get("qydm");
//        u2.setQydm(qydm.toString());
//        Object qlbsms = jsonObject1.get("qlbsms");
//        u2.setQlbsms(qlbsms.toString());
//        Object timestamp = jsonObject1.get("timestamp");
//        u2.setTimestamp((long) timestamp);
//        System.out.println("u2=" + u2.toString());
//
//        js.put("qlrlb", "个人");
//        js.put("qlrmc", "江兵");
//        js.put("zjzl", "身份证");
//        js.put("zjh", "370703199205241513");
//        js.put("qlrlx", "个人");
//        js.put("gyfs", "单独所有");
//
//
//        JSONArray ja = new JSONArray();
//        ja.add(js);
//        js2.put("data", ja);
//        js2.put("code", "200");
//        js2.put("msg", "成功");
//
//        System.out.println("toJSONString=" + js2.toJSONString());
//
//        ApiEncryptInfoDTO dto = new ApiEncryptInfoDTO();
//        dto.setData(js2.toJSONString());
//        dto = SM2Utils.encrypt2Data(dto);
//        System.out.println("dto.getDataHex()=" + dto.getDataHex());
//
//        JSONObject jsonObject2 = JSONObject.parseObject(str);
//        jsonObject2.put("encryptParam", dto.getDataHex());
//        System.out.println("jsonObject2.toJSONString()="+jsonObject2.toJSONString());
//        return jsonObject2.toJSONString();
//    }
//}
