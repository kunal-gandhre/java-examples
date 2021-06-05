package com.example.basic.object;

public interface ExampleInterfaces {
	
	public void foo();
	
	default void print() {
		System.out.println("Hello From interface");
	}
	
	public static void printMeAlso() {
		System.out.println("Hello From interface");
	}
	
	public static void printMeAlsoToo() {
		System.out.println("Hello From interface");
	}
	
	interface NewInterface {
		
	}
}