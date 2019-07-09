package com.zeek.spring.qualifiertest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: weibo_li
 * @since: 2018-01-02 下午3:42
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringConfig.class)
@ComponentScan(basePackageClasses = SpringConfigTest.class)
public class SpringConfigTest {

//    @Autowired
//    @Platform(Platform.OperatingSystems.ANDROID)
//    private MarketPlace android;
//
//    @Autowired
//    @Platform(Platform.OperatingSystems.IOS)
//    private MarketPlace ios;

    @Test
    public void test0() throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        AppleMarketPlace appleMarketPlace = context.getBean(AppleMarketPlace.class);

    }
}
