package com.zeek.test.spring.learn.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zeek.test.spring.learn.common.FailureResponse;
import com.zeek.test.spring.learn.common.ResponseViewModel;
import com.zeek.test.spring.learn.domain.Book;
import com.zeek.test.spring.learn.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.fluent.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author weibo_li
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private final String CAS_CLIENT1_BASE_URL = "http://cas.client1.com:9090/";

    @RequestMapping(value = "/ssoLogin", method = RequestMethod.GET)
    public String ssoLogin(HttpServletRequest httpRequest, Model model) throws Exception {

        String st = httpRequest.getParameter("ticket");
        //当前接口的路径/login/ssoLogin, 一定要与后端接口的路径/login/ssoLogin一样！
        Request request = Request.Get(CAS_CLIENT1_BASE_URL + "login/ssoLogin?ticket=" + st);

        String resultJson = "" ;
        try {
            resultJson = request.execute().returnContent().asString();
            ResponseViewModel viewModel = new Gson().fromJson(resultJson, new TypeToken<ResponseViewModel>() {
            }.getType());
            if(viewModel.getResult().getCode() == 0) {
                return "login/loginSuccessPage";
            }
        } catch (Exception e) {

            //ST验证失败
            /*FailureResponse failureResponse = new Gson().fromJson(resultJson, new TypeToken<FailureResponse>() {
            }.getType());
            if(failureResponse.getResult().getErrorMessages() != null && !failureResponse.getResult().getErrorMessages().contains("ST无效")) {
                return "login/loginSuccessPage";
            }*/
            e.printStackTrace();
        }

        return "login/loginErrorPage";

    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String loginPage() throws Exception {

        return "login/loginPage";

    }

}
