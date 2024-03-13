package com.bw;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.BCUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.utils.PropertiesParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.bouncycastle.crypto.engines.SM2Engine;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;

@Slf4j
public class SM2Utils {

    /**
     * SM2加密
     *
     * @param dto 包含加解密相关参数信息的实体
     * @return 处理结果
     */
    public static ApiEncryptInfoDTO encrypt2Data(ApiEncryptInfoDTO dto){
        String publicKey = dto.getPublicKey();
        // 若为空，使用默认
//        System.out.println("publicKey="+publicKey);
        if (StringUtils.isBlank(publicKey)) {
            publicKey = new PropertiesParam().getPublicKey();
        }
        String data = dto.getData();
        //创建sm2 对象
        SM2 sm2 = getSM2(null, publicKey);
        String dataHex = sm2.encryptBcd(data, KeyType.PublicKey);
        dto.setDataHex(dataHex);
        return dto;
    }

    /**
     * SM2解密
     * @param dto 包含加解密相关参数信息的实体
     * @return 处理结果
     */
    public static ApiEncryptInfoDTO decrypt2Data(ApiEncryptInfoDTO dto){
        String privateKey = dto.getPrivateKey();
        // 若为空，使用默认
//        if (StringUtils.isBlank(privateKey)) {
//            privateKey = new PropertiesParam().getPrivateKey();
//        }
        privateKey="00E22D624CF41102A60CF9FF7CE6F89A45863F562755CA792CDBCF90ED6955573A";
        String dataHex = dto.getDataHex();
        try {
            //创建sm2 对象
            SM2 sm2 = getSM2(privateKey, null);
            String data = StrUtil.utf8Str(sm2.decryptFromBcd(dataHex, KeyType.PrivateKey));
            dto.setData(data);
        } catch (Exception e) {
            System.out.println("SM2解密失败");
        }
        return dto;
    }

    /**
     * SM4加密
     *
     * @param dto 包含加解密相关参数信息的实体
     * @return 处理结果
     */
    public static ApiEncryptInfoDTO encrypt4Data(ApiEncryptInfoDTO dto) {
        //指定的密钥
        String key = dto.getKey();
        // 若为空，使用默认
        if (StringUtils.isBlank(key)) {
            key = "zps9yv341b3s90c2";
        }
        String data = dto.getData();
        try {
            SymmetricCrypto sm4 = SmUtil.sm4(key.getBytes(CharsetUtil.CHARSET_UTF_8));
            String dataHex = sm4.encryptHex(data);
            dto.setDataHex(dataHex);
        } catch (Exception e) {
            System.out.println("加密数据异常，异常数据：" + data);
        }
        return dto;
    }

    /**
     * SM4解密
     *
     * @param dto 包含加解密相关参数信息的实体
     * @return 处理结果
     */
    public static ApiEncryptInfoDTO decrypt4Data(ApiEncryptInfoDTO dto) {
        //指定的密钥
        String key = dto.getKey();
        // 若为空，使用默认
        if (StringUtils.isBlank(key)) {
            key = "zps9yv341b3s90c2";
        }
        String dataHex = dto.getDataHex();
        try {
            SymmetricCrypto sm4 = SmUtil.sm4(key.getBytes(CharsetUtil.CHARSET_UTF_8));
            String data = sm4.decryptStr(dataHex);
            dto.setData(data);
        } catch (Exception e) {
            System.out.println("解密数据异常，异常数据：" + dataHex);
        }
        return dto;
    }

    /**
     * 获取SM2加密工具对象
     *
     * @param privateKey 加密私钥
     * @param publicKey  加密公钥
     * @return 处理结果
     */
    private static SM2 getSM2(String privateKey, String publicKey) {
        ECPrivateKeyParameters ecPrivateKeyParameters = null;
        ECPublicKeyParameters ecPublicKeyParameters = null;
        if (StringUtils.isNotBlank(privateKey)) {
            ecPrivateKeyParameters = BCUtil.toSm2Params(privateKey);
        }
        if (StringUtils.isNotBlank(publicKey)) {
            if (publicKey.length() == 130) {
                //这里需要去掉开始第一个字节 第一个字节表示标记
                publicKey = publicKey.substring(2);
            }
            String xhex = publicKey.substring(0, 64);
            String yhex = publicKey.substring(64, 128);
            ecPublicKeyParameters = BCUtil.toSm2Params(xhex, yhex);
        }
        //创建sm2 对象
        SM2 sm2 = new SM2(ecPrivateKeyParameters, ecPublicKeyParameters);
        sm2.usePlainEncoding();
        sm2.setMode(SM2Engine.Mode.C1C2C3);
        return sm2;
    }

    /**
     * 生成一对 C1C2C3 格式的SM2密钥
     *
     * @return 处理结果
     */
    public static ApiEncryptInfoDTO getSM2Key() {
        ApiEncryptInfoDTO dto = new ApiEncryptInfoDTO();
        //创建sm2 对象
        SM2 sm2 = SmUtil.sm2();
        byte[] privateKeyByte = BCUtil.encodeECPrivateKey(sm2.getPrivateKey());
        //这里公钥不压缩  公钥的第一个字节用于表示是否压缩  可以不要
        byte[] publicKeyByte = ((BCECPublicKey) sm2.getPublicKey()).getQ().getEncoded(false);
        try {
            String privateKey = HexUtil.encodeHexStr(privateKeyByte);
            String publicKey = HexUtil.encodeHexStr(publicKeyByte);
            dto.setPublicKey(publicKey);
            dto.setPrivateKey(privateKey);
        } catch (Exception e) {
            System.out.println("获取SM2密钥出错");
        }
        return dto;
    }

    /**
     * 获取一个随机的SM4密钥
     *
     * @return 处理结果
     */
    public static ApiEncryptInfoDTO getSM4Key() {
        String sm4Key = RandomUtil.randomString(RandomUtil.BASE_CHAR_NUMBER, 16);
        ApiEncryptInfoDTO dto = new ApiEncryptInfoDTO();
        dto.setKey(sm4Key);
        return dto;
    }
}