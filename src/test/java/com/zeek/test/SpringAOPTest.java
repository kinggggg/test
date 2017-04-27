package com.zeek.test;

import com.zeek.domain.User;
import com.zeek.domain.concert.Audience;
import com.zeek.domain.concert.Performance;
import com.zeek.domain.concert.Performance2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by weibo_li on 2017/4/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringAOPTest {

    final Logger logger  =  LoggerFactory.getLogger(SpringAOPTest.class );

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test2() {

        Audience bean = applicationContext.getBean(Audience.class);

        Performance performance = (Performance)applicationContext.getBean("performance");
        performance.perform();

        Performance2 performance2 = (Performance2)applicationContext.getBean("performance2");
        performance2.perform();
    }

    @Test
    public void test1() {

        User user = (User) applicationContext.getBean(User.class);
        logger.info(user.toString());
    }
}
