package com.zeek.javatest.thread;

import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CyclicBarrierTest01
 * @Description
 *      线程t1负责查询订单库，线程t2负责查询运单库；每一次查询完订单库中的数据（限定一次只查询一条）和运单库中的数据（限定一次只查询一条）需要对这两个数据进行check
 * @Author liweibo
 * @Date 2019/8/7 5:31 PM
 * @Version v1.0
 **/
public class CyclicBarrierTest002 {

    //模拟订单库
    public static final Vector<Integer> pos = new Vector<>();
    //模拟运单库
    public static final Vector<Integer> dos = new Vector<>();

    static {
        //模拟订单库和运单库中的数据
        for(int i = 0; i < 1000; i++) {
            pos.add(i);
            dos.add(i);
        }
    }

    public static void main(String[] args) {

        //如果不使用额外的线程池来执行check方法的话，执行check方法的线程是最后调用barrier.await()方法的线程。这里为t2，因为t2相较于t1后执行barrier.await方法。
        //此时执行check方法与checkAll是串行执行的
        final CyclicBarrier barrier = new CyclicBarrier(2, () -> {
            check();
        });

        checkAll(barrier);

    }

    public static void check() {

        Integer pos = CyclicBarrierTest002.pos.remove(0);
        Integer dos = CyclicBarrierTest002.dos.remove(0);

        System.out.println("pos="+ pos + " dos="+ dos +" 开始对账 线程名称为" + Thread.currentThread().getName());


    }

    public static void checkAll(CyclicBarrier barrier) {
        Thread t1 = new Thread(() -> {
            System.out.println("<--------查询订单库 线程名称为" + Thread.currentThread().getName());
            //这里省略了将查询出的结果放入pos的过程，由static静态代码块中的代码模拟实现
            try {
                //故意sleep一下，让t1后于t2执行await
                TimeUnit.SECONDS.sleep(2);
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            System.out.println("-------->查询运单库 线程名称为" + Thread.currentThread().getName());
            //这里省略了将查询出的结果放入dos的过程，由static静态代码块中的代码模拟实现
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        t2.start();
    }
}
