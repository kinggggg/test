package com.zeek.spring.qualifiertest;

import org.springframework.stereotype.Component;

/**
 * @author: weibo_li
 * @since: 2018-01-02 下午3:36
 */
@Component
@Platform(Platform.OperatingSystems.ANDROID)
class GoogleMarketPlace implements MarketPlace {

    @Override
    public String toString() {
        return "android";
    }
}
