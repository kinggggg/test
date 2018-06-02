package com.zeek.test.spring.learn.test;

import com.google.gson.JsonObject;
import org.junit.Test;

/**
 * @author: weibo_li
 * @since: 2018-05-22 下午7:05
 */
public class JsonTest {

    @Test
    public void test() {
        JsonObject casLoginResponse = new JsonObject();
        casLoginResponse.addProperty("id", "id");
        casLoginResponse.addProperty("username", "username");

        JsonObject attributes = new JsonObject();
        attributes.addProperty("username", "username");
        attributes.addProperty("password", "password");
        casLoginResponse.addProperty("attributes", String.valueOf(attributes));

        casLoginResponse.addProperty("@class", "org.apereo.cas.authentication.principal.SimplePrincipal");

        System.out.println(casLoginResponse.toString());
    }
}
