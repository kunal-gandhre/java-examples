package com.example.pratise;

public class InstanceCounter {

	public static void main(String[] args) {
		Car a = new Car();
		Car.printInstanceCount();
		new Car();
		Car.printInstanceCount();
		a = new Car();
		Car.printInstanceCount();
		Car c = new Car();
		Car.printInstanceCount();
		
	}

}

class Car {
	public static int count = 0;

	Car() {
		count++;
	}

	public static void printInstanceCount() {
		System.out.println(count);
	}

}
