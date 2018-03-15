package com.zeek.test.spring.learn.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zeek.test.spring.learn.domain.User;
import org.apache.http.client.fluent.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author weibo_li
 */
@Controller
@RequestMapping(value = "/")
public class TestController {

    private final String CAS_CLIENT1_BASE_URL = "http://cas.client1.com:8888/" ;

    @RequestMapping(value = "/api/list", method = RequestMethod.GET)
    public String jsonData(HttpServletRequest httpRequest) throws Exception {

        String st = httpRequest.getParameter("ticket");

        Request request = Request.Get(CAS_CLIENT1_BASE_URL + "api/list?ticket=" + st);
        String resultJson = request.execute().returnContent().asString();
        List<User> users = new Gson().fromJson(resultJson, new TypeToken<List<User>>() {
        }.getType());

        return "api/list";

    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String loginPage() throws Exception {

        return "login/loginPage";

    }

}
