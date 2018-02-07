package com.zeek.test.spring.learn.controller;

import com.zeek.test.spring.learn.utils.CasServerUtil;
import com.zeek.test.spring.learn.viewmodel.login.LoginData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hello1")
public class HelloWorldController {

    private static String st = "" ;

    @RequestMapping(value = "/world1")
    public String helloWorld() {

        return "helloworld/helloworld";
    }

    @RequestMapping(value = "/world11")
    public String helloWorld11() {

        return "helloworld/helloworld11";
    }

    @RequestMapping(value = "/login1", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestBody(required = false) LoginData loginData) throws Exception {

        System.out.println(loginData);

        String serviceTicket = CasServerUtil.validateFromCAS("", "");

        return new LoginData("casuser", "Mellon");

    }


}
