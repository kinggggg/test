package com.zeek.javatest.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ConditionTest01
 * @Description
 * @Author liweibo
 * @Date 2019/2/21 下午4:52
 * @Version v1.0
 **/
public class ConditionTest01 {

    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        ConditionTest01 test = new ConditionTest01();
        Producer producer = test.new Producer("t1");
        Consumer consumer = test.new Consumer("t2");


        consumer.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producer.start();



        while (true) {

        }
    }

    class Consumer extends Thread{

        Consumer(String name){
            super(name);
        }

        @Override
        public void run() {
            consume();
        }

        private void consume() {

            try {
                lock.lock();
                System.out.println("我在等一个新信号 "+this.currentThread().getName());
                condition.await();
                System.out.println("我在await " + this.currentThread().getName());

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally{
                System.out.println("拿到一个信号 "+this.currentThread().getName());
                lock.unlock();
            }

        }
    }

    class Producer extends Thread{

        Producer(String name){
            super(name);
        }

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            try {
                lock.lock();
                System.out.println("我拿到锁 "+this.currentThread().getName());
                //condition.signalAll();
                System.out.println("我在signalAll " + this.currentThread().getName());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我发出了一个信号： "+this.currentThread().getName());
            } finally{
                lock.unlock();
            }
        }
    }
}
