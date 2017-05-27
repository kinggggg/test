package com.zeek.test.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by weibo_li on 2017/5/26.
 */
public class LambadaTest {

    @Test
    public void test() {

        Integer result ;
        List< Integer> someNumbers = Arrays. asList( 1, 2, 2, 4, 5);
        Optional< Integer> firstSquareDivisibleByThree = someNumbers. stream() .map(x -> x * x) .filter(x -> x % 3 == 0) .findFirst();

        firstSquareDivisibleByThree.get();

    }
}
