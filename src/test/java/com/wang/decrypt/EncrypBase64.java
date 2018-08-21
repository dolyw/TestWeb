package com.wang.decrypt;

import java.util.Base64;

/**
 * TODO：Base64
 * @author Wang926454
 * @date 2018/8/21 15:14
 */
public class EncrypBase64 {

    /**
     * TODO：加密
     * @param src
     * @return java.lang.String
     * @author Wang926454
     * @date 2018/8/21 15:28
     */
    public static String encode(String src) throws Exception {
        byte[] encodeBytes = Base64.getEncoder().encode(src.getBytes());
        return new String(encodeBytes);
    }

    /**
     * TODO：解密
     * @param src
     * @return java.lang.String
     * @author Wang926454
     * @date 2018/8/21 15:28
     */
    public static String decode(String src) throws Exception {
        byte[] decodeBytes = Base64.getDecoder().decode(src.getBytes());
        return new String(decodeBytes);
    }
    
    /**
     * TODO：测试
     * @param args
     * @return void
     * @author Wang926454
     * @date 2018/8/21 15:16
     */
    public static void main(String[] args) throws Exception {
        EncrypBase64 de1 = new EncrypBase64();
        String msg ="dhdslkaflkf";
        String encodeMsg = EncrypBase64.encode(msg);
        System.out.println("明文是:" + msg);
        System.out.println("加密后:" + encodeMsg);
        System.out.println("解密后:" + EncrypBase64.decode(encodeMsg));
    }

}
