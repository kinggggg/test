package com.zeek.kotlintest.classtest.lee;

/**
 * @ClassName DataClassTest
 * @Description
 * @Author liweibo
 * @Date 2019/1/10 上午9:14
 * @Version v1.0
 **/
public class DataClassTest {

    public static void main(String[] args) {
        DataClass dataClass = new DataClass("zhangsan", 18);
        dataClass.getName();
        dataClass.setName("abc");
        dataClass.getAge();
    }
}
