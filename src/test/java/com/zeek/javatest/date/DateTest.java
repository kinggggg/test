package com.zeek.javatest.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by weibo_li on 2017/4/25.
 */
public class DateTest {

    @Test
    public void test4() {

        System.out.println(LocalDateTime.now());

    }

    @Test
    public void test3() {
        System.out.println(System.currentTimeMillis());
        System.out.println(this.parseTimeStamp2DateString(System.currentTimeMillis()));
    }

    public String parseTimeStamp2DateString(long timeStamp) {
        SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        String result;
        try {
            result = format.format(timeStamp);
        } catch (Exception e) {
            return "" ;
        }

        return result;
    }

    @Test
    public void test2() {

        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void test1() {

        Date date1 = new Date();
        Date date2 = new Date();



        System.out.println(date1 == date2);
    }
}
