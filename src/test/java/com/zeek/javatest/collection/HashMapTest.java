package com.zeek.javatest.collection;

import org.junit.Test;

import java.util.HashMap;

/**
 * @ClassName HashMapTest
 * @Description
 * @Author liweibo
 * @Date 2019/12/16 6:01 PM
 * @Version v1.0
 **/
public class HashMapTest {


    @Test
    public void test01() {

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("001", "a");
        hashMap.put("001", "b");

        hashMap.get("001");

    }
}
