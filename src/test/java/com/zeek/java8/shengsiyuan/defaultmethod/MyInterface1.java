package com.zeek.java8.shengsiyuan.defaultmethod;

/**
 * @author: liweibo
 * @since: 2019-10-24 5:00 PM
 */
public interface MyInterface1 {

    default void myMethod() {
        System.out.println("MyInterface1");
    }
}
