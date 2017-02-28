package com.zeek.morphia.entity;

import com.sun.istack.internal.NotNull;
import com.zeek.morphia.entity.test.parent.Teacher1;
import org.junit.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Test
    public void testCompareTo() {
        System.out.println("Marry".compareTo("Will"));
    }

}
