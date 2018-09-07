package com.wang.other;

import com.wang.model.Item;
import com.wang.util.JedisUtil;
import com.wang.util.common.JsonConvertUtil;
import com.wang.util.common.RandomUtil;
import com.wang.util.common.StringUtil;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Desc 其他测试
 * @Author wang926454
 * @Date 2018/6/19 15:33
 */
public class TestUtil {

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

    @Test
    public void String3(){
        Map<String, Object> map = new HashMap<String, Object>(16);
        map.put("code", "012121");
        map.put("status", 1);
        map.put("data", new Item(1, "wang"));
        String mapJson = JsonConvertUtil.objectToJson(map);
        System.out.println(mapJson);
        JedisUtil.setJson("item22", mapJson, JedisUtil.EXRP_MINUTE);
        Map<String, Object> map2 = JsonConvertUtil.jsonToObject(JedisUtil.getJson("item22"), Map.class);
        System.out.println(map2);
    }

    @Test
    public void String4(){
        List<Item> itemList = new ArrayList<Item>();
        itemList.add(new Item(1, "wang"));
        String listJson = JsonConvertUtil.objectToJson(itemList);
        System.out.println(listJson);
        JedisUtil.setJson("item33", listJson, JedisUtil.EXRP_MINUTE);
        List<Item> itemList2 = JsonConvertUtil.jsonToObject(JedisUtil.getJson("item33"), List.class);
        System.out.println(itemList2);
        System.out.println(itemList2.size());
    }

}
