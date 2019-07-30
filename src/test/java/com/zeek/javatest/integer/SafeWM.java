package com.zeek.javatest.integer;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName SafeWM
 * @Description
 * @Author liweibo
 * @Date 2019/7/25 4:45 PM
 * @Version v1.0
 **/
public class SafeWM {

    public static void main(String[] args) {

        SafeWM safeWM = new SafeWM();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            int m = random.nextInt(10);
            int n = random.nextInt(10);

            safeWM.setLower(m);
            safeWM.setUpper(n);
        }





    }

    // 库存上限
    private final AtomicLong upper =
            new AtomicLong(10);
    // 库存下限
    private final AtomicLong lower =
            new AtomicLong(5);

    // 设置库存上限
    void setUpper(long v) {
        // 检查参数合法性
        upper.getAndUpdate(u -> {
            if (v < lower.get()) {
                System.out.println("01 upper:" + upper + " lower:" + lower);
                throw new IllegalArgumentException();
//                System.out.println("高小于低");
//                return upper.get();
            } else {

//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

//                System.out.println("upper:" + upper + " lower:" + lower);
                return v;
            }
        });
    }
    // 设置库存下限
    void setLower(long v) {
        // 检查参数合法性
        lower.getAndUpdate(u -> {
            if (v > upper.get()) {
                System.out.println("02 upper:" + upper + " lower:" + lower);
                throw new IllegalArgumentException();
//                System.out.println("低大于高");
//                return lower.get();
            } else {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("upper:" + upper + " lower:" + lower);
                return v;
            }
        });
    }
}
