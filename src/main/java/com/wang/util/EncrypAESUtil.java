package com.wang.util;

import jdk.nashorn.internal.runtime.ECMAException;

import javax.crypto.*;
import java.security.SecureRandom;
import java.security.Security;

/**
 * TODO：AES加密解密工具类
 * @author Wang926454
 * @date 2018/8/31 16:39
 */
public class EncrypAESUtil {

    /**
     * 私钥
     */
    // private static final byte[] KEY = { 1, 1, 33, 82, -32, -85, -128, -65 };

    /**
     * TODO：加密
     * @param str
     * @return java.lang.String
     * @author Wang926454
     * @date 2018/8/31 16:56
     */
    public static String Encrytor(String str) throws Exception {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        // 实例化支持AES算法的密钥生成器(算法名称命名需按规定，否则抛出异常)
        // KeyGenerator 提供对称密钥生成器的功能，支持各种算法
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        // 获取私钥
        PropertiesUtil.readProperties("config.properties");
        String key = EncrypBase64Util.decode(PropertiesUtil.getProperty("encrypAESKey"));
        keygen.init(128, new SecureRandom(new String("key").getBytes()));
        // SecretKey 负责保存对称密钥 生成密钥
        SecretKey deskey = keygen.generateKey();
        // 生成Cipher对象,指定其支持的AES算法，Cipher负责完成加密或解密工作
        Cipher c = Cipher.getInstance("AES");
        // 根据密钥，对Cipher对象进行初始化，ENCRYPT_MODE表示加密模式
        c.init(Cipher.ENCRYPT_MODE, deskey);
        byte[] src = str.getBytes();
        // 该字节数组负责保存加密的结果
        byte[] cipherByte = c.doFinal(src);
        // 先将二进制转换成16进制，再返回Bsae64加密后的String
        return EncrypBase64Util.encode(HexConvertUtil.parseByte2HexStr(cipherByte));
    }

    /**
     * TODO：解密
     * @param str
     * @return java.lang.String
     * @author Wang926454
     * @date 2018/8/31 16:56
     */
    public static String Decryptor(String str) throws Exception {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        // 实例化支持AES算法的密钥生成器(算法名称命名需按规定，否则抛出异常)
        // KeyGenerator 提供对称密钥生成器的功能，支持各种算法
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        // 获取私钥
        PropertiesUtil.readProperties("config.properties");
        String key = EncrypBase64Util.decode(PropertiesUtil.getProperty("encrypAESKey"));
        keygen.init(128, new SecureRandom(new String("key").getBytes()));
        // SecretKey 负责保存对称密钥 生成密钥
        SecretKey deskey = keygen.generateKey();
        // 生成Cipher对象,指定其支持的AES算法，Cipher负责完成加密或解密工作
        Cipher c = Cipher.getInstance("AES");
        // 根据密钥，对Cipher对象进行初始化，DECRYPT_MODE表示解密模式
        c.init(Cipher.DECRYPT_MODE, deskey);
        // 该字节数组负责保存加密的结果，先对str进行Bsae64解密，将16进制转换为二进制
        byte[] cipherByte = c.doFinal(HexConvertUtil.parseHexStr2Byte(EncrypBase64Util.decode(str)));
        return new String(cipherByte);
    }
}
