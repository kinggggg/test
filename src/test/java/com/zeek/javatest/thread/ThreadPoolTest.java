package com.zeek.javatest.thread;

import java.util.concurrent.*;

/**
 *
 **/
public class ThreadPoolTest {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        threadPoolExecutor.submit(new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("开始执行");
                // 当使用线程池执行任务时，若任务抛出异常了后，执行这个任务的线程池中的线程也就停止执行了！这要注意了
                int i = 1 / 0;
            }
        });

        while (true) {
            System.out.println("main线程执行");
            try {
                Thread.sleep(1_000);
                System.out.println("线程池线程个数为" + threadPoolExecutor.getActiveCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}

