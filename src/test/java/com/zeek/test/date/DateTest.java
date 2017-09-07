package com.zeek.test.date;

import com.zeek.test.domain.User;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by weibo_li on 2017/4/25.
 */
public class DateTest {

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
