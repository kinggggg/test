package com.zeek.javatest.freemaker;

/**
 * @author: weibo_li
 * @since: 2018-08-01 下午2:23
 */
public class FreemarkerPerson {

    public FreemarkerPerson() {

    }

    public FreemarkerPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;

    private int age;

    private FreemarkerStudent student;

    public FreemarkerStudent getStudent() {
        return student;
    }

    public void setStudent(FreemarkerStudent student) {
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
