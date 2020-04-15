package com.zeek.java8.shengsiyuan;

import java.util.Optional;

/**
 * @ClassName OptionalTest
 * @Description
 * @Date 2019/10/22 4:08 PM
 * @Version v1.0
 **/
public class OptionalTest {

    public static void main(String[] args) {

//        Optional<String> optional = Optional.of("hello");
//        Optional<String> optional = Optional.empty();
        Optional<String> optional = Optional.ofNullable("hello");

        // 虽然可以直接调用get方法，但是如果optional为null的话，直接调用get会抛出异常
//        System.out.println(optional.get());

        // 和原来的方式先判断null再使用的方式其实使用一样的，不建议使用
//        if (optional.isPresent()) {
//            System.out.println(optional.get());
//        }

        // 应该使用这种方式使用Optional
        // 当optional中的值存在时才进行值的操作，这里是输出操作
        optional.ifPresent(item -> System.out.println(item));

        // 当optional中的值不存在时使用其他的值，这里其他的值为world
        System.out.println(optional.orElse("world"));

        // 当optional中的值不存在时使用提供给orElseGet方法参数的Supplier进行获取
        System.out.println(optional.orElseGet(() -> "你好"));

    }
}
