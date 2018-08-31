package com.wang.decrypt;

import java.util.Base64;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

/**
 * TODO：Base64
 * @author Wang926454
 * @date 2018/8/21 15:14
 */
public class EncrypBase64 {

    /**
     * TODO：加密JDK1.8
     * @param str
     * @return java.lang.String
     * @author Wang926454
     * @date 2018/8/21 15:28
     */
    public static String encode(String str) throws Exception {
        byte[] encodeBytes = Base64.getEncoder().encode(str.getBytes("utf-8"));
        return new String(encodeBytes);
    }

    /**
     * TODO：解密JDK1.8
     * @param str
     * @return java.lang.String
     * @author Wang926454
     * @date 2018/8/21 15:28
     */
    public static String decode(String str) throws Exception {
        byte[] decodeBytes = Base64.getDecoder().decode(str.getBytes("utf-8"));
        return new String(decodeBytes);
    }

    /**
     * TODO：加密JDK1.7
     * @param str
     * @return java.lang.String
     * @author Wang926454
     * @date 2018/8/21 15:28
     */
    public static String encode7(String str) throws Exception {
        return new BASE64Encoder().encode(str.getBytes("utf-8"));
    }

    /**
     * TODO：解密JDK1.7
     * @param str
     * @return java.lang.String
     * @author Wang926454
     * @date 2018/8/21 15:28
     */
    public static String decode7(String str) throws Exception {
        byte[] b = new BASE64Decoder().decodeBuffer(str);
        return new String(b,"utf-8");
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
        String msg ="Wang926454dSBAPIJWT";
        String encodeMsg7 = EncrypBase64.encode7(msg);
        System.out.println("JDK1.7明文是:" + msg);
        System.out.println("JDK1.7加密后:" + encodeMsg7);
        System.out.println("解密后:" + EncrypBase64.decode7("UGRtc1VwbG9hZEZpbGUyMDE4MDgyM1dsaWR1bw=="));
        String encodeMsg = EncrypBase64.encode(msg);
        System.out.println("JDK1.8明文是:" + msg);
        System.out.println("JDK1.8加密后:" + encodeMsg);
        System.out.println("解密后:" + EncrypBase64.decode("UGRtc1VwbG9hZEZpbGUyMDE4MDgyM1dsaWR1bw=="));
    }

}
