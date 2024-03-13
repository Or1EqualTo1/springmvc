package com.bw;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {

    /**
     * 测试SM2加密
     */

    public void test01() {
        ApiEncryptInfoDTO dto = new ApiEncryptInfoDTO();
        JSONObject obj = new JSONObject();
        obj.put("user", "admin");
        obj.put("pass", "admin");

        dto.setData(obj.toJSONString());
        dto.setPublicKey("0460b1b8b3d8932885260cefdb133610c3b179ffa9f326800712e4073f4b068c628c608648f65495e27f7f9047537f3945ea87532cd638246d24a960591f1a3384");
        dto = SM2Utils.encrypt2Data(dto);
        System.out.println(dto.getDataHex());
    }

    /**
     * 测试SM2解密
     */
//    @Test
    @RequestMapping("/jem.do")
    public void test02() {
        ApiEncryptInfoDTO dto = new ApiEncryptInfoDTO();
        dto.setDataHex("046A331A8227AD1CCC7E33ECEAEF7CF1CD7D3F3EEE2218E4A0AD1BE08ED5E65F0DB6811656FAE4CD1A16D8E79DE66FCF80A08158CD7E34523E76975789B18AE2C9FF9012BD47E0F84BC778538D6A6C17304A83F2F57014EC0C257987D8DA93403D53F193234DB8");
        dto = SM2Utils.decrypt2Data(dto);
        System.out.println(dto.getData());
    }

    /**
     * 生成一对 C1C2C3 格式的SM2密钥
     */
//    @Test
    @RequestMapping("/my.do")
    public void test03() {
        ApiEncryptInfoDTO dto = SM2Utils.getSM2Key();
        System.out.println(dto.getPublicKey());
        System.out.println(dto.getPrivateKey());
    }

    /**
     * 获取一个随机的SM4密钥
     */
    @Test
    public void test04() {
        ApiEncryptInfoDTO dto = SM2Utils.getSM4Key();
        System.out.println(dto.getKey());
    }

    /**
     * 测试SM4加密
     */
    @Test
    public void test05() {
        ApiEncryptInfoDTO dto = new ApiEncryptInfoDTO();
        dto.setData("123456");
        dto = SM2Utils.encrypt4Data(dto);
        System.out.println(dto.getDataHex());
    }

    /**
     * 测试SM4解密
     */
    @Test
    public void test06() {
        ApiEncryptInfoDTO dto = new ApiEncryptInfoDTO();
        dto.setDataHex("0c878839ddba1631931ca9e7f9c981eb");
        dto = SM2Utils.decrypt4Data(dto);
        System.out.println(dto.getData());
    }


    public void jiemi(String canshu) {
        ApiEncryptInfoDTO dto = new ApiEncryptInfoDTO();
        dto.setDataHex(canshu);
        dto.setPrivateKey("6cc1ce63c885781e971883473c5f59f9c931016ca534ffb570e99cfc3363a45e");
        dto = SM2Utils.decrypt2Data(dto);
        System.out.println("dto.getData()="+dto.getData());
    }


    public static void main(String[] args) {

    }
}