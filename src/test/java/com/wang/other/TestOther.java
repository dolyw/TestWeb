package com.wang.other;

import org.junit.jupiter.api.Test;

/**
 * @Desc 其他测试
 * @Author wang926454
 * @Date 2018/6/19 15:33
 */
public class TestOther {

    @Test
    public void String(){
        // 格式化输出
        int i = 1;
        System.out.println(String.format("%02d",i));

        //测试01相加
        String s = "01";
        System.out.println(Integer.parseInt(s));
        System.out.println(Integer.parseInt(s) + 1);
        System.out.println(String.format("%02d",Integer.parseInt(s) + 1));

        //测试15相加
        String s2 = "15";
        System.out.println(Integer.parseInt(s2));
        System.out.println(Integer.parseInt(s2) + 1);
        System.out.println(String.format("%02d",Integer.parseInt(s2) + 1));
    }
}
