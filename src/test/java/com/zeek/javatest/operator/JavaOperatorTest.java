package com.zeek.javatest.operator;

/**
 * @ClassName JavaOperatorTest
 * @Description
 * @Author liweibo
 * @Date 2019/7/30 4:44 PM
 * @Version v1.0
 **/
public class JavaOperatorTest {

    public static void main(String[] args) {

        int b1 = 0b00000101;
        System.out.println("b1: " + b1);
        int b2 = 0b00000100;
        System.out.println("b2: " + b2);
        System.out.println(b1 &= b2);

        int b3 = 0b00000101;
        int b4 = 0b00000100;
        System.out.println(b3 |= b4);

        int b5 = 0b00000101;
        int b6 = 0b00000100;
        System.out.println(b5 ^= b6);

        int b7 = 0x0001;
        int b8 = 0x0100;
        System.out.println(b7 ^= b8);

    }
}
