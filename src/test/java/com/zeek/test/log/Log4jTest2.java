package com.zeek.test.log;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;

/**
 * Created by weibo_li on 2017/4/1.
 */
public class Log4jTest2 {

    @Test
    public void test1() {

        DOMConfigurator.configure("log4j.xml");

        Logger log = Logger.getLogger("cd.itcast.log");
        log.debug("log debug..");
        log.info("log info..");
    }
}
