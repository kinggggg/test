package com.zeek.test.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by weibo_li on 2017/3/22.
 */
public class RegexTest {

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
