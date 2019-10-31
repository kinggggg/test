package com.zeek.java8.shengsiyuan.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest6
 * @Description
 * @Author liweibo
 * @Date 2019/10/31 2:51 PM
 * @Version v1.0
 **/
public class StreamTest6 {

    public static void main(String[] args) {

//        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
//        stream.findFirst().ifPresent(System.out::println);

//        Stream.iterate(1, i -> i + 2).limit(6).forEach(System.out::println);
//
//        System.out.println("=============");
//
//        Stream.iterate(1, i -> i + 2)
//                .limit(6).filter(i -> i > 2)
//                .map(i -> i * 2)
//                .skip(4)
//                .reduce((one, two) -> one + two)
//                .ifPresent(System.out::println);
//
//        IntSummaryStatistics intSummaryStatistics = Stream.iterate(1, i -> i + 2)
//                .filter(i -> i > 2)
//                .mapToInt(item -> item * 2)
//                .summaryStatistics();
//        System.out.println(intSummaryStatistics.getMin());
//        System.out.println(intSummaryStatistics.getMax());
//        System.out.println(intSummaryStatistics.getAverage());
//        System.out.println(intSummaryStatistics.getCount());

        // 流类似打开文件一样，不能重复操作
//        Stream<Integer> stream = Stream.of(1, 3, 5);
//        System.out.println(stream.filter(i -> i > 2));
//        System.out.println(stream.findFirst());


    }
}
