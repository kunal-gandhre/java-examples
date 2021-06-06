package com.example.problems;

public class MissingNumber {

	public static void main(String[] args) {

		// 1st
		int[] array = { 1, 2, 3, 4, 6 };
		find(array, 6);
		
		int[] array1 = { 1, 3, 2, 6, 5 };
		find(array1, 6);
		

	}

	public static int find(int[] array, int n) {
		System.out.print("\nArray ");
		n = n -1;
		int total = (n + 1) * (n + 2) / 2;
		for (int num : array) {
			System.out.print(" " + num );
			total -= num;
		}
		System.out.print(" => Missing:" + total);
		return total;
	}

}
