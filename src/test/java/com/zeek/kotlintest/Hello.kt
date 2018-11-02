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





}

