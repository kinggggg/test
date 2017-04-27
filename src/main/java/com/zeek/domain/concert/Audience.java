package com.zeek.domain.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by weibo_li on 2017/4/26.
 */
@Aspect
public class Audience {

    final Logger logger  =  LoggerFactory.getLogger(Audience.class );

    @Before("execution(** com.zeek.domain.concert.Performance.perform(..))")
    public void silenceCellPhones() {
        logger.warn("before===================>: silenceCellPhones");
    }
}
