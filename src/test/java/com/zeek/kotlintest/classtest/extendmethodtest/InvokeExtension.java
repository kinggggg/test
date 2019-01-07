package com.zeek.kotlintest.classtest.extendmethodtest;

/**
 * @ClassName InvokeExtension
 * @Description 在java代码中调用kotlin中定义的扩展方法
 * @Author liweibo
 * @Date 2019/1/7 下午12:43
 * @Version v1.0
 **/
public class InvokeExtension {

    public static void main(String[] args) {

        Raw t = new Raw();
        //调用成员方法
        t.test();
        //调用Raw对象的扩展方法，需要自己解析成调用扩展函数
        Raw_infoKt.info(t);

        RawSub rawSub = new RawSub();
        rawSub.test();
        rawSub.sub();
        //调用Raw对象的扩展方法，需要自己解析成调用扩展函数
        Raw_infoKt.info(rawSub);
    }
}
