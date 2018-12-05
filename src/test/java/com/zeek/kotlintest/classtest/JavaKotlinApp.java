package com.zeek.kotlintest.classtest;

import com.zeek.kotlintest.classtest.lee.DataClass;
import com.zeek.kotlintest.classtest.lee.Foo;
import com.zeek.kotlintest.classtest.lee.HelloKt;

/**
 * @ClassName JavaKotlinApp
 * @Description
 * @Author liweibo
 * @Date 2018/11/26 下午3:35
 * @Version v1.0
 **/
public class JavaKotlinApp {

    public static void main(String[] args) {

        Person person = new Person();
        person.getAge();

        Foo foo = new Foo("张三");

        DataClass dataClass = new DataClass("张三", 18);
        dataClass.getName();

    }
}
