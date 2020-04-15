package com.zeek.java8.shengsiyuan.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest5
 * @Description
 * @Author liweibo
 * @Date 2019/10/31 2:51 PM
 * @Version v1.0
 **/
public class StreamTest5 {

    public static void main(String[] args) {

//        List<String> list = Arrays.asList("hello", "world", "helloworld");
//        list.stream().map(item -> item.toUpperCase()).forEach(System.out::println);
//        list.stream().map(String::toUpperCase).forEach(System.out::println);

        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));

        stream.flatMap(theList -> theList.stream()).map(item -> item * item).forEach(System.out::println);
    }
}
