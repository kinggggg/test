package com.zeek.javatest.genericstest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2021-02-02
 */
public class GenericTest {

    @Test
    public void genericTest() {
        List<String> listString = new ArrayList<>();
        test(listString);

        List<Integer> listInt = new ArrayList<>();
        test(listInt);
    }

    public void test(List<?> list) {

    }
}
