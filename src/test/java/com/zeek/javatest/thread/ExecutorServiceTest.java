package com.zeek.javatest.thread;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * 通过submit或者execute提交的的任务，若其中的一个任务出现异常的话是不会影响到其他线程执行的
 **/
public class ExecutorServiceTest {

    // 测试ExecutorService中submit和execute方法不同
    @Test
    public void test01() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(50);

        Future<?> future = executorService.submit(() -> {
            System.out.println("submit提交抛出异常的任务");
            try {
                Thread.sleep(3_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 虽然这里出现了异常，但是在控制台不会打印出
            int i = 1 / 0;
        });
        try {
            // 通过submit提交的任务，如果出现异常的话，可以通过Future.get方法获取到
            System.out.println("submit runnable task and get result: " + future.get());
        } catch (ExecutionException ee) {
            System.out.println("1111" + ee);
        } catch (InterruptedException ie) {
            System.out.println("2222" + ie);
        }

        IntStream.rangeClosed(0, 5).forEach(i -> {
            executorService.submit(() -> {
                System.out.println("submit正常的任务");
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });



        // 通过execute提交的任务，若果任务在执行的过程中出现异常的话，异常的信息将直接被打印出
        executorService.execute(() -> {
            System.out.println("execute提交抛出异常的任务");
            try {
                Thread.sleep(4_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 这里出现异常后，会直接在控制台打印出
            int i = 1 / 0;
        });
        IntStream.rangeClosed(0, 5).forEach(i -> {
            executorService.execute(() -> {
                System.out.println("execute提交正常的任务");
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });



    }
}
