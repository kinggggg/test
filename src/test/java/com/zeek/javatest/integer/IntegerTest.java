package com.zeek.javatest.integer;

import org.junit.Test;

/**
 * @ClassName IntegerTest
 * @Description
 * @Author liweibo
 * @Date 2018/10/25 下午5:30
 * @Version v1.0
 **/
public class IntegerTest {

    @Test
    public void test04() {
        Integer i = 127;
        Integer j = 127;
        if(i==j){
            System.out.println("i==j is equal");
        }else {
            System.out.println("i==j is not equal");
        }
    }

    @Test
    public void test03() {
        Integer i = 128;
        Integer j = 128;
        if(i==j){
            System.out.println("i==j is equal");
        }else {
            System.out.println("i==j is not equal");
        }

    }

    @Test
    public void test02() {
        Integer i = 500;
        Integer j = new Integer(500);
        if(i==j){
            System.out.println("i==j is equal");
        }else {
            System.out.println("i==j is not equal");
        }

    }

    @Test
    public void test01() {

        Integer i = new Integer(555);
        Integer j = new Integer(555);
        if(i==j){
            System.out.println("i==j is equal");
        }else {
            System.out.println("i==j is not equal");
        }

    }


}
