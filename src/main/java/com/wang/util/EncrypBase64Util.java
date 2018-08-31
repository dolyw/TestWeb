package com.wang.util;

import java.util.Base64;

/**
 * TODO：Base64
 * @author Wang926454
 * @date 2018/8/21 15:14
 */
public class EncrypBase64Util {

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

}
