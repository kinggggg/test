package com.zeek.morphia.entity;

import org.junit.*;

/**
 * Created by weibo_li on 2016/12/28.
 */
public class ForLoopTest {


    @Test
    public void forTest() {
        for(int count = 0; count < 10 ; count++) {
            if(count == 5) {
                break;
            }
            System.out.println(count);
        }
    }
}
