package com.zeek.test.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by weibo_li on 2017/4/1.
 */
public class Log4jTest {

    Logger logger = LoggerFactory.getLogger(Log4jTest.class);

    @Test
    public void test() {
        logger.info("info");

    }
}
