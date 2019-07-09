package com.zeek.javatest.lombok;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName LogExampleOther
 * @Description TODO
 * @Author weibo_li
 * @Date 2018/9/5 上午10:17
 **/
@Slf4j
public class LogExampleOther {

    public static void main(String... args) {
        log.error("Something else is wrong here");

        System.out.println(log);
    }
}
