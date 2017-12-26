package com.zeek.javatest.lombok;

import lombok.Data;

/**
 * @author: weibo_li
 * @since: 2017-12-26 下午1:24
 */
@Data
public class Lombok {

    private String name;

    private int age;

    public static void main(String[] args) {
        Lombok lombok = new Lombok();
        lombok.setName("zhangsan");

        System.out.println(lombok);
    }
}
