package com.zeek.test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by weibo_li on 2017/2/27.
 */
public class UrlDecodeTest {
    @Test
    public void test() {
        String str = "{\\\"id\\\":\\\"000000000082132940000100000200000000\\\",\\\"text\\\":\\\"%E3%80%8A%E6%9C%9F%E8%B4%A7%E4%BA%A4%E6%98%93%E7%AE%A1%E7%90%86%E6%9D%A1%E4%BE%8B%E3%80%8B%E7%AC%AC%E4%BA%8C%E6%9D%A1\\\"" ;
        String decode = null;
        try {
            decode = URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(decode);
    }
}
