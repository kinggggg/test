package com.zeek.javatest.switchtest;

import org.junit.Test;

/**
 * @ClassName SwitchTest
 * @Description
 * @Author liweibo
 * @Date 2018/12/12 下午5:19
 * @Version v1.0
 **/
public class SwitchTest {

    @Test
    public void test01() {

        int i = 10;
        switch (i) {
            case 0:
                System.out.println("0");
                System.out.println("0");
                break;
            case 10:
                System.out.println("10");
                System.out.println("10");
                break;

        }



    }
}
