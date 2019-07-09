package com.zeek.javatest.lombok;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: weibo_li
 * @since: 2017-12-26 下午1:24
 */
@Getter
@Setter
@ToString(exclude = {"name"})
public class LombokTest {

    private String name;

    private int age;

    public static void main(String[] args) {
        LombokTest lombok = new LombokTest();
        lombok.setName("zhangsan");

        System.out.println(lombok);


        List<Integer> list = new ArrayList<>();
        list.add(new Integer(1));
        list.add(new Integer(2));

        System.out.println(list.contains(new Integer(3)));
    }
}
