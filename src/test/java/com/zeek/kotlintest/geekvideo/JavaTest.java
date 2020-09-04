package com.zeek.kotlintest.geekvideo;

import kotlin.io.FilesKt;
import kotlin.text.Charsets;

import java.io.File;
import java.util.Comparator;

/**
 * @author liweibo03
 * Created on 2020-08-31
 */
public class JavaTest {

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

        InnerTest.INSTANCE.sayMessage("hello");
        InnerTest.sayMessage("hello");

        ((MyInterface) () -> System.out.println("hello world")).say();

        File file = new File("/Users/liweibo03/Documents/code/Test/src/main/java/com/jvm/fangzhiming/TestClass.java");
        String readText = FilesKt.readText(file, Charsets.UTF_8);
        System.out.println(readText);
        System.out.println("==============================================1");
        Comparator<Integer> comparator = (a, b) -> a - b;



    }
}
