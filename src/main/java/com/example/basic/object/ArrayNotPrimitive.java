package com.example.basic.object;

// referece : https://www.geeksforgeeks.org/array-primitive-type-object-java/
public class ArrayNotPrimitive {
	
	public static void main(String[] args) {
		int[] arr1 = new int[3];
		float[] arr2 = new float[3];
		double[] arr3 = new double[3];
		int[] arr4 = new int[3];
		int[][] arr5 = new int[1][1];
		
		System.out.println(arr1.getClass().getName());
		System.out.println(arr2.getClass().getName());
		System.out.println(arr3.getClass().getName());
		System.out.println(arr4.getClass().getName());
		System.out.println(arr5.getClass().getName());
	}

}
