package com.zeek.kotlintest

import java.util.*

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

    println("========================类型转换")
    var sValue : Short = 5;
    println("sValue类型为${sValue.javaClass}")

    var iValeu : Int = 6;
    //sValue = iValeu; //只要在表达式中才能自动进行类型转换

    var str = "abc"
    //var num : Int = str.toIntOrNull(); //转换完成后的值有肯能为null或者整数值，因此num必须定义成Int?
    //var num2 : Int? = str.toIntOrNull(); //没有此方法？？？？

    println("========================编译器NPE检查")
    var aStr : String? = "abc"
    aStr = null;
    //println(aStr.length) //不能编译通过，编辑自动推断aStr有可能为null，可能出现NPE空指针异常

    println("========================安全调用")
    var b : String? = "abc"
    println(b?.length)
    b = null;
    println(b?.length);

    println("========================字符串测试")
    var str2 = "abc\n123" ;
    println(str2);  //abc和123不在同一行

    var str3 = """
        | 1 \n
        | 2
    """.trimIndent()
    println(str3) //\n字符原样输出

    println("========================运算符和表达式")

    var str4 = "abc.org" ;
    println(str4.contains("abc"))
    println("abc" in str4)
    println(!str4.contains("abc"));

    var list = java.util.ArrayList<String>()
    list.add("a")
    list.add("b")
    println(list.get(0)) //方法获取元素
    println(list[0]) //下标获取元素

    println("========================区间运算符")
    var rang1 = 2..6 //包含边界
    for(num in rang1) {
        println(num)
    }

    println("========================if分支结构")
    var ifTest : Int = 30;
    if(ifTest > 10) {
        println("if")
    }else {
        println("else")
    }

    if(ifTest < 10) {
        println("if")
    }else if(ifTest >= 10 && ifTest < 20) {
        println("else if")
    }else {
        println("else")
    }

    println("========================if语句可以作为表达式")
    var res = if(ifTest > 20) {
        "ifTest 大于20"
    }else {
        "ifTest 小于20"
    }
    println(res);

    println("========================when分支结构========================" +
            "when分支结构代替了java中的switch语句")
    var score = 'B'
    when (score) {
        'A' -> println("优秀")
        'B' -> println("良好")
        'C' -> println("中")
        'D' -> println("及格")
        else -> println("不及格")
    }

    println("========================when分支结构========================" +
            "when分支可以作为表达式的一部分")
    var whenStr = when(score) {
        'A' -> {
            println("优秀")
            "优秀"
        }
        'B' -> {
            println("良好")
            "良好"
        }
        'C' -> {
            println("中")
            "中"
        }
        'D' -> {
            println("及格")
            "及格"
        }
        else -> {
            println("不及格")
            "不及格"
        }
    }
    println(whenStr)

    println("========================when分支结构========================" +
            "when分支结合in,!in使用")
    val age = java.util.Random().nextInt(100);
    println(age)
    var inStr = when(age) {
        in 10..25 -> "当时年少青衫薄"
        in 26..50 -> "风景依稀似去年"
        in 51..100 -> "醉听清吟胜管弦"
        else -> "其他"
    }
    println(inStr)

    println("========================when分支结构========================" +
            "when分支处理类型")
    var inputPrice = 26
    println(realPrice(inputPrice))

    println("========================when分支结构========================" +
            "when分支可以替代if分支")
    println(age)
    var whenIf = when {
        age < 25 -> "当时年少青衫薄"
        age >= 25 && age < 50 -> "风景依稀似去年"
        age >= 51 -> "醉听清吟胜管弦"
        else -> "其他"
    }
    println(inStr)

    println("========================循环结构========================" +
            "while循环结构")
    var count = 0;
    while (count < 10) {
        println("count : ${count}")
        count++
    }
    println("while循环结束")

    println("========================循环结构========================" +
            "do-while循环结构")
    var doWhileCount = 0;
    do {
        println("count : ${count}")
        doWhileCount++;
    }while (doWhileCount < 10)

    println("doWhile循环结束")

    println("========================循环结构========================" +
            "for-in循环结构")
    var max = 7
    var result = 1
    for (num in 1..max) {
        result *= num
    }
    println(result)
    println("for-in循环结束")

    println("========================控制循环结构========================" +
            "break控制")

    for(i in 0..10) {
        println("i : ${i}")
        if(i == 2) {
            break; //遇到break立即跳出循环结构
        }
    }
    println("遇到break立即跳出循环")

    for(j in 5..10) {
        println("j : ${j}")

        for(i in 0..10) {
            println("i : ${i}")
            if(i == 2) {
                break; //遇到break立即跳出循环结构，只能跳出当前循环，不能跳出外层循环
            }
        }
    }
    println("遇到break立即跳出循环结构，只能跳出当前循环，不能跳出外层循环")

    outer@ for(j in 5..10) {
        println("j : ${j}")

        for(i in 0..10) {
            println("i : ${i}")
            if(i == 2) {
                break@outer; //带标号的break可以跳出外层循环
            }
        }
    }
    println("带标号的break可以跳出外层循环")

    println("========================控制循环结构========================" +
            "break控制")

    println("continue跳过本次循环继续进行下一次循环")
    for(i in 0..5) {
        println("i : ${i}")
        if(i == 2) {
            continue;
        }
        println("continue : ${i}")
    }

    println("continue跳过本次循环继续进行下一次循环")
    outer@ for(j in 1..5) {
        println("j : ${j}")

        for(i in 5..6) {
            println("i : ${i}")
            if(i == 6) {
                continue@outer;
            }
            println("continue : ${i}")
        }
    }


    println("========================控制循环结构========================" +
            "return控制")
    returnTest();
    println("遇到return 直接结束整个函数或方法，而不管return处于多少层循环之内")


}

fun returnTest() {

    for(j in 0..5) {
        println("j : ${j}")

        for(i in 5..10) {
            println("i : ${i}")
            if(i == 5) {
                return; //遇到return 直接结束整个函数或方法，而不管return处于多少层循环之内
            }
        }
    }
}

/**
 * when分支判断类型
 */
fun realPrice(inputPrice : Any) = when (inputPrice) {
    is String -> inputPrice.toDouble()
    is Int -> inputPrice.toDouble()
    is Double -> inputPrice.toDouble()
    else -> 0.0
}

