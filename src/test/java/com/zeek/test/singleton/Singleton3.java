package com.zeek.test.singleton;

// Holder模式
// ThreadSafe
public class Singleton3 {
    private static class SingletonHolder {
        private static final Singleton3 singleton = new Singleton3();
        private SingletonHolder() {
        }
    }
    private Singleton3() {
    }
    public synchronized static Singleton3 getInstance() {
        return SingletonHolder.singleton;
    }
}

