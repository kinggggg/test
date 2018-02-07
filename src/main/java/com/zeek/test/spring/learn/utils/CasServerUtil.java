package com.zeek.test.spring.learn.utils;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * @author: weibo_li
 * @since: 2018-02-06 下午3:26
 */
public class CasServerUtil {

    public static String validateFromCAS(String username, String password) throws Exception {

        String url = "https://yellowcong.com:8443/cas/v1/tickets";
        String serviceTicket = "" ;
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
                    serviceTicket = line;
                }
                isr.close();
                hsu.disconnect();
                return serviceTicket;

            } else {
                return "";
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
