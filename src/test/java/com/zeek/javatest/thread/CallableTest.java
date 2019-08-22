package com.zeek.javatest.thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Callable与Runnable的最明显的不同之处在于，
 * 通过Callable提交的任务，可以获取任务的返回值
 **/
public class CallableTest {

    @Test
    public void test01() throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(1);
        Future future = service.submit(new MyCallable());
        while (!future.isDone()) {
            Thread.sleep(1_000);
            System.out.println("进行中....");
        }

        System.out.println("获取结果...");
        System.out.println(future.get());

    }
}

class MyCallable implements Callable {

    @Override
    public Object call() {
        System.out.println("正在计算...");
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("返回结果...");

        return 10;
    }
}
