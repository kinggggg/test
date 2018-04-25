package com.zeek.test.spring.learn.controller;

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: weibo_li
 * @since: 2018-02-27 上午9:55
 */
@Controller
@RequestMapping(value = "/logout")
public class LogoutController {

    private final String CAS_CLIENT1_BASE_URL = "http://cas.client1.com:9090/" ;

    /**
     * 退出成功的界面
     */
    @RequestMapping("/logoutPage")
    public String logoutPage(){
        return "logout/logoutPage";
    }

    /**
     * 退出成功的界面
     */
    @RequestMapping("/logoutSuccess")
    public String logoutSuccess(HttpServletRequest httpRequest) throws Exception{
        Request request = Request.Get(CAS_CLIENT1_BASE_URL + "api/cookieRemove");
        Response response = request.execute();
        try {
            response.discardContent();
        }catch (Exception e) {
            // FIXME: 2018/4/25 需要处理错误
        }

        return "logout/logoutSuccessPage";
    }
}
