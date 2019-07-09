package com.zeek.jvm.xupeicheng;

import org.junit.Test;

/**
 * @ClassName TestJVM
 * @Description
 * @Author liweibo
 * @Date 2018/12/6 下午12:38
 * @Version v1.0
 **/
public class TestJVM {

    /**
     * @Description: 测试Eden区
     * @Author: liweibo
     **/
    @Test
    public void test2() {

        System.out.println("kk");

        for (;;) {
            byte[] ss = new byte[1024 * 1024 * 50];

        }
    }

    /**
     * @Description: 测试Eden区jv
     * @Author: liweibo
     **/
    @Test
    public void test1() {

        System.out.println("kk");
        byte[] bytes = new byte[1024 * 1024 * 50];
        System.out.println(bytes.length);
    }
}
