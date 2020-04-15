package com.zeek.javatest.annotation.test;

import java.lang.annotation.*;

/**
 * @author: weibo_li
 * @since: 2018-06-11 下午3:00
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface FruitName {

    public String name() default "";
}
