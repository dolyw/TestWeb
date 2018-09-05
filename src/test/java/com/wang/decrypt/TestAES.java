package com.wang.decrypt;

import com.wang.util.encryp.EncrypAESUtil;
import org.junit.jupiter.api.Test;

/**
 * TODO：AES测试
 * @author Wang926454
 * @date 2018/8/31 9:51
 */
public class TestAES {

    /**
     * TODO：以帐号加密码的方式加密，可以减少加密后重复
     * @param 
     * @return void
     * @author Wang926454
     * @date 2018/8/31 17:40
     */
    @Test
    public void Test01() throws Exception {
        System.out.println((EncrypAESUtil.Encrytor("wang" + "wang926454")));
    }

    /**
     * TODO：解密
     * @param 
     * @return void
     * @author Wang926454
     * @date 2018/8/31 17:40
     */
    @Test
    public void Test02() throws Exception {
        System.out.println(EncrypAESUtil.Decryptor("MkI1NDJENEI5NEQ0MjFGQUQ5N0RBMEE3ODM1NUNBQTQ="));
    }
}
