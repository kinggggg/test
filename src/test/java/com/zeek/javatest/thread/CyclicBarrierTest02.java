package com.zeek.javatest.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName CyclicBarrierTest01
 * @Description
 *  
 * @Author liweibo
 * @Date 2019/8/7 5:31 PM
 * @Version v1.0
 **/
public class CyclicBarrierTest02 {


    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(1);

        /**
         * 使用线程池的方式可以让check的工作与chekAll的工作并行执行。但是executor中的线程池大小必须设定为1，否则出现线程同步问题.
         * 例如下面的这种情况：
         * 如果为线程池有多个线程，则由于check()函数里面的两个remove并不是原子操作，可能导致消费错乱。假设订单队列中有P1，P2；派送队列中有D1,D2；两个线程T1,T2同时执行check，可能出现T1消费到P1,D2，T2消费到P2，D1，就是T1先执行pos.remove(0), 而后T2执行pos.remove(0);dos.remov(0);然后T1才执行dos.remove(0)的场景
         *
         * 虽然实验不好做，但是从理论上来看如果不是单个线程池的话会存在这种问题
         **/
        final CyclicBarrier barrier = new CyclicBarrier(2, () -> {
            executor.execute(() -> {
                check();
            });
        });

        checkAll(barrier);

    }

    public static void check() {
        System.out.println("开始对账 线程名称为" + Thread.currentThread().getName());
    }

    public static void checkAll(CyclicBarrier barrier) {
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("<--------查询订单库 线程名称为" + Thread.currentThread().getName());
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }

        });
        t1.start();

        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println("-------->查询运单库 线程名称为" + Thread.currentThread().getName());
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }
}
