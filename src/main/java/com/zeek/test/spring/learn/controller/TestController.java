package com.zeek.test.spring.learn.controller;

import com.google.gson.Gson;
import com.zeek.test.spring.learn.utils.CasLoginData;
import com.zeek.test.spring.learn.utils.CasServerUtil;
import com.zeek.test.spring.learn.utils.HttpClient;
import com.zeek.test.spring.learn.utils.HttpMethod;
import com.zeek.test.spring.learn.viewmodel.login.LoginData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/sso1")
public class TestController {

    @RequestMapping(value = "/test/list", method = RequestMethod.GET)
    public String testList() {

        return "test/list";
    }

    @RequestMapping(value = "/test/list2", method = RequestMethod.GET)
    public String testList2() {

        return "test/list2";
    }

    @RequestMapping(value = "/login_bak", method = RequestMethod.POST)
    public String loginBak(@RequestBody(required = false) LoginData loginData) throws Exception {

        System.out.println(loginData);

        String serviceTicket = CasServerUtil.validateFromCAS("", "");

        return "redirect:" + "http://hello1.com:8383/sso1/test/list?ticket=" + serviceTicket;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void login(@RequestBody(required = false) LoginData loginData, HttpServletResponse httpResponse) throws Exception {

        System.out.println(loginData);

//        String serviceTicket = CasServerUtil.validateFromCAS("", "");

        CasLoginData casLoginData = new CasLoginData("casuser", "Mellon", "submit", "9ca56548-ac0d-4bef-9fbc-d550f48f3902_ZXlKaGJHY2lPaUpJVXpVeE1pSjkuYjBJME9IQnNhbVp1VEhSUWVHNXJialowVjNNdlpFNDVUemd3VEhkUFlrWmxiVzFMT0ZWSlRYUmFWMmx3VjJ0aFFUQkNWbVJqU1hOb0wyNWlVSEZIWlVkemFTOUNNbVJZT1dsaGJGaENaelI2ZFVzd01rUldlRGhFUms1WE5WaFRlVlJMY1c5aWExTnVPVEV5U2taVFZTdE1WWGwxWkRkRVZ6TkZkMFpRUm5GTk1tNTZUelpJVGpsUVkwbDFXVmhTU1ZCUVFtRkljekpzV1ZSR1VpdHhUemN4Y1dOaE5WQldiakJ0Y1ZwNWJUbDZNa1ZaY0hkVWVtcEVTbU12Y2k5d1lVUmFaMnAyY3pGTWNqQnFZekV2UlVwclNXMTVXRTF1VkhGWkt6Sllka3d4U1ZsaWVEWTJhVXhEZEdwSGFtVTJhMHgzYm5CRFZURnhMMGhCTHpZdk5IQnBlbTVIVDNWR1RTOWlSRGxSWTI5MFJ6QnpNbWhITTFkeFpITXJkelJtWVdNNFVsRjJSVTFYU2pJclkzbHhNRVIxZUhORVRISjJVMjVpVFhGdmVGbG5jR1I0ZVVaV01GQmtNSGg1V201bWNFSXhRMkoxUlZnNGFWSmxLMWwzYzFVeVlscHdTRXh1WVRaS1Jsb3piRlkxSzBsNGNIWTVaRnAxVFN0V1ZuVmlaalZwZHpKWlFrbDZUek4wYURVckwwUndTV0ZJTTJweWRTdG9aR0VyTkVVeFJXNDJZa1pYTlVKR2Exb3JSa1Z0WlU1a1puYzJXblJ2WjNsNE9IUk9ibUZLZWtwWE1XVllZVGg0UzBaSFRIUklTMk5ES3pJNU1XaGlVekJ2TVdKMVluRkhkVXRpU1V0dWVERjRjbHByWlROSmVYVXhOMFkwUVRaNGNFbHdOR0pWVFZwUlpTOXZZV2RoWkZsNlRFTlhVMDlLY1ZkVVJqVjVLMU5wUWsxMk1tbGtUeTlKVmtscVRIVXlVR1ZuTUVwNmFEZGxVVmN3ZWpKR1kwVTBPVFpKYWpCaVpGTm1VRFJXZWxFMVNrMDFTakpYUkZWUFEydEVlRGhQTTFGMldVczBTSEpCYW5GeGRUZDVWMDQzWTNKbVR6QmxiMDV5Y21oell6WTFkbVpzT1ZCbWNGa3lhRVpRTm1oa2RXdzFkVkZ4Tm5ablVtbG9lSHBrTkVwRGFuQklZbUpQYTJsM1dVaEVOV2xXWkVSS2EwTnBSeXRYYjI5S1NVNVBVVEprVjNSUVRIaFRTRTFYYm5WWFFVSjRUbGhaVjNSRUszbENjVzlCYzNaNVlYaFJTbWR5ZURWVGVuZEdaMnhtU1hKd1MxcFNXa0YzUTNNeGNVOXlZMFZxVVhWS1p6TTNPWEJqVXpkQmMxWk1lbUY2TjJ4M1RtTlNjalZXTW01SFMyTklTRTVPYkdGUGEwbHlUWFV3VDBGRFUybGFSVlpWWlZSVmRua3hjbkJsUlZod05HTm5LM2hyWWpKNmJEbEhLeXRwWkV3clREVkxhRU5qYzFGMFozTmFUek5qU0ZOb1prUXZVWGhtSzI5a2VsaEdLemwyV2pBelF5dENkMmxKY25sS1pUTmlRWFZ2TDFWM1FWUnViV052V1VkTGFsQkNSRTFSYlc1cWFHTjBkbGxET0hwU1FUZ3hWVzQzVkVWdGJ5dFRkMjlNWW1WUlYxRkhkSFJJVW5SV1lsQldTM2RtVEcxUVZGUm5OR2hxTTBwSVdVSk1WMmRVTTJWRVUwbGpTRVZPV0dwSk1Vc3ZWMlpDVlhwaGRqSnJjbEJTWlhSRU5VeDJORmQyUjI1Mk0xWTJiVFo0VldoRmMyaEJZVWhsYTJzekx6RjJVMXBoVGxFOVBRLmZmdmFaQm5BRWRDVGh6dmxocDZTaV95SG0xWTc1RExSWWUxdHp1M2s4Ty1aaUlhRFNqSmJybkdTZ0dwZlA3eFhZazhKeHU2MC1yTTRSYVU5aTIwNGNB");
        org.apache.http.cookie.Cookie casCookie = HttpClient.httpRequest2("", casLoginData, HttpMethod.Post);

        Cookie cookie = new Cookie(casCookie.getName(), casCookie.getValue());
        cookie.setPath(casCookie.getPath());
        cookie.setSecure(casCookie.isSecure());
        httpResponse.addCookie(cookie);

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
