package com.zeek.javatest.url;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by weibo_li on 2017/2/27.
 */
public class UrlDecodeTest {
    @Test
    public void test() throws Exception {
        String str = "{\\\"id\\\":\\\"000000000082132940000100000200000000\\\",\\\"text\\\":\\\"%E3%80%8A%E6%9C%9F%E8%B4%A7%E4%BA%A4%E6%98%93%E7%AE%A1%E7%90%86%E6%9D%A1%E4%BE%8B%E3%80%8B%E7%AC%AC%E4%BA%8C%E6%9D%A1\\\"" ;
        String decode = null;
        try {
            decode = URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(decode);


        String name = "李四" ;
        name = URLEncoder.encode(name, "utf-8");
        System.out.println(name);
        name = URLDecoder.decode(name, "utf-8");
        System.out.println(name);

        name = "192.168.23.23" ;
        name = URLEncoder.encode(name, "utf-8");
        System.out.println(name);
        name = URLDecoder.decode(name, "utf-8");
        System.out.println(name);

    }
}
