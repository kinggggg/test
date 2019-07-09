package com.zeek.javatest.lombok;

import lombok.extern.java.Log;

/**
 * @ClassName LogExample
 * @Description TODO
 * @Author weibo_li
 * @Date 2018/9/5 上午10:16
 **/
@Log
public class LogExample {

    public static void main(String... args) {
        log.info("Something's wrong here");
    }
}

