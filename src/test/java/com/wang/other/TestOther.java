package com.wang.other;

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

    @Test
    public void String2(){
        String s2 = "0101";
        System.out.println(Integer.parseInt(s2));
        System.out.println(Integer.parseInt(s2) + 1);
        System.out.println(String.format("%06d",Integer.parseInt(s2) + 1));
    }

    @Test
    public void String3(){
        String s1 = "pdms_dev".replace("pdms_", "");
        System.out.println(s1);
    }

    /**
     * @Desc 两个时间间隔
     * @Author Wang926454
     * @Date 2018/6/23 14:15
     */
    @Test
    public void Date(){
        String date1 = "2018-07-07";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = df.parse(date1);
            System.out.println(this.differentHoursByMillisecond(new Date(), date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1, Date date2) {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     * @param date1
     * @param date2
     * @return
     */
    public static int differentHoursByMillisecond(Date date1, Date date2) {
        int hour = (int) ((date2.getTime() - date1.getTime()) / (1000*3600));
        return hour;
    }

    /**
     * @Desc 逗号分割测试
     * @Author Wang926454
     * @Date 2018/7/4 13:34
     */
    @Test
    public void StringBuffer(){
        StringBuffer stringBuffer = new StringBuffer("34,55,88");
        System.out.println(stringBuffer.toString());

        StringBuffer strbuff = new StringBuffer();
        String no = "3411,5522,8833";
        strbuff.append(no);
        System.out.println(strbuff.toString());

        String[] strArray = convertStrToArray(no);
        for (String str:strArray) {
            System.out.println(str);
        }
        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);
        }
    }

    /**
     * @Desc 将字符串以逗号分割成数组
     * @Author Wang926454
     * @Date 2018/7/4 13:48
     */
    public static String[] convertStrToArray(String str){
        String[] strArray = null;
        strArray = str.split(","); //拆分字符为"," ,然后把结果交给数组strArray
        return strArray;
    }

    /**
     * TODO：格式化输出时间
     * @param 
     * @return void
     * @author Wang926454
     * @date 2018/8/25 18:10
     */
    @Test
    public void Date2(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(new Date()).toString());
    }

    @Test
    public void t3(){
        try{
            System.out.println("c");
            return;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }
        System.out.println("con");
    }

}
