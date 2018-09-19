package com.zeek.calendar;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName CalendarTest
 * @Description TODO
 * @Author weibo_li
 * @Date 2018/9/19 上午9:52
 **/
public class CalendarTest {

    @Test
    public void test01() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");


        Date date = new Date();
        System.out.println("当前的时间为：" + sdf.format(date));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.MINUTE, -1);
        System.out.println("减去1分钟的时间后: " + sdf.format(calendar.getTime()));

        calendar.add(Calendar.HOUR, 1);
        System.out.println("增加1小时的时间后: " + sdf.format(calendar.getTime()));

        //若增加24小时，日期也自动变化了，非常好
        calendar.add(Calendar.HOUR, 24);
        System.out.println("增加24小时的时间后: " + sdf.format(calendar.getTime()));
    }
}
