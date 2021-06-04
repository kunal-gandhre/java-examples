package com.example.sort;

class Node {
	int value;
	Node next;

	public Node(int value) {
		super();
		this.value = value;
		this.next = null;
	}
}

public class LinkedList {
	public Node head = null;
	public Node tail = null;

	public void add(int value) {
		// new node
		Node node = new Node(value);
		if (head == null) {
			// as list is empty both head and tail will have point to same node
			head = node;
			tail = node;
		} else {
			// tail will point next node
			tail.next = node;
			// new node become tail of list
			tail = node;
		}
	}

	public void printList() {
		Node node = head;
		if (node == null) {
			System.out.print("Empty list");
			return;
		}
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	public void sortBubble() {
		Node node = head, index = null;
		if (node == null) return;
		while(node != null) {
			index = node.next;
			while(index != null) {
				if(index.value < node.value) {
					int temp = node.value;
					node.value = index.value;
					index.value = temp;
				}
				index = index.next;
			}
			node = node.next;
		}
	}
	
	public static void main(String[] args) { 
		LinkedList list = new LinkedList();
		list.add(9);
		list.add(1);
		list.add(5);
		list.add(2);
		list.add(6);
		list.add(3);
		System.out.println("Before Sorting");
		list.printList();
		
		list.sortBubble();
		System.out.println("After Sorting");
		list.printList();
	}
}
