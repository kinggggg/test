package com.zeek.test.spring.learn.controller;

import com.zeek.test.spring.learn.utils.CasServerUtil;
import com.zeek.test.spring.learn.viewmodel.login.LoginData;
import org.pac4j.cas.client.rest.CasRestFormClient;
import org.pac4j.cas.config.CasConfiguration;
import org.pac4j.cas.profile.CasProfile;
import org.pac4j.cas.profile.CasRestProfile;
import org.pac4j.core.context.J2EContext;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.credentials.TokenCredentials;
import org.pac4j.core.credentials.UsernamePasswordCredentials;
import org.pac4j.core.exception.HttpAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

@Controller
@RequestMapping(value = "/login1")
public class LoginController {

    private static String st = "" ;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String login(@RequestBody(required = false) LoginData loginData) throws Exception {

        System.out.println(loginData);

        String serviceTicket = CasServerUtil.validateFromCAS();

        return "redirect:" + "http://hello1.com:8383/hello1/world1?ticket=" + serviceTicket;


    }

    private final static String CAS_LOGIN_URL = "https://cas.server.com:8443/cas/login";
    private final static String APP_URL = "http:///cas.client1.com:8383/api/list";

    @RequestMapping(value="/restLogin", method = RequestMethod.POST)
    public void restLogin(HttpServletRequest request, HttpServletResponse response) {
        final CasConfiguration casConfiguration = new CasConfiguration(CAS_LOGIN_URL);
        CasRestFormClient client = new CasRestFormClient();
        client.setConfiguration(casConfiguration);

        WebContext webContext = new J2EContext(request, response);

        try {
            UsernamePasswordCredentials credentials = client.getCredentials(webContext);
            CasRestProfile profile = client.getUserProfile(credentials, webContext);
            TokenCredentials casCreds = client.requestServiceTicket(CAS_LOGIN_URL, profile, webContext);
            CasProfile casProfile = client.validateServiceTicket(CAS_LOGIN_URL, casCreds, webContext);
            String redirectUrl=CAS_LOGIN_URL+"?service="+APP_URL+"&tgc="+profile.getTicketGrantingTicketId();
            response.sendRedirect(redirectUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
