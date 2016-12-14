package com.zeek.lambda;

import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.IntUnaryOperator;
import java.util.stream.Stream;

/**
 * Created by weibo_li on 16/3/30.
 */
public class LambdaTest {

    @Test
    public void firstTest() {
        List<Integer> intList = Arrays.asList(4, 2, 3);

        Stream<Integer> intStream = intList.stream();

        OptionalDouble maxDistance = intStream
                .map(i -> new Point(i, i))
                .mapToDouble(p -> p.distance(0, 0)).max();

        System.out.printf(maxDistance.toString());
    }

    @Test
    public void secondTest() {
//        Runnable sleeper = () -> {
//            System.out.println("zzz");
//            Thread.sleep(1000);
//        };

        Callable<Void> sleeper = () -> {
            System.out.println("zzz");
            Thread.sleep(1000);
            return null;
        };
    }

//    public void foo(){
//        final int i = 2;
//        Runnable r = () -> {
//            int i = 3;
//        };
//    }

    @Test
    public void nullElementListTest() {
        List<Foo> list = new ArrayList<>();
        list.add(null);

    }

    @Test
    public void thisAndSuperTest() {
        new Thread(new Runnable() {
            public String name = "inner";
            public int count = 2;

            @Override
            public void run() {
                while (true) {
                    if (count == 0) {
                        break;
                    }
                    System.out.println("test");
                    System.out.println(this.name);
                    System.out.println(super.getClass());
                    count--;
                }


            }
        }).start();
    }

    @Test
    public void testScope() {

    }

    @Test
    public void testConstructor() {

        Stream<String> streamString = Stream.of("a.txt", "b.txt", "c.txt");

        Stream<File> fileStream = streamString.map(File::new);
    }


}

class Foo {

    Object i, j;

    IntUnaryOperator iuo = i -> {
        int j = 3;
        return i + j;
    };

}
