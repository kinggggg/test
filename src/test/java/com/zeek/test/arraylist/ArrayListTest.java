package com.zeek.test.arraylist;

import com.zeek.test.domain.User;
import org.junit.Test;

import java.util.*;

/**
 * Created by weibo_li on 2017/4/25.
 */
public class ArrayListTest {

    @Test
    public void test3() {
        List<User> usersList = new ArrayList<>();
        User one = new User("1", "张三");
        usersList.add(one) ;
        usersList.add(one) ;
        usersList.add(one) ;
        usersList.add(new User("2", "lisi")) ;

        usersList.stream().forEach(user -> {
            System.out.println(user.toString());
        });

        System.out.println("=======================");

        Set<User> usersSet = new HashSet<>();
        usersSet.addAll(usersList);
        usersList.clear();
        usersList.addAll(usersSet);

        usersList.stream().forEach(user -> {
            System.out.println(user.toString());
        });




    }

    @Test
    public void test2() {
        List<User> users = new ArrayList<>();
        User one = new User("1", "zhangsan");
        users.add(one) ;
        users.add(new User("2", "lisi")) ;

        List<User> users1 = users.subList(0, 1);
        users1.stream().forEach(user -> {
            user.setId("3");
            System.out.println(user.toString());
        });

        users1.clear();

        System.out.println("=======================");

        users.stream().forEach(user -> {
            System.out.println(user.toString());
        });


    }

    @Test
    public void test1() {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");

        strings.add(3, "3");

        System.out.println(strings);
    }
}
