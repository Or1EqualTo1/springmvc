
package com.bw;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiEncryptInfoDTO implements Serializable {

    private static final long serialVersionUID = 255205006827117733L;

    /**
     * 加密类型（2:sm2加密，4:sm4加密）
     */
    private String type;

    /**
     * 非对称加密私钥
     */
    private String privateKey;

    /**
     * 非对称加密公钥
     */
    private String publicKey;

    /**
     * 对称加密密钥
     */
    private String key;

    /**
     * 原始数据
     */
    private String data;

    /**
     * 加密后数据
     */
    private String dataHex;

    /**
     * 非对称加密签名
     */
    private String sign;

    @Override
    public String toString() {
        return "ApiEncryptInfoDTO{" +
                "type='" + type + '\'' +
                ", privateKey='" + privateKey + '\'' +
                ", publicKey='" + publicKey + '\'' +
                ", key='" + key + '\'' +
                ", data='" + data + '\'' +
                ", dataHex='" + dataHex + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDataHex() {
        return dataHex;
    }

    public void setDataHex(String dataHex) {
        this.dataHex = dataHex;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public ApiEncryptInfoDTO() {
    }

    public ApiEncryptInfoDTO(String type, String privateKey, String publicKey, String key, String data, String dataHex, String sign) {
        this.type = type;
        this.privateKey = privateKey;
        this.publicKey = publicKey;
        this.key = key;
        this.data = data;
        this.dataHex = dataHex;
        this.sign = sign;
    }
}