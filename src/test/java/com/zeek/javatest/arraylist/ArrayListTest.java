package com.zeek.javatest.arraylist;

import com.zeek.javatest.domain.User;
import org.junit.Test;

import java.util.*;

/**
 * Created by weibo_li on 2017/4/25.
 */
public class ArrayListTest {

    @Test
    public void test6() throws Exception {

        //静态初始化数组
        String[] array1 = new String[] {
                "a",
                "b"
        };
        printArray(array1);

        //动态初始化数组
        String[] array2 = new String[2];
        printArray(array2);

        String[] array3;
//        System.out.println(array3);

        //静态初始化与动态初始化不能混合使用
//        String[] array3 = new String[5] {
//
//        };


    }

    @Test
    public void test5() {
        String[] arrays = new String[] { "1", "2", "3" };
        List<String> list = Arrays.asList(arrays);
        System.out.println(list);
        System.out.println(list.getClass());
        List<String> list2 = new ArrayList<String>(list);
        list2.add(0, "0");
        System.out.println(list2);
        System.out.println(list.getClass());
    }

    @Test
    public void test4() {
        List<String> lists = new ArrayList();
        lists.add("1");
        lists.add("2");
        lists.add("3");
        lists.add("4");
        lists.add("5");

        List<String> rems = new ArrayList();
        rems.add("1");
        rems.add("2");
        rems.add("5");

        lists.removeAll(rems);
        System.out.println(lists);
    }

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

    private void printArray(String[] array) {
        if (array == null) {
            System.out.println("array is null");
        }else {
            Arrays.stream(array).forEach(element -> {
                System.out.println(element);
            });
        }
    }
}
