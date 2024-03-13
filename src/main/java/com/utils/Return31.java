package com.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bw.ApiEncryptInfoDTO;
import com.bw.SM2Utils;
import com.dao.User1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

public class Return31 {
    private String qydm;
    private String qlr;
    private String zjh;
    public static PreparedStatement ps = null;
    public static ResultSet rs = null;
    public String dataHex = "";
    JSONObject js = new JSONObject();
    JSONObject js2 = new JSONObject();
    JSONArray ja = new JSONArray();


    public JSONObject Return31(User1 user) {
        this.qydm = user.getQydm();
        this.qlr = user.getQlr();
        this.zjh = user.getZjh();
        Connection connection = new DbLink().dbLink();
        String cx31 = "select f.fwsuoyqlr qlr,f.qlrzjbh zjh,f.bdcdyh,f.bdcqzh,f.qlxz,f.qllx,f.fwxz,(select sd_value from oa2_sysdic where sd_class='16' and sd_keyno = f.fwxz and sd_main !=0) fwxzmc,f.fdzl zl,f.jzmj,h.fwyt1 yt,(select sd_value from oa2_sysdic where sd_class='19' and sd_keyno =h.fwyt1  and sd_main !=0) ytmc,(select gyfs from bdc_qlr where  qlrid = l.qlrid  and rownum='1') gyfs,h.fwjg jzjg,h.fwlx jzlx,h.hx hx,h.hxjg,trim(f.slid) qlbsm,substr(f.jgsj,1,4) jznd,(select xmmc from bdc_xm where xmid in (select xmid from bdc_h where fwid=h.fwid and rownum='1') and rownum='1') xqmc,h.sjc lc,h.zzlc zc,f.djsj fzsj,f.qxdm ,f.fj zsfj,(SELECT DECODE(COUNT(1), 0, 0, 1) FROM bdc_regn_dy dy1 WHERE dy1.djbzt = 0  AND dy1.djkid = f.djkid)  zszt1,(SELECT DECODE(COUNT(1), 0, 0, 1) FROM bdc_regn_cf cf1 WHERE cf1.djbzt = 0  AND cf1.djkid = f.djkid)  zszt2,(SELECT DECODE(COUNT(1), 0, 0, 1) FROM bdc_regn_yy yy1 WHERE yy1.djbzt = 0  AND yy1.djkid = f.djkid)  zszt3 from bdc_qlrlb l,bdc_regn_fwsyq f,bdc_h h where h.fwid=f.djkid and f.slid=l.slid and l.bz='0' and  l.qlrmc=? and l.zjhm= ? and f.qxdm=? and rownum='1'";
        try {
            ps = connection.prepareStatement(cx31);
            ps.setString(1, qlr);
            ps.setString(2, zjh);
            ps.setString(3, qydm);

            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("bdcdyh"));

                js.put("qlr", rs.getString("qlr"));
                js.put("zjh", rs.getString("zjh"));
                js.put("bdcdyh", rs.getString("bdcdyh"));
                js.put("bdcqzh", rs.getString("bdcqzh"));
                js.put("qlxz", rs.getString("qlxz"));
                js.put("qllx", rs.getString("qllx"));
                js.put("fwxz", rs.getString("fwxz"));
                js.put("fwxzmc", rs.getString("fwxzmc"));
                js.put("zl", rs.getString("zl"));
                js.put("jzmj", rs.getFloat("jzmj"));
                js.put("yt", rs.getString("yt"));
                js.put("ytmc", rs.getString("ytmc"));
                js.put("gyfs", rs.getString("gyfs"));
                js.put("jzjg", rs.getString("jzjg"));
                js.put("jzlx", rs.getString("jzlx"));
                js.put("hx", rs.getString("hx"));
                js.put("hxjg", rs.getString("hxjg"));
                js.put("qlbsm", rs.getLong("qlbsm"));
                js.put("jznd", rs.getString("jznd"));
                js.put("xqmc", rs.getString("xqmc"));
                js.put("lc", rs.getLong("lc"));
                js.put("zc", rs.getLong("zc"));
                js.put("fzsj", rs.getString("fzsj"));
                js.put("qxdm", rs.getString("qxdm"));
                js.put("zsfj", rs.getString("zsfj"));
                js.put("zszt1", rs.getInt("zszt1"));
                js.put("zszt2", rs.getInt("zszt2"));
                js.put("zszt3", rs.getInt("zszt3"));
                if (rs.getInt("zszt1") + rs.getInt("zszt2") + rs.getInt("zszt3") >= 1) {
                    js.put("isrestrict", true);
                    js.put("xzsm", "该房源具备发布条件");
                } else {
                    js.put("isrestrict", false);
                    js.put("xzsm", "该房源处于限制中，暂不具备发布条件。");
                }
                System.out.println("js.toJSONString()="+js.toJSONString());
                ApiEncryptInfoDTO dto = new ApiEncryptInfoDTO();
                dto.setData(js.toJSONString());
                dto = SM2Utils.encrypt2Data(dto);
                dataHex = dto.getDataHex();


                ja.add(dataHex);
                js2.put("data", Collections.singletonList(dataHex).toString());
                js2.put("code", "200");
                js2.put("msg", "操作成功");
            }else {
                ja.add(dataHex);
                js2.put("data", Collections.singletonList(dataHex).toString());
                js2.put("code", "200");
                js2.put("msg", "操作成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("dataHex="+dataHex);
        return js2;
    }
}
