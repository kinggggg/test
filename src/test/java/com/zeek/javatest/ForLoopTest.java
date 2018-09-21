package com.zeek.javatest;

import org.junit.*;

/**
 * Created by weibo_li on 2016/12/28.
 */
public class ForLoopTest {


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
