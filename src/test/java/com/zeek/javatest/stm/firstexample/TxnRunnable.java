package com.zeek.javatest.stm.firstexample;

/**
 * @author: liweibo
 * @since: 2019-09-23 3:06 PM
 */
@FunctionalInterface
interface TxnRunnable {
    void run(Txn txn);
}
