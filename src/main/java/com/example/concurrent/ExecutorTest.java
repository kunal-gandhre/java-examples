package com.example.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {

	public static void main(String[] args) throws Exception {
		/*
		 * Executor executor = new Invoker(); executor.execute( () -> { // task to be
		 * performed System.out.println("performing task"); });
		 */

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		try {
			// blocks until all tasks have completed execution after a shutdown event
			// triggered
			executorService.awaitTermination(20l, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executorService.submit(new Task());

		executorService = Executors.newSingleThreadExecutor();
		Future future = executorService.submit(new Task());
		executorService.shutdown();
		//System.out.println(future.toString()); // EMPTY

		executorService = Executors.newSingleThreadExecutor();
		FactorialTask task = new FactorialTask(5);
		Future<Integer> FactorialTaskFuture = executorService.submit(task);
		Thread.sleep(1000);
		if(FactorialTaskFuture.isDone()) {
			System.out.println("Future value should be 120: actual -> " + FactorialTaskFuture.get().intValue());
		}
		executorService.shutdown();
		
		
		ScheduledExecutorService scheduledExecutorService
	      = Executors.newSingleThreadScheduledExecutor();


	    
		System.exit(0);
	}

}

class FactorialTask implements Callable<Integer> {
	int number;

	// standard constructors

	public Integer call() {
		int fact = 1;
		// ...
		for (int count = number; count > 1; count--) {
			fact = fact * count;
		}

		return fact;
	}

	public FactorialTask(int number) {
		super();
		this.number = number;
	}
}

class Task implements Runnable {
	@Override
	public void run() {
		System.err.println("Task completed");
	}
}

class Invoker implements Executor {
	@Override
	public void execute(Runnable r) {
		r.run();
	}
}
