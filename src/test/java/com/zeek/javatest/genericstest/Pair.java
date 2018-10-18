package com.zeek.javatest.genericstest;

/**
 * @ClassName Pair
 * @Description
 * @Author liweibo
 * @Date 2018/10/18 下午8:46
 * @Version v1.0
 **/
public class Pair<T> {

    private T one;

    private T two;

    public Pair(){}

    public Pair(T one, T two) {
        this.one = one;
        this.two = two;
    }

    public T getOne() {
        return one;
    }

    public void setOne(T one) {
        this.one = one;
    }

    public T getTwo() {
        return two;
    }

    public void setTwo(T two) {
        this.two = two;
    }

    public static void main(String[] args) {
        Pair<Integer> pair = new Pair<>(10, 20);

        System.out.println(pair.getOne());

        System.out.println(pair.getTwo());

    }
}
