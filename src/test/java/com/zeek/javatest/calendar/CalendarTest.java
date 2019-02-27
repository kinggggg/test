package com.zeek.javatest.calendar;

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
    public void test01() throws Exception {

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

    @Test
    public void test02() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.HOUR_OF_DAY, cale.get(Calendar.HOUR_OF_DAY) - 1);
        String nowTime = sdf.format(cale.getTime());
        System.out.println(nowTime);

    }

    public static Date getFormerHour() throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cale = null;
        cale = Calendar.getInstance();
        int year = cale.get(Calendar.YEAR);
        int month = cale.get(Calendar.MONTH) + 1;
        int day = cale.get(Calendar.DATE);
        int hour = cale.get(Calendar.HOUR_OF_DAY)-1;
        return format.parse(year+"-"+month+"-"+day+" "+hour+":00:00");
    }
}
