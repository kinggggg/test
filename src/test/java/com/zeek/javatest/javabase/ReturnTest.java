package com.zeek.javatest.javabase;

/**
 * @ClassName ReturnTest
 * @Description return执行时机
 * @Author liweibo
 * @Date 2019/8/5 4:21 PM
 * @Version v1.0
 **/
public class ReturnTest {

    public static void main(String[] args) {


        int call = ReturnTest.call();
        System.out.println(call);

    }

    public static int call() {
        ReturnTest returnTest = new ReturnTest();

        try {
            // 在return之前，会先执行finally代码块中的方法
            return returnTest.returnTest();
        }finally {
            System.out.println("finally");
        }
    }

    public static int returnTest () {
        System.out.println("returnTest");
        return 1;
    }
}
