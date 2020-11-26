package com.zeek.javatest.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2020-11-26
 */
public class CompletableFutureTest3 {

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

        // 通过下面的一行代码可以保证 noReturnValue和haveReturnValue均都已经执行完了后, 才执行后续的代码(即, 下面三个控制台的输出)
        CompletableFuture.allOf(noReturnValue, haveReturnValue).join();
        System.out.println("1. result: " + noReturnValue.get());
        System.out.println("2. result: " + haveReturnValue.get());
        System.out.println("done");
    }
}
