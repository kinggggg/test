package com.zeek.test.resttemplate;

import com.google.appengine.repackaged.org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;

/**
 * Created by weibo_li on 2017/8/1.
 */
public class RestTemplateTest {

    @Test
    public void test2() {

        String refundApi = "" ;

        MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("outTradeNo", "");
        postParameters.add("outRefundNo", "WSR2017080221362175587957");
        postParameters.add("refundFee", "");
        postParameters.add("refundDescription", "请教问题订单自动撤单退款");

        RestTemplate restTemplate = new RestTemplate();
        RefundResponseViewModel refundResponseViewModel = restTemplate.postForObject(refundApi, postParameters, RefundResponseViewModel.class);
        if(refundResponseViewModel == null) {
            System.out.println("调用支付平台退款接口失败：refundResponseViewModel == null");
            return ;
        }
        if(refundResponseViewModel.getData() == null) {
            System.out.println("调用支付平台退款接口失败：refundResponseViewModel.getData() == null");
            return ;
        }
        if(refundResponseViewModel.getResult() == null) {
            System.out.println("调用支付平台退款接口失败：refundResponseViewModel.getResult() == null");
            return ;
        }



    }


    @Test
    public void test1() throws ParseException {

        RestTemplate restTemplate = new RestTemplate();

        String forObject = restTemplate.getForObject("http://localhost:8585/firefly/adviceOrders/adviceOrder/{id}/", String.class, "142966a2-7ef1-4dec-8620-aef606db8bd0");
        System.out.println(forObject);

        ResponseEntity<ResponseViewModel> responseEntity = restTemplate.postForEntity("http://localhost:8585/firefly/adviceOrders/test/{id}", null, ResponseViewModel.class, "123");

        System.out.println(responseEntity);

    }
}
