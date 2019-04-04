package com.zeek.test.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hello")
//在这里开启SpringBoot的异步处理支持，也是可以的；根据规范最好是在一个专门的配置类上进行配置，例如https://blog.csdn.net/oo570741825/article/details/77768178
@EnableAsync
public class HelloWorldController {

    @RequestMapping(value = "/world")
    @ResponseBody
    //这个注解标记的方法，为异步方法，SpringBoot会通过其他的线程进行处理；通过浏览器访问这个接口，浏览器中不会有任何输出，因为这个请求已经被其他的线程进行处理了
    @Async
    public String helloWorld() {

        System.out.println(Thread.currentThread().getName());

        return "helloworld";
    }

    @RequestMapping(value = "/world2")
    @ResponseBody
    //这个方法没有使用@Async注解，即使在controller类上标注了@EnableAsync，这个方法也是同步方法而不是异步方法；通过浏览器访问这个方法，浏览器会输出helloworld
    public String helloWorld2() {

        System.out.println(Thread.currentThread().getName());

        return "helloworld";
    }

}
