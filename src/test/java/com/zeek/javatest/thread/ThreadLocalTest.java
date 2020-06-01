package com.zeek.javatest.thread;

/**
 * @ClassName ThreadLocalTest
 * @Description
 * @Author liweibo
 * @Date 2020/5/17 9:23 下午
 * @Version v1.0
 **/
public class ThreadLocalTest {
    private static String strLabel;
    private static ThreadLocal<String> threadLabel = new ThreadLocal<>();

    public static void main(String... args) {
        strLabel = "main";
        threadLabel.set("main");

        Thread thread = new Thread() {

            @Override
            public void run() {
                super.run();
                strLabel = "child";
                threadLabel.set("child");
            }

        };

        thread.start();
        try {
            // 保证线程执行完毕
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("strLabel = " + strLabel);
        System.out.println("threadLabel = " + threadLabel.get());

        threadLabel.set("new-value");
        System.out.println("threadLabel new = " + threadLabel.get());
    }
}