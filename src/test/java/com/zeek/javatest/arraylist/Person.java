package com.zeek.javatest.arraylist;

/**
 * @author: weibo_li
 * @since: 2018-03-06 下午7:56
 */
public class Person {

    static {
        System.out.println("静态代码块");
    }

    Person() {
        System.out.println("构造函数");
        System.out.println(age);
    }

    {
        System.out.println("非静态代码块");
    }



    Integer age;
}
