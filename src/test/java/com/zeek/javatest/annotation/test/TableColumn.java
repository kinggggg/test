package com.zeek.javatest.annotation.test;

public @interface TableColumn {
    int type() default 0;

    Color color() ;
}
