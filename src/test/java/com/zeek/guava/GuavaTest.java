package com.zeek.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author liweibo03
 * Created on 2020-09-01
 */
public class GuavaTest {

    private final LoadingCache<String, String> loadingCache1 = CacheBuilder
            .newBuilder()
            .maximumSize(1000)
            .expireAfterAccess(5, TimeUnit.SECONDS)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) {
                    String value = "world: " + new Random().nextInt();
                    System.out.println("当前值: " + value);
                    return value;
                }
            });

    private final LoadingCache<String, String> loadingCache2 = CacheBuilder
            .newBuilder().maximumSize(1000).expireAfterAccess(60, TimeUnit.SECONDS)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) {
                    return "world2";
                }
            });

    @Test
    public void testLoad() throws ExecutionException {

        String hello1 = loadingCache1.get("hello");
        System.out.println(hello1);

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hello1 = loadingCache1.get("hello");
        System.out.println(hello1);

        String hello2 = loadingCache2.get("hello");
        System.out.println(hello2);

        for (int i = 0; i < 100000; i++) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
