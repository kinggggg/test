package com.zeek.test.spring.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/hello")
public class HelloWorldController {

    @RequestMapping(value = "/world")
    public String helloWorld() {

        return "helloworld/helloworld";
    }

}
