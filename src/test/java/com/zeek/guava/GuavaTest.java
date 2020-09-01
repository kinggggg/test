package com.zeek.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author liweibo03
 * Created on 2020-09-01
 */
public class GuavaTest {

    private final LoadingCache<String, String> loadingCache1 = CacheBuilder
            .newBuilder().maximumSize(1000).expireAfterAccess(60, TimeUnit.SECONDS)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) {
                    return "world1";
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

        String hello2 = loadingCache2.get("hello");
        System.out.println(hello2);
    }
}
