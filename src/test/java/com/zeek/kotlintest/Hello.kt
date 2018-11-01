package com.zeek.kotlintest

fun main(args: Array<String>) {
    println("Hello World!")

    var af1 = 5.2123123123f;
    println("af1的值为:${af1}");
    println("af1的类型为:${af1.javaClass}");

    var af2 = 5.2123123123;
    println("af2的值为:${af2}");
    println("af2的类型为:${af2.javaClass}");

    print("\n")
    println("aaaaaa")

    println("========================")
    var bookPrice : Byte = 10;
    var itemPrice : Short = 20;
    var total = bookPrice + itemPrice;

    println("表达式可以进行自动类型转换${total.javaClass}")

    println("========================")
    var i : Int = 97;
    println(i.toChar()); //int可以转换为字符输出

    println("========================")
    var sValue : Short = 5;
    println("sValue类型为${sValue.javaClass}")

    var iValeu : Int = 6;
    //sValue = iValeu; //只要在表达式中才能自动进行类型转换



}

