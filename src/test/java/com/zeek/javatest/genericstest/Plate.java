package com.zeek.javatest.genericstest;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2021-02-02
 */
public class Plate<T> {
    private T item;

    public Plate(T t) {
        item = t;
    }

    public void set(T t) {
        item = t;
    }

    public T get() {
        return item;
    }

    public static void main(String[] args) {

        //参考: https://www.zhihu.com/question/20400700

        Plate<? extends Fruit> p = new Plate<Apple>(new Apple());
//        p.set(new Fruit());
//        p.set(new Apple());
        Fruit fruit = p.get();

        Plate<? super Fruit> p2 = new Plate<Fruit>(new Apple());

        p2.set(new Apple());
        Object object = p2.get();


    }
}

class Fruit{

}
class Apple extends Fruit {}
