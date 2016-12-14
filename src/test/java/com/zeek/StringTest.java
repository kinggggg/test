package com.zeek;

import com.zeek.springdataentity.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by weibo_li on 16/4/8.
 */
public class StringTest {

    @Test
    public void secondTest(){

        String str = "a|b|c" ;
        String[] arr = str.split(" \\| ");
        System.out.print(arr);
    }

    @Test
    public void secondTest2(){

        System.out.println(Calendar.getInstance().getTime());
    }

    @Test
    public void secondTest3(){

        List<Person> list1 = new ArrayList<>();

    }

    @Test
    public void secondTest4(){

        String str = "hello";

        String[] split = str.split("");

        System.out.println(str.split(""));

    }
}
