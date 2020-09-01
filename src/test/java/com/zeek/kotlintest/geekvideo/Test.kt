package com.zeek.kotlintest.geekvideo

import kotlin.reflect.KClass

/**
 * @author liweibo
 * Created on 2020-08-31
 */


var age: Int = 18
var age1 = 18

var name: String = "zhang san"
var name2: String? = null

fun main(args: Array<String>) {
    // 强制转换
//    name = name2!!
//    name2 = name

    printLen(name)

    testClass(JavaMain::class.java)
    testClass(KotlinMain::class)

    var a = 10;
    println(a.unaryMinus())

    var str1 = java.lang.String("hello")
    var str2 = java.lang.String("hello")
    println(str1 == str2)
    var b: String? = null
    var c: String? = null
    println(str1?.equals(b))
    println(null == null)
    println(null === null)

    var closeRange = 1 .. 10;
    for (num in closeRange) {
        println(num)
    }
    println(closeRange)
    println(closeRange.count())
    println("==============================================")
    for (index in 0 until closeRange.count()) {
        println(index)
    }

    println("==============================================")
    // kotlin的break只break内层的循环
    for (i in 0 .. 10) {
        for (j in 0..10) {
            println("i = $i, j = $j")
            if (j == 1) {
                println("break")
                break;
            }
        }
    }
    println("==============================================")
    for (i in 0 .. 10) {
        for (j in 0..10) {
            println("i = $i, j = $j")
            if (j == 1) {
                println("return")
                return
            }
        }
    }
}

fun printLen(str: String): String{

    println("这个字符串是：$str");

    return str
}

fun testClass(clazz: Class<JavaMain>) {
    println(clazz.simpleName)
}

fun testClass(clazz: KClass<KotlinMain>) {
    println(clazz.simpleName)
}