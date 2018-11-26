package com.zeek.kotlintest.classtest

/**
 * this在构造器中的使用
 * @author: weibo_li
 * @since: 2018-11-26 下午4:34
 */
class ThisInConstructor {

    var foo : Int

    constructor() {
        val foo = 0

        /**
         * 使用this代表正在初始化的对象
         * 局部变量和属性重名的话，必须使用this来访问属性
         */
        this.foo = 6;
    }
}

/**
 * 返回this
 */
class ReturnThis {
    var age : Int = 0

    fun grow() : ReturnThis{
        age++
        return this;
    }
}

class Cat {
    fun run () {
        println("Cat.run")
    }

    fun eat(someThing : String) {
        println("Cat.eat ${someThing}")
    }
}

/**
 * 定义中缀方法练习
 */
class ApplePack(weight : Double) {

    var weight = weight

    override fun toString(): String {
        return "AppPack[weight=${this.weight}]"
    }

}
class Apple(weight: Double) {

    var weight = weight

    override fun toString(): String {
        return "Apple[weight=${weight}]"
    }

    //定义中缀方法 infix修饰
    infix fun add(other : Apple) : ApplePack {
        return ApplePack(this.weight + other.weight)
    }

    //定义中缀方法 infix修饰
    infix fun drop(other: Apple) : Apple {
        return Apple(this.weight - other.weight)
    }

}



fun main(args: Array<String>) {
    println(ThisInConstructor().foo)

    var rt : ReturnThis = ReturnThis()
    rt.grow()
            .grow()
            .grow()
    println(rt.age)

    var rn : (Cat) -> Unit = Cat::run
    val c = Cat()
    rn(c)
    var et = Cat::eat
    et(c, "hello")

    var apple1 = Apple(10.0)
    var apple2 = Apple(20.0)
    println(apple1 add apple2)
    println(apple1 drop apple2)

}