package com.zeek.javatest.collection.arraylist;

public class ArrayTestMain {

    public static void main(String[] args) {

        int i = 0;

        Cat[] cats = new Cat[2];
        cats[0] = new Cat(0);
        cats[1] = new Cat(1);
        while(true) {
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Cat {

    public Cat(int age) {
        this.age = age;
    }

    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
