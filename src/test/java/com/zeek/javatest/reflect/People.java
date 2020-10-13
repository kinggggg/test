package com.zeek.javatest.reflect;

import lombok.SneakyThrows;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2020-09-29
 */
@Foo(name = "old.name")
public class People {

    public static final String name = new String("zhangsan") ;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

//        System.out.println(People.name);
//
//        Class<People> peopleClass = People.class;
//        Field name = peopleClass.getDeclaredField("name");
//        name.setAccessible(true);
//        Field modifiers = name.getClass().getDeclaredField("modifiers");
//        modifiers.setAccessible(true);
//        modifiers.setInt(name, name.getModifiers() & ~Modifier.FINAL);
//
//        name.set(null, "lisi");
//        System.out.println(People.name);

        Class<People> peopleClass = People.class;
        Foo foo = peopleClass.getAnnotation(Foo.class);
        System.out.println(foo.name());

        InvocationHandler invocationHandler = Proxy.getInvocationHandler(foo);
        Field declaredField = invocationHandler.getClass().getDeclaredField("memberValues");
        declaredField.setAccessible(true);
        Map memberValues = (Map) declaredField.get(invocationHandler);
        memberValues.put("name", "new.name");
        String newValue = foo.name();
        System.out.println("修改之后的注解值：" + newValue);

    }
}
