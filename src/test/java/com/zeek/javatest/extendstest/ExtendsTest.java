package com.zeek.javatest.extendstest;

import org.junit.Test;

/**
 * @author: weibo_li
 * @since: 2018-03-08 下午7:49
 */
public class ExtendsTest {

    @Test
    public void name() throws Exception {
        //显示提供了带参数的构造函数后，就不再提供不带参数构造函数
//        Person person = new Person();

        Student student = new Student("zhangsan", 18);
        System.out.println(student);
    }
}
