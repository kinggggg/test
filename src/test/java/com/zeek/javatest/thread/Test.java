package com.zeek.javatest.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Test
 * @Description
 * @Author liweibo
 * @Date 2019/7/9 4:38 PM
 * @Version v1.0
 **/
public class Test {
    private static long count = 0;

    private void add10K() {
        int idx = 0;
        while(idx++ < 10000000) {
            count += 1;
        }
    }
    public static long calc() throws InterruptedException {
        final Test test = new Test();
        // 创建两个线程，执行 add() 操作
        Thread th1 = new Thread(()->{
            test.add10K();
        });
        Thread th2 = new Thread(()->{
            test.add10K();
        });
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();

        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        /*long calc = calc();
        System.out.println(calc);*/

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        executorService.shutdown();




    }
}
