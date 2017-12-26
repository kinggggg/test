package com.zeek.javatest.longtype;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by weibo_li on 2017/8/2.
 */
public class LongTest {

    @Test
    public void test1() {
        double v = this.changeF2Y(200);
        System.out.println(v);

        String s = this.changeY2F("20.01");
        System.out.println(s);
    }

    public double changeF2Y(long amount){
        BigDecimal decimal = BigDecimal.valueOf(amount).divide(new BigDecimal(100));
        return decimal.doubleValue();
    }

    /**
     * 将元为单位的转换为分 （乘100）
     *
     * @param amount
     * @return
     */
    public String changeY2F(String amount){
        // 价格需要进行转换，微信支付的单位是分
        DecimalFormat df = new DecimalFormat("#.00"); // 保留两位小数
        String price = df.format(Double.valueOf(amount));
        String str[] = price.split("\\.");
        String tmp = "";
        for (String s : str) {
            tmp += s;
        }
        price = tmp;

        return price;
    }

}
