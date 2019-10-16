package com.zeek.java8.shengsiyuan;

import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {

        Predicate<String> predicate = p -> p.length() > 5;
        System.out.println(predicate.test("hello"));

    }


}
