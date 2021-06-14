package com.example.problems;

public class SecondLargestNumberInArray {

	static int[] arr = { 12, 35, 1, 10, 34, 1 };

	public static void main(String[] args) {
		int first, second;
		first = second = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > first) {
				second = first;
				first = arr[i];
				/*
				 * If arr[i] is in between first and second then update second
				 */
			} else if (arr[i] != first && second < arr[i]) {
				second = arr[i];
			}
		}

		if (second == Integer.MIN_VALUE)
			System.out.print("There is no second largest" + " element\n");
		else
			System.out.print("The second largest element" + " is " + second);

	}

}
