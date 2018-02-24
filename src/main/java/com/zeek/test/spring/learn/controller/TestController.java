package com.zeek.test.spring.learn.controller;

import com.google.gson.Gson;
import com.zeek.test.spring.learn.domain.User;
import com.zeek.test.spring.learn.utils.CasLoginData;
import com.zeek.test.spring.learn.utils.CasServerUtil;
import com.zeek.test.spring.learn.utils.HttpClient;
import com.zeek.test.spring.learn.utils.HttpMethod;
import com.zeek.test.spring.learn.viewmodel.login.LoginData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author weibo_li
 */
@Controller
@RequestMapping(value = "/")
public class TestController {

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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void login(HttpServletResponse httpServletResponse) throws Exception {

        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.sendRedirect("https://cas.server.com:8443/cas/login");
    }

    @RequestMapping(value = "/login_bak", method = RequestMethod.POST)
    public String loginBak(@RequestBody(required = false) LoginData loginData) throws Exception {

        System.out.println(loginData);

        String serviceTicket = CasServerUtil.validateFromCAS("", "");

        return "redirect:" + "http://hello1.com:8383/sso1/test/list?ticket=" + serviceTicket;

    }

    @RequestMapping(value = "/login_bak", method = RequestMethod.GET)
    public void login(@RequestBody(required = false) LoginData loginData, HttpServletResponse httpResponse) throws Exception {

        System.out.println(loginData);

//        String serviceTicket = CasServerUtil.validateFromCAS("", "");

        CasLoginData casLoginData = new CasLoginData("casuser", "Mellon", "submit", "291ee015-6726-4942-bcee-f0bd8df60774_ZXlKaGJHY2lPaUpJVXpVeE1pSjkuVjFaSmNuSnZORk01U0dGd2JtSnFkMjlWWkdOeFozRjJPWHByU1RCTFVtWjJNbE5xTkdGdk5uVlBZaTgxUW14MGVFRXZTa3MxYTJGYU5qZFRkV2RDV1RsV1JUVXpOV2haTW1kdloxWTVlVzVYVkhsR05IVlVRVXBNUkRjeFpFeEZVRVZNY1doaGNsZFhhMVV5YmpGeVVreG5Ta1JqTkdnd05teHBiR1pOVDBKdVMwNVFhV3h6TWtRMFIyY3hVbWt2ZGtoSU9VeFVjMk5rWlRoWlFrbHBUR1ZzYUVKbVYwMTRjSG93U0hndlJUZFNORkJhZDI5d2RHeFVjMVpDUzJKdllsRjFaRXAyVW13eFRpOW1MM2hQUWpCWGNqbDNlVmgzWW0xNFJUZGlkMjFMUVVKNFJUVm1VRmN2WkVScU1HdG9XRTlqVGl0RFlXSlBMM0JEUjB4Q1ZVSlJPRTFXUlhSRVZEZHlkekVyYkdVdmMwTlVka293ZDBSMWIzWjBXbUpuYUVkWFJFZHNSM2xNZVhaUk5ITlpXVmRSU0VseE1rMW1iVEJQY1VneFEzaERSV0ZxUm5ob1RESm5RMll2SzNrMFRFdEpkREJHWjA4MlZGZzFVaXQzTlhsVVdFTjFUSE5yZVdoYVMxTXdNRFYyVDFkaVRGcEJTRlIyZDFaUFlVRkZZMGxGVWpaVFMwdHRZbTlyY0dGcEwwSlhTMDQ1WkhaQllsZHFiekIwYVV4bVUyOUhhMVJFVUdwWk1VRnhRakkwYVVvdlkwa3hNWE5UY1hORWVuQlNjV3RGZDBvM2VEZ3lObWhSVkZGcWNYaFllWFkyTWxoR1FYaFRZbUYzTHpOUGNtbzFZMGxpYlhORlNXWkJWV1YwV0RsQlp5OXRZWEZwZHpsaVFtcHJlVVJVTDBOQ2R6QkZVRlowUXpSVU4wSk9VMHB3TVU1VWRtVnNNVlJNY25wNVEwZHJNRFZ6VEZsMWNFRldPRGwxZEZwM1ZrRjBNMWRIZEVSUVYxbHdNVU5LZGpWbWJrWm5PSGRJZHpSWk4wNTRXWGxvVjB0NVZ5OTJNMWRxU0hOVWRHNXdSbkZKVm5vMVV6VlhUMDUyT0d0SGVqVndjRzl1V0VGaGJFWk1UQ3RyYWt4SVVURldjM0UzY3pkTFYxUlNPRlUyUzFCV1JHNU1OR2RQYkRGSWVFTm9jbkZuUTBNNVdHRnJkak1yVVdkc05uTjRkbmhHTVdkWVYxaE1MMWx0TVU0NFYwTXJkemx3TmxOUGFucDJhbkJQVlZKbVVVaEJMMVpNTlRaTmQzVjZVa2ROT0dSbmFFMUZkbmxOUm5vNVFtTlJiVVJNV1VZdkwyRkhia3A0YjJKQlEwSnhURlJhS3pKV2VuTjRkMFUzTkZOak0xa3hjemhNTjJNM1RuRmpkMWhMT1Rockt6SnpOVmhNZEZwWVVWRmhRMlZDU0ZwUllsWnhNRnA1TlRWS00yUlVhRlYzVDJ4blRqZzFTVEJtUnpjNVVrNTFWalpQTldadlprNU9hMVZJU3paVlpubExjMHgwWmpKeFFrRllUMHhXVmxCV1FWRmthRUkzVVVaRVZGaENPRVV3YVZGV1dXcElTSFo0V1VFd05VNTBOVVZMUkZBemRsWnBVblZ0TkhrMVZ6VXdlbWM1YjNodE0xa3hXa2N4Um0xTk1pOWhkREp2Ym5wQk5GRXliVEYyU0N0RVJXc3djVEJFZVdzclNEWXpVV1J0YWtsMVFVSnViVkpwT0RRMGJtTlZNWFpaU1VVMFFuTkNVVXhrTW1kTmFuaEZOREZNTkdKblRXcHdSRXREUlhOeGJXaEhZVzVQZFN0Q1EwNTVObU5QSzI1VFRHbzNXRzlHVkVGVVR6RlVabXR2VW04eE1WTjFTWHBPWldKUVpVUnFNa1ZXTVRsMFEzQTBkaTl4T0RGbmFYWlFPVzVxZDA5U1QybHZkMlZ1UTNaTGRFTm1VV1ZyUW0xbGNubGxLMnBZYlVaT1lWVjVjbkppU0VoUVFrdHdZbTQzWW00ck1XMW1iRTFMWW1sNGVFOTFielJLYzJWcFIwUTJNRWx5VkRCb00wMXhObmRwT1dKelEwTkRNa0p3YlhkVFltVjVNVkkwU1RSb1pESXdXREV2Y0haNU1Vb3llbEo1WW10UE5tMHlMM0JyZVc4eWVHWmljR0p0V1ZsU1lVRTlQUS5hbWpVdm5ydEFOdm5PbDg4bjJ5T25rUV9KNXJaeHh1OXZ1U3hHWkNTWmh2RC12bTRoSFl3dVR1TWNqeXdrNW5TXzZ3VlhRcVpJQ1RYbm1Qbk9Wc2tkdw==");
        org.apache.http.cookie.Cookie casCookie = HttpClient.httpRequest2("", casLoginData, HttpMethod.Post);

        Cookie cookie = new Cookie(casCookie.getName(), casCookie.getValue());
        cookie.setPath(casCookie.getPath());
        cookie.setSecure(casCookie.isSecure());
        cookie.setDomain("server.com");
        cookie.setHttpOnly(true);

        httpResponse.addCookie(cookie);

//        String serviceTicket = CasServerUtil.validateFromCAS("", "");
//
//        return "redirect:" + "http://hello1.com:8383/sso1/test/list?ticket=" + serviceTicket;

    }

    private final static String CAS_LOGIN_URL = "https://yellowcong.com:8443/cas/login";
    private final static String APP_URL = "http:///hello1.com:8383/hello1/world1";

    @RequestMapping(value="/restLogin2", method = RequestMethod.POST)
    public void restLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {

        CasLoginData casLoginData = new CasLoginData("casuser", "Mellon", "submit", "9ca56548-ac0d-4bef-9fbc-d550f48f3902_ZXlKaGJHY2lPaUpJVXpVeE1pSjkuYjBJME9IQnNhbVp1VEhSUWVHNXJialowVjNNdlpFNDVUemd3VEhkUFlrWmxiVzFMT0ZWSlRYUmFWMmx3VjJ0aFFUQkNWbVJqU1hOb0wyNWlVSEZIWlVkemFTOUNNbVJZT1dsaGJGaENaelI2ZFVzd01rUldlRGhFUms1WE5WaFRlVlJMY1c5aWExTnVPVEV5U2taVFZTdE1WWGwxWkRkRVZ6TkZkMFpRUm5GTk1tNTZUelpJVGpsUVkwbDFXVmhTU1ZCUVFtRkljekpzV1ZSR1VpdHhUemN4Y1dOaE5WQldiakJ0Y1ZwNWJUbDZNa1ZaY0hkVWVtcEVTbU12Y2k5d1lVUmFaMnAyY3pGTWNqQnFZekV2UlVwclNXMTVXRTF1VkhGWkt6Sllka3d4U1ZsaWVEWTJhVXhEZEdwSGFtVTJhMHgzYm5CRFZURnhMMGhCTHpZdk5IQnBlbTVIVDNWR1RTOWlSRGxSWTI5MFJ6QnpNbWhITTFkeFpITXJkelJtWVdNNFVsRjJSVTFYU2pJclkzbHhNRVIxZUhORVRISjJVMjVpVFhGdmVGbG5jR1I0ZVVaV01GQmtNSGg1V201bWNFSXhRMkoxUlZnNGFWSmxLMWwzYzFVeVlscHdTRXh1WVRaS1Jsb3piRlkxSzBsNGNIWTVaRnAxVFN0V1ZuVmlaalZwZHpKWlFrbDZUek4wYURVckwwUndTV0ZJTTJweWRTdG9aR0VyTkVVeFJXNDJZa1pYTlVKR2Exb3JSa1Z0WlU1a1puYzJXblJ2WjNsNE9IUk9ibUZLZWtwWE1XVllZVGg0UzBaSFRIUklTMk5ES3pJNU1XaGlVekJ2TVdKMVluRkhkVXRpU1V0dWVERjRjbHByWlROSmVYVXhOMFkwUVRaNGNFbHdOR0pWVFZwUlpTOXZZV2RoWkZsNlRFTlhVMDlLY1ZkVVJqVjVLMU5wUWsxMk1tbGtUeTlKVmtscVRIVXlVR1ZuTUVwNmFEZGxVVmN3ZWpKR1kwVTBPVFpKYWpCaVpGTm1VRFJXZWxFMVNrMDFTakpYUkZWUFEydEVlRGhQTTFGMldVczBTSEpCYW5GeGRUZDVWMDQzWTNKbVR6QmxiMDV5Y21oell6WTFkbVpzT1ZCbWNGa3lhRVpRTm1oa2RXdzFkVkZ4Tm5ablVtbG9lSHBrTkVwRGFuQklZbUpQYTJsM1dVaEVOV2xXWkVSS2EwTnBSeXRYYjI5S1NVNVBVVEprVjNSUVRIaFRTRTFYYm5WWFFVSjRUbGhaVjNSRUszbENjVzlCYzNaNVlYaFJTbWR5ZURWVGVuZEdaMnhtU1hKd1MxcFNXa0YzUTNNeGNVOXlZMFZxVVhWS1p6TTNPWEJqVXpkQmMxWk1lbUY2TjJ4M1RtTlNjalZXTW01SFMyTklTRTVPYkdGUGEwbHlUWFV3VDBGRFUybGFSVlpWWlZSVmRua3hjbkJsUlZod05HTm5LM2hyWWpKNmJEbEhLeXRwWkV3clREVkxhRU5qYzFGMFozTmFUek5qU0ZOb1prUXZVWGhtSzI5a2VsaEdLemwyV2pBelF5dENkMmxKY25sS1pUTmlRWFZ2TDFWM1FWUnViV052V1VkTGFsQkNSRTFSYlc1cWFHTjBkbGxET0hwU1FUZ3hWVzQzVkVWdGJ5dFRkMjlNWW1WUlYxRkhkSFJJVW5SV1lsQldTM2RtVEcxUVZGUm5OR2hxTTBwSVdVSk1WMmRVTTJWRVUwbGpTRVZPV0dwSk1Vc3ZWMlpDVlhwaGRqSnJjbEJTWlhSRU5VeDJORmQyUjI1Mk0xWTJiVFo0VldoRmMyaEJZVWhsYTJzekx6RjJVMXBoVGxFOVBRLmZmdmFaQm5BRWRDVGh6dmxocDZTaV95SG0xWTc1RExSWWUxdHp1M2s4Ty1aaUlhRFNqSmJybkdTZ0dwZlA3eFhZazhKeHU2MC1yTTRSYVU5aTIwNGNB");

        Gson gson = new Gson();
        String requestJson = gson.toJson(casLoginData) ;

        HttpClient.httpRequest(CAS_LOGIN_URL, requestJson, HttpMethod.Post);

        HttpClient.httpRequest2("", casLoginData, HttpMethod.Post);


    }


}
