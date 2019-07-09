package com.zeek.javatest.genericstest;

/**
 * @ClassName NumberPair
 * @Description
 * @Author liweibo
 * @Date 2018/10/19 下午7:49
 * @Version v1.0
 **/
public class NumberPair<T extends Number> extends Pair<T>{

    public static void main(String[] args) {
        NumberPair<Integer> numberPair = new NumberPair<>();
//        NumberPair<String> numberPair1 = new NumberPair<String>();

        Pair<String> pair = new Pair<>();

    }
}
