package com.zeek.javactest;

import org.junit.Test;

import java.io.IOException;

/**
 * @author: weibo_li
 * @since: 2018-08-03 下午5:42
 */
public class JavacTest {

    @Test
    public void test01() throws IOException {

        Runtime.getRuntime().exec("javac /Users/weibo_li/Documents/code/Test/src/test/java/com/zeek/javatest/domain/User.java");
    }
}
