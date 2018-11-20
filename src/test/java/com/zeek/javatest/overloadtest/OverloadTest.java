package com.zeek.javatest.overloadtest;

/**
 * @author: weibo_li
 * @since: 2018-06-02 下午4:15
 */
public class OverloadTest {

    public static void main(String[] args) {

        double i = 1d;
        new OverloadTest().test1(i);
    }

    int test1(int i) {
        return i;
    }

    //仅仅返回值类型不同不能构成函数的重载
    /*long test1(int i) {
        return i;
    }*/

    long test1(long i) {
        return i;
    }

    double test1(double i) {
        return i;
    }
}
