package com.zeek.javatest.thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * FutureTaskTest可以看做是一个混合体
 * FutureTask既实现了Future接口因此可以获取到执行结果
 * FutureTask也实现了Runnable接口因此可以通过线程的方式执行任务
 **/
public class FutureTaskTest {

    @Test
    public void test01() throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            System.out.println("正在计算...");
            Thread.sleep(5_000);
            System.out.println("计算完成...");

            return 10;
        });

        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(futureTask);
        while (!futureTask.isDone()) {
            System.out.println("计算任务正在计算...");
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("计算结果为:" + futureTask.get());

    }
}
