package com.zeek.test.spring.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author weibo_li
 */
@Controller
@RequestMapping(value = "/")
public class TestController {

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String redirect() throws Exception {

        return "login/loginPage";

    }

}
