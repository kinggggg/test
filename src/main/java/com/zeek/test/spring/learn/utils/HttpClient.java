package com.zeek.test.spring.learn.utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liweibo on 17/5/23.
 */
public class HttpClient {

    public static void Get(String url) throws IOException {
        Request.Get(url).execute().returnContent();
    }

    public static String GetWithResponse(String url) throws IOException {
        return Request.Get(url).execute().returnContent().toString();
    }



    public static String httpRequest(String requestUrl, String requestJson, HttpMethod httpMethod) {
        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClients.createDefault();
            HttpResponse response;

            if (null == httpMethod) {
                throw new RuntimeException("Http Method should be Get, Post, Put or Delete.");
            }

            if (HttpMethod.Get == httpMethod) {
                HttpGet httpGet = new HttpGet(requestUrl);
                httpGet.setHeader("Wmq-Topic-Name", "WuSongAppTopic");
                response = httpClient.execute(httpGet);
            } else {
                HttpEntityEnclosingRequestBase requestBase = null;
                switch (httpMethod) {
                    case Post:
                        requestBase = new HttpPost(requestUrl);
                        break;
                    case Put:
                        requestBase = new HttpPut(requestUrl);
                        break;
                }

                if (StringUtils.isNotBlank(requestJson)) {
                    StringEntity requestEntity = new StringEntity(requestJson, ContentType.APPLICATION_JSON);
                    if (requestBase != null) {
                        requestBase.setEntity(requestEntity);
                    }
                }
                requestBase.setHeader("Wmq-Topic-Name", "WuSongAppTopic");
                response = httpClient.execute(requestBase);
            }

            HttpEntity httpEntity = response.getEntity();
            return EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // FIXME: 2017/7/26 用于生产环境测试
        //return  "success" ;
    }

    public static Cookie httpRequest2(String requestUrl, CasLoginData casLoginData, HttpMethod httpMethod) throws Exception {

        CookieStore cookieStore = new BasicCookieStore();
        //核心应用类
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        //设定表单需要提交的参数
        List<NameValuePair> qparams = new ArrayList<NameValuePair>();

        //示例：提交用户名和密码
        qparams.add(new BasicNameValuePair("username", "casuser"));
        qparams.add(new BasicNameValuePair("password", "Mellon"));
        qparams.add(new BasicNameValuePair("_eventId", "submit"));
        qparams.add(new BasicNameValuePair("execution", "bfca648e-85d3-40e2-b8b0-f56cd8023984_ZXlKaGJHY2lPaUpJVXpVeE1pSjkuTlcxU05ITmtUVU56VlhWclRVRm1ia0ZCWlc1emVTOVVkeXRPVEhaVFUyWmpTMU5TVWtsTldrUjBZbkpqZDJNMWNESlBTMkZzYkVoelZVZDNXak5YVTNCWlFtTnBUV2t2ZWxNeWJGZGpkakEwYkVoSFp5OTNia2x0TTBZMk5VMUtTVzQ1TjJFeE0wSkpia2x3ZUdwb00yNU1OVXRoYldsNWJuVlBMMnNyVVZNdmNVNW1XbEZYVGxFM1ZuZ3pNa2xLWVhScGFXTlVWMVZOWTAwdmNuQnlaMnRIVHpWSFYyVnFNMVo2YTAxVGFXOTRLM2N6WTJGWU4xZHBiakl5VEU1RVVsSkZUSEJhWXpCeFpVSnhWbVp2WjJWdE1ucDVhVFpXVUVFMWNWRnpSMmxZV1VZcmJUQnVZeTluVVVGcVZUaFpZWHB0YUdOTWNtMHlTMHhQYkN0bllWVlhSVGg0T1hkcmRrcEVLMHBFT0VaUU5saDVjMUJaVTIxd1FrRkRUelpuUW1GdlEzaHlTVGcwTWpWRldHaHVTaXM1VkhocWNrbGtTbkJOYW1GdmJqQnZLekJIWkRrNVVqbHRkazVGY2pkR1RVMUNOMGs1VUhnMWFTdFdRVUZUU1ROU1lXaEVOSGc0TDBsWlVWUlRhREJzUkRWdk5IWnFLMFZtY2l0TlRrSlZUelJWVmpCMlpqRmtSVGh4U21aaVowOUNTREpzZUVJM1lYRnJTVmhXYUV0clVYWklSMHBqVTJSdWRUSjVhR2h3TlV4WmNXeFphbEpXWmtGaFJYVTNiMFIzWTFaYVVYWXhlVFJQYkVaNE5FTjBUWGt6VlZoRGNGZzRjMk51VW01WlRVaFpNM1pYUTFRMWJ6Y3lTVUl4TkZaWVUyZHZiblp0THl0U01rTTVhMlJFUWl0R1V6WkdVRlJ1VWxaWFNHZHNOR0p1YWtwR1dIQXhMM0EyWVRFeE9EWnRURFZRV2xSNFVHcFNiV014Y21KbFkyUXlUVUpKYkU1NE5rTTNOa054VTNkb1RHeDZSalpPVlhaQlZUVnFNMGRqYmxjeGRHSnNNMDVITWxVd1pHaEJTelUwZG5kVFkwVjJTblV4YldsWmF6RkdZMmR3THl0Tkx5dGlWbGwyY0VORVJHWmllRlJsWWxKc1Vsa3hXSGgwTTFWbFRuZHNZa1prY25JeWJXOTNaVlJSYUZRMk16UXZkRkJRYUVsdU5WaENSVTV4V210WWRFaHRNWHBqVlc5SFlubFNNV1pRZW1ReVVIUnNjbkoxTVc1QlJtUkNTMGd4Tm5sdVUyeFBiR0pQWVhKRFN5dHRhazlPWTNFMVdrNVFabmcxUkVObVZFOUJiMkk1WnpSdmVHVnJNR2xaZEhaSWVrZEVSMFZ0YVcxcFVsaGhWVzFESzJRNGFqVkNTbkptYzJoUVZVdzVSRkY1Y2xkaVNqWkpObGRqVUhCb1JtNXhSa0ZuVldObVZFSXdPV2Q2VFdwd1EwWklZM1JaYlZSbGRWaFRPR2t3V0ZwTVozQnFhVFZ2UlRGcVUwOUdiSE5SV0VWU2EwOTVkREV2UzI1VldubDFRM0JJV1ZaQ1ZWWmtaVWd2YUZwVGFuUjJWbVp6YkVsM1ZIVnpXbk5RUjA5eVUzSXdNRUpuWjFsUU5rUlZiVGRWT1dwelprcDZPSGRJWVdzek1rdFhLMUV5WVRWTk4wUkdRWFYyYkdOWVlUUlJMemcxU1hkR2IyZDRiM0U1ZWxGSU5tOUpNaXR2TDNFMFpHeDJXbmx4UjI1UlR6ZHZOVzloZDFKWFZISTViVGhpZFN0MU5Ea3hiM1ZyTWpreEszUlVNREZxUTB3cllpOTFUVUUwU0ZFOVBRLkhQX1NCT3ZYZmF3UzhBVXM5czQ5c1hMM2VmRFlnMFo5NXpwdUpKN2JlZ0ZLUVhmUldwRWxYLTQ4elBidk9ydWZEbkZTYWpMamk4YURsYzdsMnVwZUxn"));

        //设定需要访问的URL，第四个参数为表单提交路径
        URI uri = URIUtils.createURI("https", "cas.server.com:8443", -1, "/cas/login",
                //将参数加入URL中
                URLEncodedUtils.format(qparams, "UTF-8"), null);
        //Post提交
        HttpPost httpPost = new HttpPost(uri);

        //System.out.println(httpPost.getURI());

        //httpClient执行，返回response
        HttpResponse response = httpClient.execute(httpPost);

        //获取实体
        HttpEntity httpEntity= response.getEntity();

        //打印StatusLine
        System.out.println("StatusLine: " + response.getStatusLine());

        //读取内容
        String content = EntityUtils.toString(httpEntity, "UTF-8");
        //打印输出结果内容
        System.out.println(content);

        return cookieStore.getCookies().get(0);
    }

}
