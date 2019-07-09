package com.zeek.jvm.xupeicheng;

/**
 * @ClassName TestGC
 * @Description 测试垃圾回收
 * @Author liweibo
 * @Date 2018/12/17 下午10:46
 * @Version v1.0
 **/
public class TestGC {

    public static void main(String[] args) {

        System.out.println("1");

        byte[] arr = new byte[1024 * 1024 * 100];

    }
}
