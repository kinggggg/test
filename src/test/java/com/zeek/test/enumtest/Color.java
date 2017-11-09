package com.zeek.test.enumtest;

public enum Color {
    RED, BLACK
}

class Test{
    public static void main(String[] args) {
        System.out.println(Color.RED.getClass() == Color.RED.getClass());
    }
}
