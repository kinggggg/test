package com.zeek;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weibo_li on 16/4/8.
 */
public class BreakTest {

    /**
     * break只是跳出内层循环,不会跳出外层循环;
     */
    @Test
    public void testBreak(){
        int i = 0;

        tt : while(i < 10){

            System.out.println("i = " + i);
            ++i;

            for(; i < 5; ){
                System.out.println("ii = " + i);
                break ;
            }

        }
    }
}
