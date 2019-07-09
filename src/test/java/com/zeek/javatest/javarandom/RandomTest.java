package com.zeek.javatest.javarandom;

import org.junit.Test;

import java.util.Random;

/**
 * @author: weibo_li
 * @since: 2018-01-03 下午4:25
 */
public class RandomTest {

    @Test
    public void test0() throws Exception {

        System.out.println(new Random().nextInt(10));

        System.out.println(Math.random());
    }
}
