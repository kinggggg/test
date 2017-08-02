package com.zeek.test.resttemplate;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;

/**
 * Created by weibo_li on 2017/8/1.
 */
public class RestTemplateTest {

    @Test
    public void test1() throws ParseException {

        RestTemplate restTemplate = new RestTemplate();

        String forObject = restTemplate.getForObject("http://localhost:8585/firefly/adviceOrders/adviceOrder/{id}/", String.class, "142966a2-7ef1-4dec-8620-aef606db8bd0");
        System.out.println(forObject);

        ResponseEntity<ResponseViewModel> responseEntity = restTemplate.postForEntity("http://localhost:8585/firefly/adviceOrders/test/{id}", null, ResponseViewModel.class, "123");

        System.out.println(responseEntity);




    }
}
