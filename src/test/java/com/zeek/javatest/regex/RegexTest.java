package com.zeek.javatest.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName RegexTest
 * @Description:
 * @Author: liweibo
 * @Date: 2018/10/8 上午9:30
 * @Version: v1.0
 **/
public class RegexTest {

    @Test
    public void regexTest4() {
        String regExEn = "^192\\.168.*";

        String str = "292.168.1.1" ;

        Pattern pattern = Pattern.compile(regExEn);
        Matcher matcher = pattern.matcher(str);

        System.out.println(matcher.matches());
    }

    /**
     * @Description:
     * @Author: liweibo
     * @Date: 2018/10/8 上午9:31
     * @Version: v1.0
     *
     * @Return: void
     **/
    @Test
    public void regexTest3() {
        String regExEn = "^.*:$";
        String regExZh = "^.*：$" ;

        String str = "你好:" ;
        String str2 = "你好：" ;

        Pattern pattern = Pattern.compile(regExEn);
        Matcher matcher = pattern.matcher(str);

        System.out.println(matcher.matches());

        pattern = Pattern.compile(regExZh);
        matcher = pattern.matcher(str2);

        System.out.println(matcher.matches());
    }

    @Test
    public void regexTest2() {


        String str = "你好 :" ;
        String str2 = "你好 ：" ;

        System.out.println(str.lastIndexOf(" :"));
        System.out.println(str2.lastIndexOf(" ："));


    }

    @Test
    public void regexTest1() {
        String regExEn = "^.*\\s:$";
        String regExZh = "^.*\\s：$" ;

        String str = "你好 :" ;
        String str2 = "你好 ：" ;

        Pattern pattern = Pattern.compile(regExEn);
        Matcher matcher = pattern.matcher(str);

        System.out.println(matcher.matches());

        pattern = Pattern.compile(regExZh);
        matcher = pattern.matcher(str2);

        System.out.println(matcher.matches());
    }
}
