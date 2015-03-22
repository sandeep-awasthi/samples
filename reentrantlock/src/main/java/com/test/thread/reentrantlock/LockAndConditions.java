package com.test.thread.reentrantlock;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAndConditions {
	private final ArrayList<Integer> sharedQueue = new ArrayList<Integer>();
	private final int limit = 1;
	private final Lock queueLock = new ReentrantLock();
	private final Condition queueFull = queueLock.newCondition();
	private final Condition queueEmpty = queueLock.newCondition();
	
	
	public static void main(String args[]) {
		
		LockAndConditions lockAndConditions = new LockAndConditions();
		Thread producer = new Thread(lockAndConditions.new Producer());
		Thread consumer = new Thread(lockAndConditions.new Consumer());
		producer.start();
		consumer.start();
		
	}

	class Producer implements Runnable {

		
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					produce(i);
					Thread.sleep(300);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}

			}
		}

		private void produce(int i) throws InterruptedException {
			queueLock.lock();
			try {
				while (sharedQueue.size() == limit) {
					queueFull.await();
				}
				sharedQueue.add(i);
				System.out.println("Produced: " + i);
				queueEmpty.signalAll();
				
			} finally {
				queueLock.unlock();
			}
		}
	}

	class Consumer implements Runnable {

		public void run() {
			while (true) {
				try {
					 consume();
					Thread.sleep(100);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}

			}
		}

		private int consume() throws InterruptedException {
			queueLock.lock();
			try {
				while (sharedQueue.isEmpty()) {
					queueEmpty.await();
				}
				Integer ret = sharedQueue.remove(0);
				System.out.println("Consumed "+ret);
				queueFull.signalAll();
				return ret ;
			} finally {
				queueLock.unlock();
			}

		}
	}

}