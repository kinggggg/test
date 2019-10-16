package com.zeek.java8.shengsiyuan;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest2 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        PredicateTest2.conditionFileter(list, item -> item % 2 == 0);
        System.out.println("===================");
        PredicateTest2.conditionFileter(list, item -> true);
    }

    public static void conditionFileter(List<Integer> list, Predicate<Integer> predicate) {
        list.stream().filter(item -> predicate.test(item)).forEach(integer -> System.out.println(integer));
    }


}
