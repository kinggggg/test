package com.zeek.javatest.url;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Test123
 * @Description
 * @Author liweibo
 * @Date 2019/3/22 2:32 PM
 * @Version v1.0
 **/
public class Test123 {

    public static void main(String[] args) {


        try {
            String name = "张三" ;
            name = URLEncoder.encode(name, "utf-8");
            System.out.println(name);
            name = URLDecoder.decode(name, "utf-8");
            System.out.println(name);



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        String str = "触发黑名单，触发的key为<br>tb:263:446:1523:李四<br>tb:263:446:1522:18<br>" ;
        String[] split = str.split("<br>");
        System.out.println("=====");

        Long aLong = dateDiff(new Date(), "2019-01-01 00:00:00");
        System.out.println(aLong);


    }

    public static Long dateDiff(Date startTime, String endTime) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d1 = df.parse(endTime);
            Date d2 = startTime;
            long diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
            /*long days = diff / (1000 * 60 * 60 * 24);

            long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
            long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);*/
            return diff;
        } catch (Exception e) {
        }
        return null;
    }
}
