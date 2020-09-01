package com.zeek.kotlintest.geekvideo;

/**
 * @author liweibo03
 * Created on 2020-08-31
 */
public class Main {

    public static void main(String[] args) {
        UtilsKt.echo("hello");

        // java break也是只break内层循环
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i = " + i + ", j = " + j);
                if (j == 1) {
                    break ;
                }
            }
        }

        // 带标号的break可以break外层循环
        breakTag: for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i = " + i + ", j = " + j);
                if (j == 1) {
                    break breakTag;
                }
            }
        }
    }
}
