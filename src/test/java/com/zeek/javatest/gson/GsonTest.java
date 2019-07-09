package com.zeek.javatest.gson;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

/**
 * Created by weibo_li on 2017/3/30.
 */
public class GsonTest {

    @Test
    public void test4() {

        String str = "RequestInfo{mapInfo={stringg=张三, intt=18, sign=55ee9e399950f8c2749cfc44367fd944, businessId=1234abcd, orderNum=1234abcd1552284078838, version=10, ts=1552284078838}, returnResult='null', orderNum='1234abcd1552284078838', ruleGroupId='415', businessManagerId='263', businessId='446', address='127.0.0.1', ruleGroupName='RuleGroupProductModel8655407AE5E347A9A1D2D907DD17588B', productModelPackge='null', productModelName='null'}" ;

        String[] split = str.split("\\{");
        System.out.println(split);

    }

    @Test
    public void test3() throws ParseException {

        Instant fromIso8601 = Instant.parse("2017-07-31T10:06:00.713Z");

        Date utilDate = Date.from( fromIso8601 );



    }

    @Test
    public void test2() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy hh:mm:ss aaa");

        Date parse = sdf.parse("Jul 31, 2017 3:08:03 PM");


    }

    @Test
    public void test1() {

        PaymentResponseViewModel<PreOrderResponse> viewModel = new PaymentResponseViewModel<>();
        PreOrderResponse preOrderResponse = new PreOrderResponse();
        preOrderResponse.setAppId("wxecfcb7a7fe46526d");
        preOrderResponse.setPartnerId("1445827402");
        preOrderResponse.setPrepayId("wx20170727182119816ecbc4e90651528208");
        preOrderResponse.setPackageInfo("Sign=WXPay");
        preOrderResponse.setNonceStr("2bdd7b1f31b2462aad38f221cbea6b0c");
        preOrderResponse.setTimestamp("1501150879");
        preOrderResponse.setSign("ABD8812C7E6D978A4760200DD0CFEE23");
        viewModel.setData(preOrderResponse);

        Gson gson = new Gson();
        String resultJson = gson.toJson(viewModel);
        System.out.println(resultJson);

        PaymentResponseViewModel<PreOrderResponse> result = new Gson().fromJson(resultJson, new TypeToken<PaymentResponseViewModel<PreOrderResponse>>() {
        }.getType());

        System.out.println(result);

    }

    @Test
    public void test0() {
//        Teacher1 teacher1 = new Teacher1();
//
//        Gson gson = new Gson();
//
//        System.out.println(gson.toJson(teacher1));
//
//        String jsonString = "{\"name\":\"怪盗kidou\"}";
//
//        Teacher1 teacher11 = gson.fromJson(jsonString, Teacher1.class);
//
//        HuaWeiMessage huaWeiMessage = new HuaWeiMessage("我是谁？", "我是招生为", 2, "www.baidu.com");
//
//        System.out.println(gson.toJson(huaWeiMessage));



    }
}
