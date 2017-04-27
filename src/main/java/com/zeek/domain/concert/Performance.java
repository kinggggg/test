package com.zeek.domain.concert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by weibo_li on 2017/4/26.
 */
public class Performance {

    final Logger logger  =  LoggerFactory.getLogger(Performance.class );

    public void perform() {
        logger.warn("=======================>Performance.perform()");
    }
}
