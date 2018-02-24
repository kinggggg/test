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

    }

}
