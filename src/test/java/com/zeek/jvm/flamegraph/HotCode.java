package com.zeek.jvm.flamegraph;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class HotCode {

    private static volatile int value;

    private static Object array;

    public static void main(String[] args) {

        int count = 10000;
        int current = 0;
        while (current < count) {
            hotmethod1();
            hotmethod2();
            hotmethod3();
            allocate();
            current++;
        }
    }

    /**
     * 生成 6万长度的数组
     */
    private static void allocate() {
        array = new int[100];
        array = new Integer[100];
    }

    /**
     * 生成一个UUID
     */
    private static void hotmethod3() {
        ArrayList<String> list = new ArrayList<>();
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString().replace("-", "");
        list.add(str);
    }

    /**
     * 数字累加
     */
    private static void hotmethod2() {
        value++;
    }

    /**
     * 生成一个随机数
     */
    private static void hotmethod1() {
        Random random = new Random();
        int anInt = random.nextInt();
    }
}