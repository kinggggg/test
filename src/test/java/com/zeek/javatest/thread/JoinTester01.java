package com.zeek.javatest.thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName JoinTester01
 * @Description Thread.join()方法的基本使用
 * @Author liweibo
 * @Date 2018/10/25 下午4:17
 * @Version v1.0
 **/
public class JoinTester01 implements Runnable {

    private String name;

    public JoinTester01(String name) {
        this.name = name;
    }

    public void run() {
        System.out.printf("%s begins: %s\n", name, new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s has finished: %s\n", name, new Date());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new JoinTester01("One"));
        Thread thread2 = new Thread(new JoinTester01("Two"));
        thread1.start();
        thread2.start();

        try {
            thread1.join(); //等到thread1执行完毕，主线程main才开始执行
            thread2.join(); //等到thread2执行完毕，主线程main才开始执行
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Main thread is finished");
    }

}
