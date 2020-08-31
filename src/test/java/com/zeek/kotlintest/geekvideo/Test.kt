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