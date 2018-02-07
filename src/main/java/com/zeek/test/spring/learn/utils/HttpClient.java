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
        qparams.add(new BasicNameValuePair("execution", "9ca56548-ac0d-4bef-9fbc-d550f48f3902_ZXlKaGJHY2lPaUpJVXpVeE1pSjkuYjBJME9IQnNhbVp1VEhSUWVHNXJialowVjNNdlpFNDVUemd3VEhkUFlrWmxiVzFMT0ZWSlRYUmFWMmx3VjJ0aFFUQkNWbVJqU1hOb0wyNWlVSEZIWlVkemFTOUNNbVJZT1dsaGJGaENaelI2ZFVzd01rUldlRGhFUms1WE5WaFRlVlJMY1c5aWExTnVPVEV5U2taVFZTdE1WWGwxWkRkRVZ6TkZkMFpRUm5GTk1tNTZUelpJVGpsUVkwbDFXVmhTU1ZCUVFtRkljekpzV1ZSR1VpdHhUemN4Y1dOaE5WQldiakJ0Y1ZwNWJUbDZNa1ZaY0hkVWVtcEVTbU12Y2k5d1lVUmFaMnAyY3pGTWNqQnFZekV2UlVwclNXMTVXRTF1VkhGWkt6Sllka3d4U1ZsaWVEWTJhVXhEZEdwSGFtVTJhMHgzYm5CRFZURnhMMGhCTHpZdk5IQnBlbTVIVDNWR1RTOWlSRGxSWTI5MFJ6QnpNbWhITTFkeFpITXJkelJtWVdNNFVsRjJSVTFYU2pJclkzbHhNRVIxZUhORVRISjJVMjVpVFhGdmVGbG5jR1I0ZVVaV01GQmtNSGg1V201bWNFSXhRMkoxUlZnNGFWSmxLMWwzYzFVeVlscHdTRXh1WVRaS1Jsb3piRlkxSzBsNGNIWTVaRnAxVFN0V1ZuVmlaalZwZHpKWlFrbDZUek4wYURVckwwUndTV0ZJTTJweWRTdG9aR0VyTkVVeFJXNDJZa1pYTlVKR2Exb3JSa1Z0WlU1a1puYzJXblJ2WjNsNE9IUk9ibUZLZWtwWE1XVllZVGg0UzBaSFRIUklTMk5ES3pJNU1XaGlVekJ2TVdKMVluRkhkVXRpU1V0dWVERjRjbHByWlROSmVYVXhOMFkwUVRaNGNFbHdOR0pWVFZwUlpTOXZZV2RoWkZsNlRFTlhVMDlLY1ZkVVJqVjVLMU5wUWsxMk1tbGtUeTlKVmtscVRIVXlVR1ZuTUVwNmFEZGxVVmN3ZWpKR1kwVTBPVFpKYWpCaVpGTm1VRFJXZWxFMVNrMDFTakpYUkZWUFEydEVlRGhQTTFGMldVczBTSEpCYW5GeGRUZDVWMDQzWTNKbVR6QmxiMDV5Y21oell6WTFkbVpzT1ZCbWNGa3lhRVpRTm1oa2RXdzFkVkZ4Tm5ablVtbG9lSHBrTkVwRGFuQklZbUpQYTJsM1dVaEVOV2xXWkVSS2EwTnBSeXRYYjI5S1NVNVBVVEprVjNSUVRIaFRTRTFYYm5WWFFVSjRUbGhaVjNSRUszbENjVzlCYzNaNVlYaFJTbWR5ZURWVGVuZEdaMnhtU1hKd1MxcFNXa0YzUTNNeGNVOXlZMFZxVVhWS1p6TTNPWEJqVXpkQmMxWk1lbUY2TjJ4M1RtTlNjalZXTW01SFMyTklTRTVPYkdGUGEwbHlUWFV3VDBGRFUybGFSVlpWWlZSVmRua3hjbkJsUlZod05HTm5LM2hyWWpKNmJEbEhLeXRwWkV3clREVkxhRU5qYzFGMFozTmFUek5qU0ZOb1prUXZVWGhtSzI5a2VsaEdLemwyV2pBelF5dENkMmxKY25sS1pUTmlRWFZ2TDFWM1FWUnViV052V1VkTGFsQkNSRTFSYlc1cWFHTjBkbGxET0hwU1FUZ3hWVzQzVkVWdGJ5dFRkMjlNWW1WUlYxRkhkSFJJVW5SV1lsQldTM2RtVEcxUVZGUm5OR2hxTTBwSVdVSk1WMmRVTTJWRVUwbGpTRVZPV0dwSk1Vc3ZWMlpDVlhwaGRqSnJjbEJTWlhSRU5VeDJORmQyUjI1Mk0xWTJiVFo0VldoRmMyaEJZVWhsYTJzekx6RjJVMXBoVGxFOVBRLmZmdmFaQm5BRWRDVGh6dmxocDZTaV95SG0xWTc1RExSWWUxdHp1M2s4Ty1aaUlhRFNqSmJybkdTZ0dwZlA3eFhZazhKeHU2MC1yTTRSYVU5aTIwNGNB"));

        //设定需要访问的URL，第四个参数为表单提交路径
        URI uri = URIUtils.createURI("https", "yellowcong.com:8443", -1, "/cas/login",
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
