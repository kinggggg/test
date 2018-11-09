package com.zeek.javatest.forlooptest;

import org.junit.*;

/**
 * Created by weibo_li on 2016/12/28.
 */
public class ForLoopTest {

    // return无论位于嵌套循环中的多么深的层中，只有遇到return，马上退出所有的循环
    @Test
    public void test01() {
        for(int i = 0; i < 5 ; i++) {
            System.out.format("i = %d \n", i);

            for(int j = 5; i < 10 ; j++) {
                System.out.format("j = %d \n", j);

                if(j == 5) {
                    return;
                }
            }
        }
    }


    @Test
    public void forTest() {
        for(int count = 0; count < 10 ; count++) {
//            if(count == 5) {
//                break;
//            }

            if(count == 5) {
                try {
                    int i = 1 / 0;
                }catch (Exception e) {
                    return;
                }
            }

            System.out.println(count);
        }
    }

    @Test
    public void testCompareTo() {
        System.out.println("Marry".compareTo("Will"));
    }

}
