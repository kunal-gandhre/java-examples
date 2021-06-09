package com.example.ds.question;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	private Queue<Integer> q1 = null;
	private Queue<Integer> q2 = null;

	StackUsingQueue() {
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}

	public void stack(int i) {
		getDataQueue().add(i);
	}

	private Queue<Integer> getDataQueue() {
		if (!q1.isEmpty()) {
			return q1;
		} else if (!q2.isEmpty()) {
			return q2;
		} else {
			return q1;
		}
	}

	private Queue<Integer> getEmpty() {
		if (q1.isEmpty()) {
			return q1;
		} else if (q2.isEmpty()) {
			return q2;
		} else {
			return q2;
		}
	}

	private int pop() {
		Queue<Integer> empty = getEmpty();
		Queue<Integer> full = getDataQueue();
		stack(-1);
		int cr = -1;
		int last = -1;
		do {
			cr = full.remove();
			if (cr != -1 && last != -1) {
				empty.add(last);
			}
			if (last == -1 && cr != -1) {
				last = cr;
			}
			if (cr != -1) 	last = cr;
		} while (cr != -1);
		return last;
	}

	public void printData() {

		if (q2.isEmpty()) {
			System.out.println(q1.toString());
		} else {
			System.out.println(q2.toString());
		}

	}

	public static void main(String[] args) {
		StackUsingQueue obj = new StackUsingQueue();
		obj.stack(1);
		obj.stack(2);
		obj.stack(3);
		obj.stack(4);
		obj.printData();
		System.out.println(obj.pop());
		obj.printData();
		System.out.println(obj.pop());
		obj.printData();
		obj.stack(9);
		obj.stack(7);
		obj.printData();
		System.out.println(obj.pop());
		obj.printData();
	}
}
