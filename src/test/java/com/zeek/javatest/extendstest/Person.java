package com.zeek.javatest.extendstest;

/**
 * @author: weibo_li
 * @since: 2018-03-08 下午7:49
 */
public class Person {

    Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    String name;

    Integer age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
