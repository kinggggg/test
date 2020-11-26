package com.zeek.javatest.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2020-11-26
 */
public class CompletableFutureTest4 {

    public static void main(String[] args) throws Exception {
        thenCombine();
    }

    private static void thenCombine() throws Exception {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "hello";
            }
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "world";
            }
        });
        // future1.thenCombine(future2 与 future2.thenCombine(future1 顺序不同会导致t和u的值不同;
        // 即, future1的结果对应t, future2的结果对应u
        CompletableFuture<String> result = future1.thenCombine(future2, new BiFunction<String, String, String>() {
            @Override
            public String apply(String t, String u) {
                return t+" "+u;
            }
        });
        System.out.println(result.get());
    }
}
