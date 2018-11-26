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



fun main(args: Array<String>) {
    println(ThisInConstructor().foo)

    var rt : ReturnThis = ReturnThis()
    rt.grow()
            .grow()
            .grow()
    println(rt.age)
}