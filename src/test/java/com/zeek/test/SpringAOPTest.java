package com.zeek.test;

import com.zeek.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by weibo_li on 2017/4/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringAOPTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test2() {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        User user = (User) classPathXmlApplicationContext.getBean("user");
        System.out.println(user);
    }

    @Test
    public void test1() {

        User user = (User) applicationContext.getBean(User.class);
        System.out.println(user);
    }
}
