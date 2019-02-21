package com.zeek.javatest.thread;

import javax.security.auth.login.Configuration;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockTest01
 * @Description
 * @Author liweibo
 * @Date 2019/2/21 下午4:26
 * @Version v1.0
 **/
public class LockTest01 {

    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private Lock lock = new ReentrantLock();    //注意这个地方
    public static void main(String[] args)  {
        final LockTest01 test = new LockTest01();

        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();

        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
    }

    public void insert(Thread thread) {
        lock.lock();
        try {
            System.out.println(thread.getName()+"得到了锁");
            Thread.sleep(2000);
            for(int i=0;i<5;i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            System.out.println(thread.getName()+"释放了锁");
            lock.unlock();
        }
    }

}

