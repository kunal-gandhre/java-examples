package com.example.pratise.thread;

class EvenThread implements Runnable {

	Input ip;
	Lock lock;

	public EvenThread(Input ip, Lock lock) {
		this.ip = ip;
		this.lock = lock;
	}

	@Override
	public void run() {
		int index = -1;
		try {
			while ((index = ip.getIndex()) != -1) {
				if ((index % 2 == 0)) {
					System.out.print("\n" + Thread.currentThread().getName() + ": " + index);
				}
				this.lock.unlock();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class OddThread implements Runnable {

	Input ip;
	Lock lock;

	public OddThread(Input ip, Lock lock) {
		this.ip = ip;
		this.lock = lock;
	}

	@Override
	public void run() {
		int index = -1;
		try {
			while ((index = ip.getIndex()) != -1) {
				//System.out.println(" , " + index);
				if (!(index % 2 == 0)) {
					System.out.print("\n" + Thread.currentThread().getName() + ": " + index);
				}
				this.lock.unlock();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class ThreadEvenOdd {

	public static void main(String[] args) throws InterruptedException {
		Input ip = new Input();
		Thread t1 = new Thread(new EvenThread(ip, ip.lock), "Even");
		Thread t2 = new Thread(new OddThread(ip, ip.lock), "Odd");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}

class Input {

	Lock lock = new Lock();;
	int index;

	public Input() {
		index = 0;
	}

	synchronized public int getIndex() throws InterruptedException {
		this.lock.lock();
		if (index >= 15)
			return -1;
		return index++;
	}

}

class Lock {
	private boolean isLocked = false;
	private Thread lockingThread = null;

	public synchronized void lock() throws InterruptedException {
		while (isLocked) {
			wait();
		}
		isLocked = true;
		lockingThread = Thread.currentThread();
	}

	public synchronized void unlock() {
		if (this.lockingThread != Thread.currentThread()) {
			throw new IllegalMonitorStateException("Calling thread has not locked this lock");
		}
		isLocked = false;
		lockingThread = null;
		notify();
	}
}
