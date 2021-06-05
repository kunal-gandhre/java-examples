package com.example.design.patterns;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakSingleton {

	public static void main(String[] args) {
		Singleton one = Singleton.getInstance();
		Singleton two = Singleton.getInstance();
		Singleton three = null;
		System.out.println(one.s);
		// changing variable of instance x
		two.s = (two.s).toUpperCase();
		System.out.println(one.s);

		try {
			// Lets break singleton
			Constructor[] contructors = Singleton.class.getDeclaredConstructors();
			for (Constructor cont : contructors) {
				cont.setAccessible(true);
				three = (Singleton) cont.newInstance();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(one.hashCode());
		System.out.println(two.hashCode());
		System.out.println(three.hashCode());
		
		// Using ENUM
		EnumSingleton secondEnumInst = EnumSingleton.INSTANCE;
		System.out.println("1st Enum hashcode " + EnumSingleton.INSTANCE.hashCode());
		System.out.println("2nd Enum hashcode " + secondEnumInst.hashCode());
	}
}

class Singleton {

	private static Singleton instance;

	// variable of type String
	public String s;

	public String get() {
		return s;
	}

	// Make constructor as private.
	private Singleton() {
		super();
		s = "Singleton";
	}

	// lazy inialization

	// static method to create instance of Singleton class
	public static Singleton getInstance() {
		if (instance == null)
			instance = new Singleton();
		return instance;
	}
}

//Java program for Enum type singleton
enum EnumSingleton {
	INSTANCE;
	public String val;
	
	EnumSingleton(){
		this.val = "You cant break me";
	}
}
