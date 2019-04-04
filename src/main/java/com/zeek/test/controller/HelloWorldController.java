package com.zeek.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hello")
public class HelloWorldController {

    @RequestMapping(value = "/world")
    @ResponseBody
    public String helloWorld() {

        return "helloworld";
    }

}
