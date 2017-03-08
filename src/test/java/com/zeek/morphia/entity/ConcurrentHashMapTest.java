package com.zeek.morphia.entity;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by weibo_li on 2017/3/1.
 */
public class ConcurrentHashMapTest {

    @Test
    public void test() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("a", "1");
        map.put("b", "2");

        System.out.println(map.newKeySet());

        Set set = map.newKeySet();

    }

    @Test
    public void test2() {
        int[] ones = new int[10];

        Arrays.fill(ones, 1);

        for (int i = 0; i < ones.length; i++) {
            System.out.println(ones[i]);
        }

        Arrays.parallelPrefix(ones, (a, b) -> a + b);

        for (int i = 0; i < ones.length; i++) {
            System.out.println(ones[i]);
        }


    }
}
