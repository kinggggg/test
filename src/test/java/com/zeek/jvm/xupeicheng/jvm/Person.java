package com.zeek.jvm.xupeicheng.jvm;

/**
 * @ClassName Person
 * @Description
 * @Author liweibo
 * @Date 2018/12/7 上午12:37
 * @Version v1.0
 **/
public class Person {

    //当第一次new Person对象；或者利用Class.forName("com.zeek.jvm.xupeicheng.jvm.Person")时才会执行静态代码块中的内容，并且只执行一次
    static {
        System.out.println("load person");
    }

    private int age;

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
