package com.zeek.spring.qualifiertest;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: weibo_li
 * @since: 2018-01-02 下午3:34
 */
// the type has to be public!
@Target({ElementType.FIELD,
        ElementType.METHOD,
        ElementType.TYPE,
        ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Platform {

    OperatingSystems value();

    public static enum OperatingSystems {
        IOS,
        ANDROID
    }
}
