package com.zeek.java8.shengsiyuan.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest
 * @Description
 * @Author liweibo
 * @Date 2019/10/24 7:15 PM
 * @Version v1.0
 **/
public class StreamTest {

    public static void main(String[] args) {

        Stream<String> stream1 = Stream.of("hello", "world", "hello world");

        String[] myArray = new String[]{"hello", "world", "hello world"};
        Stream<String> stream2 = Stream.of(myArray);

        Stream<String> stream3 = Arrays.stream(myArray);

        List<String> list =
                Arrays.asList(myArray);
        Stream<String> stream = list.stream();

        IntStream.of(new int[]{5, 6, 7}).forEach(System.out::println);

        System.out.println("==================");
        IntStream.range(3, 8).forEach(System.out::println);

        System.out.println("==================");

        IntStream.rangeClosed(3, 8).forEach(System.out::println);

        System.out.println("==================");

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(list1.stream().map(item -> item * 2).reduce(0, Integer::sum));

        System.out.println("==================");

        System.out.println("==================");

        System.out.println("==================");

        System.out.println("==================");

        System.out.println("==================");

        System.out.println("==================");
    }
}
