package com.zeek.test.resttemplate;

import java.time.Instant;
import java.util.Date;

/**
 * Created by weibo_li on 2017/7/28.
 */
public class RefundResponse {

    private String outRefundNo;

    private String outTradeNo;

    private long refundFee;

    private String refundDescription;

    private Date resultDate;

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public long getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(long refundFee) {
        this.refundFee = refundFee;
    }

    public String getRefundDescription() {
        return refundDescription;
    }

    public void setRefundDescription(String refundDescription) {
        this.refundDescription = refundDescription;
    }

    public Date getResultDate() {
        return resultDate;
    }

    public void setResultDate(String resultDate) {

        Instant instant = Instant.parse(resultDate);

        Date date = Date.from( instant );

        this.resultDate = date;
    }
}
