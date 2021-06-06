package com.example.basic.object;

import java.lang.reflect.Field;

public class ModifyFinalVariable {

	public static void main(String[] aregs) {
		try {
			EmployeeKunal emp = new EmployeeKunal();
			System.out.println(emp);

			Field field = emp.getClass().getDeclaredField("str");
			field.setAccessible(true);

			field.set(emp, "Rahul");

			System.out.println(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class EmployeeKunal {

	private final String str;

	public EmployeeKunal() {
		super();
		str = "Kunal";
	}

	public String getStr() {
		return str;
	}

	@Override
	public String toString() {
		return "Value: " + getStr();
	}
}
