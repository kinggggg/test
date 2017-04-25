package com.zeek.test.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by weibo_li on 2017/4/1.
 */
public class Log4jTest {

    @Test
    public void test() {
        Logger log4JTestLogger = LoggerFactory.getLogger(Log4jTest.class);
        log4JTestLogger.info("log4JTestLogger info");

        Logger log4JTest2Logger = LoggerFactory.getLogger(Log4jTest2.class);
        log4JTest2Logger.info("log4JTest2Logger info");

    }
}
