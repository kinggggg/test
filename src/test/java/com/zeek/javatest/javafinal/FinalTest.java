package com.zeek.javatest.javafinal;

import org.junit.Test;

public class FinalTest {

    @Test
    public void test1() {
        final String str;
        str = "initial";
        System.out.println(str);

        //已经初始化，无法再一次给final修饰的变量赋值
        /*final String str1 = "initial2";
        str1 = "initial3";*/

        final int intType;
        intType = 1;
        System.out.println(intType);
        final int intType2;
        final Integer integerType ;
        integerType = 2;
        System.out.println(integerType);

        System.out.println("=======================");
        FinalData finalData = new FinalData();
        System.out.println(finalData.booleanType);
        System.out.println(finalData.charType);
        System.out.println(finalData.shortType);
        System.out.println(finalData.intType);
        System.out.println(finalData.longType);
        System.out.println(finalData.floatType);
        System.out.println(finalData.doubleType);
    }
}
