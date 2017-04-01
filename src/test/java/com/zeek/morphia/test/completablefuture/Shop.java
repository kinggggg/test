package com.zeek.morphia.test.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * Created by weibo_li on 2017/2/14.
 */
public class Shop {

    private String name;

    public Shop() {

    }

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double calculatePrice(String produce) {
        delay();
        return new Random().nextDouble() * produce.charAt(0) + produce.charAt(1);
    }

    public void delay() {
        try{
            Thread.sleep(1000);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
