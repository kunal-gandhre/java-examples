package com.example.pratise;


class WaitAndSleep {

	private static final ThreadB b = new ThreadB();

    public static void main(String... args) throws InterruptedException {
    	System.err.println("start " + System.currentTimeMillis());
        b.start();

        synchronized (b) {
            while (b.sum == 0) {
            	System.out.println("Waiting for ThreadB to complete...");
                b.wait(10000);
            }
            System.out.println("ThreadB has completed. Sum from that thread is: " + b.sum);
            System.err.println("end " + System.currentTimeMillis());
        }
    }
    
	private static void sleepWaitExamples(Object obj) throws InterruptedException {

		Thread.sleep(1000);
		System.out.println("Thread '" + Thread.currentThread().getName() + "' is woken after sleeping for 1 second");

		synchronized (obj) {
			obj.wait(1000);
			System.out.println("Object '" + obj + "' is woken after" + " waiting for 1 second");
		}
	}
}

class ThreadB extends Thread {
    int sum;

    @Override
    public void run() {
        synchronized (this) {
            int i = 0;
            while (i < 100000) {
                sum += i;
                i++;
            }
            notify();
        }
    }
}
