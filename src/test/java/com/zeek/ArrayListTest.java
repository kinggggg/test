package com.zeek;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weibo_li on 16/4/8.
 */
public class ArrayListTest {

    @Test
    public void testRepeat() {
        List<String> list = new ArrayList<String>();

        list.add("a");
        list.add("a");
        list.add("c");
        System.out.println(list);
    }
}
