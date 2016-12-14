package com.zeek;

import org.junit.Test;

import java.util.*;

/**
 * Created by weibo_li on 2016/11/24.
 */
public class SetTest {

    @Test
    public void setTest() {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("a");

        List<String> strings = Arrays.asList("a", "b", "c", "c");
        Set<String> set2 = new HashSet<>(strings);


        System.out.println(set2);
    }
}
