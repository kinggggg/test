package com.zeek.javatest.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2020-11-26
 */
public class CompletableFutureTest2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Void> noReturnValue = CompletableFuture.runAsync(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("1.doing");
                    TimeUnit.SECONDS.sleep(1);
                }

            } catch (InterruptedException e) {
            }
            System.out.println("1. run end ...");
        });

        CompletableFuture<Long> haveReturnValue = CompletableFuture.supplyAsync(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("2.doing");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
            }
            System.out.println("2. run end ...");

            return System.currentTimeMillis();
        });
        // 1执行快首先执行完, 当1执行完了后, 2还没有执行完
        // 当1执行完了后, noReturnValue.get()可以获取到值, 而2继续执行, 当2执行完了后, haveReturnValue.get()可以获取到值
        // 可以看到这种情况下, 1和2哪个先执行完就可以获取对应的值
        System.out.println("1. result: " + noReturnValue.get());
        System.out.println("2. result: " + haveReturnValue.get());
        System.out.println("done");
    }
}
