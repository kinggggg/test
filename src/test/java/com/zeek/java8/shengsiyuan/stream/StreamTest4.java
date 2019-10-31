package com.zeek.java8.shengsiyuan.stream;

import java.security.cert.CollectionCertStoreParameters;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest4 {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("hello", "world", "helloworld");

        //lambda形式参数
//        String[] stringArray = stream.toArray(length -> new String[length]);
//        Arrays.asList(stringArray).forEach(System.out::println);
        // 方法引用形式参数
//        String[] stringArray = stream.toArray(String[]::new);
//        Arrays.asList(stringArray).forEach(System.out::println);

        // 使用JDK提供的方法
//        List<String> list = stream.collect(Collectors.toList());
        // 手动传递参数
//        List<String> list = stream.collect(() -> new ArrayList(), (theList, item) -> theList.add(item), (theList1, thelist2) -> theList1.addAll(thelist2));
        // 使用方法引用传递参数
//        List<String> list = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//        list.forEach(System.out::println);

        // 使用Collectors.toCollection就更加灵活，可以转换成任意的集合
//        转换成ArrayList
//        List<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
//        list.forEach(System.out::println);
//        转换成LinkedList
//        LinkedList<String> linkedList = stream.collect(Collectors.toCollection(LinkedList::new));
//        linkedList.forEach(System.out::println);
//        转换成HashSet
//        Collection<String> hashSet = stream.collect(Collectors.toCollection(HashSet::new));
//        hashSet.forEach(System.out::println);

        String joining = stream.collect(Collectors.joining());
        System.out.println(joining);


    }
}
