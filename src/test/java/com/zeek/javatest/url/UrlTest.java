package com.zeek.javatest.url;

import org.junit.Test;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @ClassName UrlTest
 * @Description
 * @Author liweibo
 * @Date 2019/3/22 2:23 PM
 * @Version v1.0
 **/
public class UrlTest {

    @Test
    public void name() throws Exception{

        String name = "张三" ;
        name = URLEncoder.encode(name, "UTF-8");
        System.out.println(name);
        name = URLDecoder.decode(name, "UTF-8");
        System.out.println(name);


    }
}
