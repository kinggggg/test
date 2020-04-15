package com.zeek.javatest.map;

import com.zeek.javatest.collection.arraylist.Person;
import org.junit.Test;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by weibo_li on 2017/4/10.
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, HashSet<String>> map1 = new HashMap<>();
        // computeIfAbsent方法：判断Map中是否存在值为fruits的key，若不存在的话，以fruits为key以genValue函数
        // 的返回值value放入到Map中；若Map中之前存在key为fruits的话，直接使用对应的value
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("apple");
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("orange");
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("pear");
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("banana");
        map1.computeIfAbsent("fruits", k -> genValue(k)).add("water");
        System.out.println(map1);

    }

    static HashSet<String> genValue(String str) {
        return new HashSet<String>();
    }

    @Test
    public void test() {
        Map<String, Map<String, String>> certificationOrganizationCodeMap = new HashMap<>();

        Map<String, String> qiyeJobCodeMap = new HashMap<>();
        qiyeJobCodeMap.put("0101", "法务");
        qiyeJobCodeMap.put("0102", "公司律师");
        qiyeJobCodeMap.put("0103", "高管");
        qiyeJobCodeMap.put("0104", "工作人员");
        certificationOrganizationCodeMap.put("01", qiyeJobCodeMap);

        //法院
        qiyeJobCodeMap = new HashMap<>();
        qiyeJobCodeMap.put("0201", "法官");
        qiyeJobCodeMap.put("0202", "书记员");
        qiyeJobCodeMap.put("0203", "工作人员");
        certificationOrganizationCodeMap.put("02", qiyeJobCodeMap);


    }

    @Test
    public void test01() {

        Map<Person, Integer> items = new HashMap<>();
        items.put(new Person(1, "zhangsan"), 10);
        items.put(new Person(2, "lisi"), 20);

        items.forEach((k, v) -> {
            k.age = k.age + 1;
        });

        items.forEach((k, v) -> {
            System.out.println("k = " + k + "   ||   v = " +  v);
        });

    }
}
