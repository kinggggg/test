package com.zeek.test.spring.learn.domain;

/**
 * @author: weibo_li
 * @since: 2018-02-22 下午12:26
 */
public class User {

    public User() {

    }

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    private String username;

    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
