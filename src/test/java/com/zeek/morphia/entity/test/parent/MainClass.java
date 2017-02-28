package com.zeek.morphia.entity.test.parent;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by weibo_li on 2017/2/16.
 */
public class MainClass {

    public static void main(String[] args) {
        Teacher3 teacher3 = new Teacher3("zhangsan");
        Teacher3 teacher31 = new Teacher3("zhangsan");

        System.out.println(teacher3);
        System.out.println(teacher31);

        System.out.println(new Random().nextInt(2));

        Set<Teacher3> treeSet = new TreeSet<>();
        treeSet.add(teacher3);
        treeSet.add(teacher31);
        System.out.println(treeSet);
    }
}
