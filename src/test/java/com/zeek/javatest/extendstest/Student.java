package com.zeek.javatest.extendstest;

/**
 * @author: weibo_li
 * @since: 2018-03-08 下午7:50
 */
public class Student extends Person{
    Student(String name, Integer age) {

        //注释掉下面的代码, 程序会编译不通过。因为会默认调用父类的没有参数的super()方法；
        //而当父类中手动提供了带参数的构造方法后，java编译器就不再提供默认的构造方法，因此会报错
        super(name, age);
    }
}
