package com.zeek.kafka.producer;

/**
 * Created by weibo_li on 16/8/2.
 */
public class SendData {

    public SendData(String pro1, int pro2) {
        this.pro1 = pro1;
        this.pro2 = pro2;
    }

    private String pro1;

    private int pro2;

    public String getPro1() {
        return pro1;
    }

    public void setPro1(String pro1) {
        this.pro1 = pro1;
    }

    public int getPro2() {
        return pro2;
    }

    public void setPro2(int pro2) {
        this.pro2 = pro2;
    }

    @Override
    public String toString() {
        return "SendData{" +
                "pro1='" + pro1 + '\'' +
                ", pro2=" + pro2 +
                '}';
    }
}
