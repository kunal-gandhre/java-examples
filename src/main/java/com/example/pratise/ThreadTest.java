package com.example.pratise;

import java.util.Scanner;

public class ThreadTest {

	public static void main(String[] args) throws Exception {
		final Pauser p = new Pauser();
		Thread test = new Thread() {
			@Override
			public void run() {
				System.err.println("Waiting");
				p.pause();
				try {
					System.err.println("sleep");
					Thread.sleep(100000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.err.println("Resume");
			}
		};

		test.start();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 1 number");
		String nextLine = in.nextLine();
		switch (nextLine) {
		case "1":
			p.resume();
			break;
		case "2":
			p.pause();
			break;
		case "3":
			p.waitIfPaused();
			break;
		default:
			break;
		}
	}
}

class Pauser {

	boolean isPaused;

	public synchronized void pause() {
		isPaused = true;
	}

	public synchronized void resume() {
		isPaused = false;
		notifyAll();
	}

	public synchronized void waitIfPaused() throws InterruptedException {
		while (isPaused) {
			wait();
		}
	}
};