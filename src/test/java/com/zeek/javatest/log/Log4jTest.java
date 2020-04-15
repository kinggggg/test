package com.zeek.javatest.log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

/**
 * Created by weibo_li on 2017/4/1.
 */
public class Log4jTest {

    @Test
    public void test2() {

        PropertyConfigurator.configure(this.getClass().getClassLoader()
                .getResourceAsStream("log4j.properties"));

        Logger log=Logger.getLogger("cd.itcast.log");
        log.debug("log debug..");
        log.info("log info..");

    }

    @Test
    public void test1() {
        BasicConfigurator.configure();

        Logger logger = Logger.getLogger("cd.itcast");
        logger.getLoggerRepository().setThreshold(Level.INFO);
//        logger.setLevel(Level.WARN);
        Logger barLogger = Logger.getLogger("cd.itcast.log");
        barLogger.setLevel(Level.WARN);

        logger.warn("logger warn");
        logger.info("logger info");
        logger.debug("logger debug");
        barLogger.warn("bar logger warn");
        barLogger.info("bar logger info");
        barLogger.debug("bar logger debug");

    }


}
