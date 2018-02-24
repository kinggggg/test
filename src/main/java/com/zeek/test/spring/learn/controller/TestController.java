package com.zeek.test.spring.learn.controller;

import com.google.gson.Gson;
import com.zeek.test.spring.learn.domain.User;
import com.zeek.test.spring.learn.utils.CasLoginData;
import com.zeek.test.spring.learn.utils.CasServerUtil;
import com.zeek.test.spring.learn.utils.HttpClient;
import com.zeek.test.spring.learn.utils.HttpMethod;
import com.zeek.test.spring.learn.viewmodel.login.ExecutionData;
import com.zeek.test.spring.learn.viewmodel.login.LoginData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author weibo_li
 */
@Controller
@RequestMapping(value = "/")
public class TestController {

    private final static String APP_URL = "http:///cas.client1.com:8383/api/list";

    @RequestMapping(value = "/api/list", method = RequestMethod.GET)
    @ResponseBody
    public Object apiList() {

        User user1 = new User("xiaoming", 18);
        User user2 = new User("xiaohong", 20);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        return users;
    }

    @RequestMapping(value = "/execution", method = RequestMethod.GET)
    @ResponseBody
    public Object getExecution(HttpServletResponse httpServletResponse) throws Exception {

        String execution = CasServerUtil.getExecution(APP_URL);

        ExecutionData executionData = new ExecutionData();
        executionData.setExecution(execution);

        return executionData;

    }

    @RequestMapping(value = "/redirect", method = RequestMethod.POST)
    public String redirect(@RequestBody(required = false) LoginData loginData) throws Exception {

        System.out.println(loginData);

        String serviceTicket = CasServerUtil.validateFromCAS();

        return "redirect:" + APP_URL + "?ticket=" + serviceTicket;

    }

    @RequestMapping(value = "/loginCookie", method = RequestMethod.GET)
    public void loginCookie(@RequestBody(required = false) LoginData loginData, HttpServletResponse httpResponse) throws Exception {

        System.out.println(loginData);

        org.apache.http.cookie.Cookie casCookie = CasServerUtil.getCasServerCookieByHttpClientCall();

        Cookie cookie = new Cookie(casCookie.getName(), casCookie.getValue());
        cookie.setPath(casCookie.getPath());
        cookie.setSecure(casCookie.isSecure());
        cookie.setDomain("server.com");
        cookie.setHttpOnly(true);

        httpResponse.addCookie(cookie);

    }
}
