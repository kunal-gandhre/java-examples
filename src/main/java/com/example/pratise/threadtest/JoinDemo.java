package com.example.pratise.threadtest;

//Java program to illustrate join() method in Java

public class JoinDemo {

	public static void main(String args[]) throws Exception {
		Thread t = new Thread(new Task());
		t.setName("T1");

		Thread t2 = new Thread(new Task());
		t.setName("T2");

		// Waits for 1000ms this thread to die.
		t2.join(1000);
		
		t2.start();
		t.start();

		System.out.println("\nJoining after 1000" + " mili seconds: \n");

		// Checks if this thread is alive
		System.out.println("Is T1 alive? " + t.isAlive());
		System.out.println("Is T2 alive? " + t2.isAlive());
	}
}

class Task implements Runnable {

	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("Current thread: " + t.getName());

		// checks if current thread is alive
		System.out.println("Is Alive? " + t.isAlive());
	}
}