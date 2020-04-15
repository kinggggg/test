package com.zeek.javatest.stm.firstexample;

/**
 * @author: liweibo
 * @since: 2019-09-23 3:06 PM
 */
// 事务接口
interface Txn {
    <T> T get(TxnRef<T> ref);
    <T> void set(TxnRef<T> ref, T value);
}
