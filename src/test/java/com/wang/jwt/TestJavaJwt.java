package com.wang.jwt;

import com.wang.util.JWTUtil;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO：Java-Jwt
 * @author Wang926454
 * @date 2018/8/31 9:08
 */
public class TestJavaJwt {

    /**
     * Redis中存的随机UUID
     */
    private static final String SECRETUUID = "gd3f24f3";

    /**
     * Token临时保存
     */
    private static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1MzU2OTYxMDAsInVzZXJuYW1lIjoid2FuZyJ9.Eia9Cn8ZIrm2B1ZiFRHiBYDg7xwkEUW87u9BMuBLMe4";

    /**
     * TODO：加密获取Token
     * @param
     * @return void
     * @author Wang926454
     * @date 2018/8/31 9:13
     */
    @Test
    public void Test01(){
        String token = JWTUtil.sign("wang", "wang926454" + SECRETUUID);
        System.out.println(token);
    }

    /**
     * TODO：获取用户名
     * @param
     * @return void
     * @author Wang926454
     * @date 2018/8/31 9:13
     */
    @Test
    public void Test02(){
        String username = JWTUtil.getUsername(TOKEN);
        System.out.println(username);
    }

    /**
     * TODO：认证Token
     * @param
     * @return void
     * @author Wang926454
     * @date 2018/8/31 9:13
     */
    @Test
    public void Test03(){
        boolean flag = JWTUtil.verify(TOKEN, "wang926454" + SECRETUUID);
        System.out.println(flag);
    }

}
