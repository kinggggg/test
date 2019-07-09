package com.zeek.javatest.collection.linkedlist;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LinkedListTest
 * @Description
 * @Author liweibo
 * @Date 2018/11/29 下午3:18
 * @Version v1.0
 **/
public class LinkedListTest {

    @Test
    public void test01() {

        List<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");

        System.out.println(linkedList);

        String a = linkedList.get(0);
        System.out.println(a);



    }
}
