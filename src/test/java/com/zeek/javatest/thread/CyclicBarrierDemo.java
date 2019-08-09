package com.zeek.javatest.thread;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
/**
 * 
 * ClassName: CyclicBarrierDemo
 * @author lvfang
 * @Desc: TODO
 * @date 2018-2-2
 * 
 * CyclicBarrier
 * 	     一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)。在涉及一组固定
 * 大小的线程的程序中，这些线程必须不时地互相等待，此时 CyclicBarrier 很有用。因为该 barrier 在释放等待线
 * 程后可以重用，所以称它为循环 的 barrier。
 */
public class CyclicBarrierDemo{
	public static class Soldier implements Runnable {
		private String soldier;//士兵
		private final CyclicBarrier cyclic;//计数器
		
		Soldier(CyclicBarrier cyclic,String soldierName) {
			this.cyclic = cyclic;
			this.soldier = soldierName;
		}

		public void run() {
			try {
				//阻塞：等待所有士兵到齐
				cyclic.await();
				
				doWork();//执行任务
				
				//等待所有士兵完成工作
				cyclic.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		void doWork(){
			try {
				Thread.sleep(Math.abs(new Random().nextInt()%10000));
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(soldier + ": 任务完成");
		}
	}
	
	public static class BarrierRun implements Runnable {
		boolean falg;
		int n;
		public BarrierRun(boolean falg,int n){
			this.falg = falg;
			this.n = n;
		}

		public void run() {
			if(falg){
				System.out.println("司令:[士兵" + n + "个，任务完成！]");
			}else{
				System.out.println("司令:[士兵" + n + "个，集合完成！]");
				falg = true;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		final int n = 10;
		Thread[] allSoldier = new Thread[n];
		boolean falg = false;
		CyclicBarrier cyclic = new CyclicBarrier(n, new BarrierRun(falg, n));//个数，任务线程
		//设置屏障点，主要是为了执行这个方法
		System.out.println("集合队伍!");
		for(int i=0;i<n;i++){
			Thread.sleep(500);
			System.out.println("士兵" + i + "报道！");
			allSoldier[i] = new Thread(new Soldier(cyclic, "士兵" + i));
			//虽然这里开启了线程，但是得确保所有士兵到达才能执行任务
			allSoldier[i].start();
//			if(i==5){
//				allSoldier[0].interrupt();
//			}
		}
	}
}
