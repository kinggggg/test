package com.zeek.test.spring.learn.utils;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.*;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: weibo_li
 * @since: 2018-02-06 下午3:26
 */
public class CasServerUtil {

    private static final String CAS_CLIENT_SERVICE_URL = "http://cas.client1.com:8383/api/list" ;

    private static final String CAS_SERVER_PROTOCOL = "https" ;

    private static final String CAS_SERVER_URI = "cas.server.com:8443" ;

    private static final String CAS_SERVER_LOGIN_PATH = "/cas/login" ;

    public static final String CAS_SERVER_LOGIN_URL = "https://cas.server.com:8443/cas/login" ;

    private static final String CAS_SERVER_TICKETS = "https://cas.server.com:8443/cas/v1/tickets" ;

    private static final String CAS_SERVER_USERNAME = "casuser" ;

    private static final String CAS_SERVER_PASSWORD = "Mellon" ;

    private static final String CAS_SERVER__EVENTID_KEY = "_eventid" ;

    private static final String CAS_SERVER__EVENTID_VALUE = "submit" ;

    private static final String CAS_SERVER_EXECUTION_KEY = "execution" ;

    //execution动态变化，必须动态获取
    private static String CAS_SERVER_EXECUTION_VALUE = "" ;

    public static String validateFromCAS() throws Exception {
        String serviceTicket = "" ;
        try {
            HttpsURLConnection hsu = (HttpsURLConnection) openConn(CasServerUtil.CAS_SERVER_TICKETS);
            String s = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(CasServerUtil.CAS_SERVER_USERNAME, "UTF-8");
            s += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(CasServerUtil.CAS_SERVER_PASSWORD, "UTF-8");

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

                String encodedServiceURL = URLEncoder.encode("service", "utf-8") + "=" + URLEncoder.encode(CasServerUtil.CAS_CLIENT_SERVICE_URL, "utf-8");
                System.out.println("Service url is : " + encodedServiceURL);


                String myURL = CasServerUtil.CAS_SERVER_TICKETS + "/" + tgt;
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

    /**
     * 解析html，得到execution
     * @param redirectUrl
     * @return
     * @throws Exception
     */
    public static String getExecution(String redirectUrl) throws Exception {
        CookieStore httpCookieStore = new BasicCookieStore();
        CloseableHttpClient client = createHttpClientWithNoSsl(httpCookieStore);

        /* 第一次请求[GET] 拉取流水号信息 */
        HttpGet request = new HttpGet(CasServerUtil.CAS_SERVER_LOGIN_URL + "?service=" + redirectUrl);
        HttpResponse response = client.execute(request);

        System.out.println("第一次请求[GET] 拉取流水号信息，Header响应");
        Header[] allHeaders = response.getAllHeaders();
        for (int i = 0; i < allHeaders.length; i++) {
            System.out.println("Key：" + allHeaders[i].getName() + "，Value：" + allHeaders[i].getValue() + "，Elements:" + Arrays.toString(allHeaders[i].getElements()));
        }

        Document htmlPage = Jsoup.parse(readResponse(response));
//        Element form = htmlPage.select("#fm1").first();
//        String execution = form.select("[name=execution]").first().val();

        String execution = htmlPage.select("[name=execution]").first().val();
        System.out.println("execution：" + execution);

        return execution;
    }

    /**
     * 创建模拟客户端（针对 https 客户端禁用 SSL 验证）
     *
     * @param cookieStore 缓存的 Cookies 信息
     * @return
     * @throws Exception
     */
    private static CloseableHttpClient createHttpClientWithNoSsl(CookieStore cookieStore) throws Exception {
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    @Override
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        // don't check
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        // don't check
                    }
                }
        };

        SSLContext ctx = SSLContext.getInstance("TLS");
        ctx.init(null, trustAllCerts, null);
        LayeredConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(ctx);
        return HttpClients.custom()
                .setSSLSocketFactory(sslSocketFactory)
                .setDefaultCookieStore(cookieStore == null ? new BasicCookieStore() : cookieStore)
                .build();
    }

    /* 读取 response body 内容为字符串 */
    private static String readResponse(HttpResponse response) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
        String result = new String();
        String line;
        while ((line = in.readLine()) != null) {
            result += line;
        }
        return result;
    }

    /**
     * 通过后端Httpclient方式得到cas server登录cookie
     * @param requestUrl
     * @param casLoginData
     * @param httpMethod
     * @return
     * @throws Exception
     */
    public static Cookie getCasServerCookieByHttpClientCall() throws Exception {

        CookieStore cookieStore = new BasicCookieStore();
        //核心应用类
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        //设定表单需要提交的参数
        List<NameValuePair> qparams = new ArrayList<NameValuePair>();

        //示例：提交用户名和密码
        qparams.add(new BasicNameValuePair("username", CasServerUtil.CAS_SERVER_USERNAME));
        qparams.add(new BasicNameValuePair("password", CasServerUtil.CAS_SERVER_PASSWORD));
        qparams.add(new BasicNameValuePair(CasServerUtil.CAS_SERVER__EVENTID_KEY, CasServerUtil.CAS_SERVER__EVENTID_VALUE));
        qparams.add(new BasicNameValuePair(CasServerUtil.CAS_SERVER_EXECUTION_KEY, CasServerUtil.getExecution(CasServerUtil.CAS_CLIENT_SERVICE_URL)));

        //设定需要访问的URL，第四个参数为表单提交路径
        URI uri = URIUtils.createURI(CasServerUtil.CAS_SERVER_PROTOCOL, CasServerUtil.CAS_SERVER_URI, -1, CasServerUtil.CAS_SERVER_LOGIN_PATH,
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
