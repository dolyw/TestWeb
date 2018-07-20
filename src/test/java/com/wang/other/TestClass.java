package com.wang.other;

import com.wang.model.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Desc 对象测试
 * @Author wang926454
 * @Date 2018/6/19 15:33
 */
public class TestClass {

    @Test
    public void Class(){
        User user = new User();
        List list = this.getFiledsInfo(user);
        System.out.println(list);
    }

    /**
     * 根据属性名获取属性值
     * */
    private Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
            //log.error(e.getMessage(),e);
            return null;
        }
    }

    /**
     * 获取属性名数组
     * */
    private String[] getFiledName(Object o){
        Field[] fields=o.getClass().getDeclaredFields();
        String[] fieldNames=new String[fields.length];
        for(int i=0;i<fields.length;i++){
            System.out.println(fields[i].getType());
            fieldNames[i]=fields[i].getName();
        }
        return fieldNames;
    }

    /**
     * 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list
     * 无法获取继承类的私有属性
     * */
    private List getFiledsInfo(Object o){
        Field[] fields=o.getClass().getDeclaredFields();
        String[] fieldNames=new String[fields.length];
        List list = new ArrayList();
        Map infoMap=null;
        for(int i=0;i<fields.length;i++){
            if(fields[i].getName().equals("serialVersionUID")){
                continue;
            }
            infoMap = new HashMap();
            infoMap.put("type", fields[i].getType().toString());
            infoMap.put("name", fields[i].getName());
            infoMap.put("value", getFieldValueByName(fields[i].getName(), o));
            list.add(infoMap);
        }
        return list;
    }

    /**
     * 获取对象的所有属性值，返回一个对象数组
     * */
    public Object[] getFiledValues(Object o){
        String[] fieldNames=this.getFiledName(o);
        Object[] value=new Object[fieldNames.length];
        for(int i=0;i<fieldNames.length;i++){
            value[i]=this.getFieldValueByName(fieldNames[i], o);
        }
        return value;
    }
}
