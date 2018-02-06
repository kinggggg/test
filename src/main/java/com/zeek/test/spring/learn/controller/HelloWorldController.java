package com.zeek.test.spring.learn.controller;

import com.zeek.test.spring.learn.viewmodel.login.LoginData;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hello1")
public class HelloWorldController {

    @RequestMapping(value = "/world1")
    public String helloWorld() {

        return "helloworld/helloworld";
    }

    @RequestMapping(value = "/login1", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestBody(required = false) LoginData loginData) {

        System.out.println(loginData);

//        return new LoginData(loginData.getUsername(), loginData.getPassword());
        return new LoginData("casuser", "Mellon");


    }

}
