package com.zeek.test.spring.learn.controller;

import com.zeek.test.spring.learn.utils.CasServerUtil;
import com.zeek.test.spring.learn.viewmodel.login.LoginData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
