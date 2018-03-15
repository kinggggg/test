package com.zeek.test.spring.learn.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zeek.test.spring.learn.domain.Book;
import com.zeek.test.spring.learn.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.fluent.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String jsonData(HttpServletRequest httpRequest, Model model) throws Exception {

        String st = httpRequest.getParameter("ticket");
        Request request;
        if(StringUtils.isBlank(st)) {
            request = Request.Get(CAS_CLIENT1_BASE_URL + "api/list");
        }else {
            request = Request.Get(CAS_CLIENT1_BASE_URL + "api/list?ticket=" + st);
        }
        String resultJson = request.execute().returnContent().asString();
        List<User> users = new Gson().fromJson(resultJson, new TypeToken<List<User>>() {
        }.getType());

        model.addAttribute("users", users);

        return "api/list";

    }

    @RequestMapping(value = "/api/books", method = RequestMethod.GET)
    public String apiBooks(HttpServletRequest httpRequest, Model model) throws Exception {

        String st = httpRequest.getParameter("ticket");
        Request request = Request.Get(CAS_CLIENT1_BASE_URL + "api/books");

        String resultJson = request.execute().returnContent().asString();
        List<Book> books = new Gson().fromJson(resultJson, new TypeToken<List<Book>>() {
        }.getType());

        model.addAttribute("books", books);

        return "api/books";

    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String loginPage() throws Exception {

        return "login/loginPage";

    }

}
