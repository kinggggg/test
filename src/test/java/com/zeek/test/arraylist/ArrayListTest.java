package com.zeek.test.arraylist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by weibo_li on 2017/4/25.
 */
public class ArrayListTest {

    @Test
    public void test1() {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");

        strings.add(3, "3");

        System.out.println(strings);
    }
}
