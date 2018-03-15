package com.zeek.test.spring.learn.domain;

/**
 * @author: weibo_li
 * @since: 2018-02-22 下午12:26
 */
public class Book {

    public Book() {

    }

    public Book(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    private String name;

    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
