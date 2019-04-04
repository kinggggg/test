package com.zeek.test.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ClassName HelloWorldService
 * @Description
 * @Author liweibo
 * @Date 2019/4/4 2:48 PM
 * @Version v1.0
 **/
@Service
public class HelloWorldService {

    @Async
    public void asyncMethod(String arg) {
        System.out.println("arg:" + arg);
        System.out.println("asyncMethod: =====" + Thread.currentThread().getName() + "=========");
    }
}
