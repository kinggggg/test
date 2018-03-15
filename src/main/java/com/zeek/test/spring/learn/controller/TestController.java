package com.zeek.test.spring.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author weibo_li
 */
@Controller
@RequestMapping(value = "/")
public class TestController {

    private final String CAS_CLIENT1_BASE_URL = "http://cas.client1.com:8888/" ;

    @RequestMapping(value = "/jsonData", method = RequestMethod.GET)
    public String jsonData() throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(CAS_CLIENT1_BASE_URL+"api/list", )

        return null;

    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String loginPage() throws Exception {

        return "login/loginPage";

    }

}
