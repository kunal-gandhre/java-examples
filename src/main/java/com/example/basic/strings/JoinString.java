package com.example.basic.strings;

public class JoinString {

	public static void main(String[] args) {

		String[] str = { "Apple", "Orange" };
		System.out.println(joinStrings(str));

		String[] str1 = { "Apple", "Orange", "Banana" };
		System.out.println(joinStrings(str1));
		
		String[] str3 = { "Apple", "Orange", "Banana", "Kiwi"};
		System.out.println(joinStrings(str3));

	}

	public static String joinStrings(String[] str) {
		String result = "";
		for (int i = 0; i < str.length; i++) {

			if (i == (str.length) - 1) {
				result = result + " and " + str[i];
			} else if (i == (str.length) - 2) {
				result = result + str[i];
			} else {
				result = result + str[i] + ", ";
			}

		}
		return result;
	}

}
