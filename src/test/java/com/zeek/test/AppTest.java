package com.zeek.test;

import com.zeek.test.service.HelloWorldService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName AppTest
 * @Description
 * @Author liweibo
 * @Date 2019/4/4 2:47 PM
 * @Version v1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

    @Autowired
    HelloWorldService helloWorldService;

    @Test
    public void testAsync() {
        System.out.println("testAsync: =====" + Thread.currentThread().getName() + "=========");
        helloWorldService.asyncMethod("Async");
    }

}
