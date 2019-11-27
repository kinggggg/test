package com.zeek.interview;

import org.junit.Test;

/**
 * @ClassName InterviewTest
 * @Description
 * @Author liweibo
 * @Date 2019/11/26 9:34 AM
 * @Version v1.0
 **/
public class InterviewTest {

    @Test
    public void switchTest() {

        // switch不支持long类型
//        long l = 99;
//        switch (l) {
//            case 10:
//                break;
//        }



    }

    @Test
    public void autoBoxTest() {

        // 可以直接定义short
        short s = 1;
        // 当+1时，JVM首先会将s转换成int然后+1，此时的结果为int，int的精度比short精度高，不能将int直接赋值给short
//        s = s + 1;

        // 但是可以通过下面的方式赋值
        s++;
        s += 1;
        System.out.println(s);
    }


    @Test
    public void stringPoolTest() {

        String str1 = "abc";
        String str2 = "abc";

        System.out.println(str1 == str2);

        String str3 = new String("def");
        String str4 = new String("def");
        System.out.println(str3 == str4);

    }
}
