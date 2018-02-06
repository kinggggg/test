package com.zeek.test.spring.learn.controller;

import com.zeek.test.spring.learn.viewmodel.login.LoginData;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

@Controller
@RequestMapping(value = "/hello1")
public class HelloWorldController {

    @RequestMapping(value = "/world1")
    public String helloWorld() {

        return "helloworld/helloworld";
    }

    @RequestMapping(value = "/world11")
    public String helloWorld11() {

        return "helloworld/helloworld11";
    }

    @RequestMapping(value = "/login1", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestBody(required = false) LoginData loginData) throws Exception {

        System.out.println(loginData);

        validateFromCAS("", "");

//        return new LoginData(loginData.getUsername(), loginData.getPassword());
        return new LoginData("casuser", "Mellon");


    }

    public static boolean validateFromCAS(String username, String password) throws Exception {

        String url = "https://yellowcong.com:8443/cas/v1/tickets";
        try {
            HttpsURLConnection hsu = (HttpsURLConnection) openConn(url);
            String s = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode("casuser", "UTF-8");
            s += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode("Mellon", "UTF-8");

            System.out.println(s);
            OutputStreamWriter out = new OutputStreamWriter(hsu.getOutputStream());
            BufferedWriter bwr = new BufferedWriter(out);
            bwr.write(s);
            bwr.flush();
            bwr.close();
            out.close();

            String tgt = hsu.getHeaderField("location");
            System.out.println(hsu.getResponseCode());
            if (tgt != null && hsu.getResponseCode() == 201) {
                System.out.println(tgt);

                System.out.println("Tgt is : " + tgt.substring(tgt.lastIndexOf("/") + 1));
                tgt = tgt.substring(tgt.lastIndexOf("/") + 1);
                bwr.close();
                closeConn(hsu);


                String serviceURL = "http://hello1.com:8383/hello1/world1";
                String encodedServiceURL = URLEncoder.encode("service", "utf-8") + "=" + URLEncoder.encode(serviceURL, "utf-8");
                System.out.println("Service url is : " + encodedServiceURL);


                String myURL = url + "/" + tgt;
                System.out.println(myURL);
                hsu = (HttpsURLConnection) openConn(myURL);
                out = new OutputStreamWriter(hsu.getOutputStream());
                bwr = new BufferedWriter(out);
                bwr.write(encodedServiceURL);
                bwr.flush();
                bwr.close();
                out.close();

                System.out.println("Response code is:  " + hsu.getResponseCode());

                BufferedReader isr = new BufferedReader(new InputStreamReader(hsu.getInputStream()));
                String line;
                System.out.println(hsu.getResponseCode());
                while ((line = isr.readLine()) != null) {
                    System.out.println(line);
                }
                isr.close();
                hsu.disconnect();
                return true;

            } else {
                return false;
            }


        } catch (MalformedURLException mue) {
            mue.printStackTrace();
            throw mue;

        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw ioe;
        }


    }

    static URLConnection openConn(String urlk) throws MalformedURLException, IOException {

        URL url = new URL(urlk);
        HttpsURLConnection hsu = (HttpsURLConnection) url.openConnection();
        hsu.setDoInput(true);
        hsu.setDoOutput(true);
        hsu.setRequestMethod("POST");
        return hsu;


    }


    static void closeConn(HttpsURLConnection c) {
        c.disconnect();
    }

}
