package com.wang.other;

import com.wang.util.RandomUtil;
import com.wang.util.StringUtil;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc 其他测试
 * @Author wang926454
 * @Date 2018/6/19 15:33
 */
public class TestStringUtil {

    @Test
    public void String(){
        String s2 = "dsa_dsad_dd";
        System.out.println(StringUtil.addSingleQuotes(s2));
        System.out.println(StringUtil.underlineToCamel(s2));
        System.out.println(StringUtil.camelToUnderline(StringUtil.underlineToCamel(s2)));
    }

    @Test
    public void String2(){
        System.out.println(RandomUtil.getCode());
        System.out.println(RandomUtil.getName());
        System.out.println(RandomUtil.getRandom());
        System.out.println(RandomUtil.getUUID());
    }

}
