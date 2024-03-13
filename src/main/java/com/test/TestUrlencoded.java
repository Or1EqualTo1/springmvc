package com.test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;


@RestController
public class TestUrlencoded {
    @RequestMapping("/rsbdc.do")
    public String testjk(String qlrmc, String qlrzjh) {
        System.out.println("dd=" + qlrmc + ";dk=" + qlrzjh);

        qlrmc = "宋英杰";
        qlrzjh = "371083197806250533";
        String s = testk2(qlrmc, qlrzjh);

        return "asd";
    }

    public String testk2(String qlrmc, String qlrzjh) {
        Integer count = null;
        Connection connection = null;
        PreparedStatement ps2 = null;
        ResultSet rs2 = null;
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.174.18:1521:orcl", "BDCDJ",
                    "KQ17331#0536");
        } catch (SQLException e2) {
            e2.printStackTrace();
        }

        String cx2 = "select count(*) count  from bdc_regn_fwsyq where slid in (select slid from bdc_qlrlb where bz='0' and qlrid in (select qlrid from bdc_qlr where qlrmc=? and zjhm =?))";
        try {
            ps2 = connection.prepareStatement(cx2);
            ps2.setString(1, qlrmc);
            ps2.setString(2, qlrzjh);

            rs2 = ps2.executeQuery();
            while (rs2.next()) {
                count = rs2.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps2 != null) {
                try {
                    ps2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs2 != null) {
                try {
                    rs2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return null;
    }

    public String testk3(String qlrmc2, String qlrzjh2, Integer count, Connection connection) {
        System.out.println("qlrmc2=" + qlrmc2 + ";qlrzjh2=" + qlrzjh2);
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        String bdcdyh;
        String bdcqzh;
        String zl;
        String ywh;
        String gyqk;
        String gyfs;
        String djlx;
        String qlxz;
        String ghyt;
        String jg;
        String jzmj;
        String tnjzmj;
        String sfdy;
        String sfcf;
        String ywr;
        String qlrmc;
        String qlrzjh;
        String djjg;
        String djrq;
        String zt;
        String bz;


        PreparedStatement ps3 = null;
        ResultSet rs3 = null;


        String cx3 = "select  ff.bdcdyh bdcdyh,  ff.bdcqzh bdcqzh,  ff.zl zl,  ff.ywh ywh,  ff.gyqk gyqk,  ff.gyfs gyfs,  ff.djlx djlx,  ff.qlxz qlxz,  ff.ghyt ghyt,  ff.jg jg,  ff.jzmj jzmj,  ff.tnjzmj tnjzmj,  ff.sfdy sfdy,  ff.sfcf sfcf,  q3.qlr2 ywr,  ff.qlrmc qlrmc,  ff.qlrzjh qlrzjh,  ff.djjg djjg,  ff.djrq djrq,  ff.zt zt,  ff.bz bz from (select distinct f.djkid ,f.bdcdyh bdcdyh,f.bdcqzh bdcqzh,f.fdzl zl,f.slid ywh,q2.qlbl gyqk,q2.gyfs gyfs,f.djlx djlx,f.qlxz qlxz,(select sd_value from oa2_sysdic where sd_class='19' and sd_keyno =f.ghyt  and sd_main !=0) ghyt,f.fwjg,f.fwjg jg,f.jzmj jzmj,f.zyjzmj tnjzmj, (SELECT DECODE(COUNT(1), 0, '0', '1') FROM bdc_regn_dy dy1 WHERE dy1.djbzt = 0  AND dy1.djkid = f.djkid)  sfdy, (SELECT DECODE(COUNT(1), 0, '0', '1')  FROM bdc_regn_cf cf1  WHERE cf1.djbzt = 0  AND cf1.djkid = f.djkid) sfcf,f.fwsuoyqlr qlrmc,f.qlrzjbh qlrzjh,f.djjg djjg,f.djsj djrq,f.djbzt+1 zt,f.djkid bz,rownum r from bdc_qlrlb q,bdc_regn_fwsyq f,bdc_qlr q2 where q2.qlrid=q.qlrid and  q.slid=f.slid and q.bz='0' and  q.qlrmc=? and q.zjhm=? ) ff left JOIN bdc_req q3 on q3.slid=ff.ywh  where ff.r=? order by ff.bdcdyh";

        try {

            ps3 = connection.prepareStatement(cx3);
            ps3.setString(1, qlrmc2);
            ps3.setString(2, qlrzjh2);
            ps3.setInt(3, count);
            rs3 = ps3.executeQuery();
            while (rs3.next()) {
                for (int i = 1; i <= count; i++) {

                    bdcdyh = rs3.getString("bdcdyh");
                    bdcqzh = rs3.getString("bdcqzh");
                    zl = rs3.getString("zl");
                    ywh = rs3.getString("ywh");
                    gyqk = rs3.getString("gyqk");
                    gyfs = rs3.getString("gyfs");
                    djlx = rs3.getString("djlx");
                    qlxz = rs3.getString("qlxz");
                    ghyt = rs3.getString("ghyt");
                    jg = rs3.getString("jg");
                    jzmj = rs3.getString("jzmj");
                    tnjzmj = rs3.getString("tnjzmj");
                    sfdy = rs3.getString("sfdy");
                    sfcf = rs3.getString("sfcf");
                    ywr = rs3.getString("ywr");
                    qlrmc = rs3.getString("qlrmc");
                    qlrzjh = rs3.getString("qlrzjh");
                    djjg = rs3.getString("djjg");
                    djrq = rs3.getString("djrq");
                    zt = rs3.getString("zt");
                    bz = rs3.getString("bz");


                    jsonObject.clear();

                    jsonObject.put("bdcdyh", bdcdyh);
                    jsonObject.put("bdcqzh", bdcqzh);
                    jsonObject.put("zl", zl);
                    jsonObject.put("ywh", ywh);
                    jsonObject.put("gyqk", gyqk);
                    jsonObject.put("gyfs", gyfs);
                    jsonObject.put("djlx", djlx);
                    jsonObject.put("qlxz", qlxz);
                    jsonObject.put("ghyt", ghyt);
                    jsonObject.put("jg", jg);
                    jsonObject.put("jzmj", jzmj);
                    jsonObject.put("tnjzmj", tnjzmj);
                    jsonObject.put("sfdy", sfdy);
                    jsonObject.put("sfcf", sfcf);
                    jsonObject.put("ywr", ywr);
                    jsonObject.put("qlrmc", qlrmc);
                    jsonObject.put("qlrzjh", qlrzjh);
                    jsonObject.put("djjg", djjg);
                    jsonObject.put("djrq", djrq);
                    jsonObject.put("zt", zt);
                    jsonObject.put("bz", bz);

                    jsonArray.add(jsonObject);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps3 != null) {
                try {
                    ps3.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs3 != null) {
                try {
                    rs3.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("jsonArray.toString()"+jsonArray.toString());

        return null;
    }
}
