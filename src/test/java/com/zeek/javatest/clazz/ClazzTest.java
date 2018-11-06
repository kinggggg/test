package com.zeek.javatest.clazz;

import org.junit.Test;

/**
 * @ClassName ClazzTest
 * @Description
 * @Author liweibo
 * @Date 2018/11/5 下午4:34
 * @Version v1.0
 **/
public class ClazzTest {

    @Test
    public void test01() {

        Class<String> stringClass = String.class;
        System.out.println(stringClass.hashCode());

        Class<Integer> integerClass = Integer.class;
        System.out.println(integerClass.hashCode());
    }
}
