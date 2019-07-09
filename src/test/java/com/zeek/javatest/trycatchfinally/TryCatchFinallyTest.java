package com.zeek.javatest.trycatchfinally;

import org.junit.Test;

import java.util.Objects;

/**
 * @ClassName TryCatchFinallyTest
 * @Description
 * @Author liweibo
 * @Date 2019/1/17 上午11:14
 * @Version v1.0
 **/
public class TryCatchFinallyTest {

    @Test
    public void test02() {

        this.readFile(null);

    }

    public void readFile(String fileName) {
        Objects.requireNonNull(fileName);
    }
}
