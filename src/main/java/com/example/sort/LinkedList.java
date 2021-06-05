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

	/*
	 * we maintain two pointers: current and index.
	 * 
	 * Initially, current point to head node and index will point to node next to
	 * current. Traverse through the list till current points to null, by comparing
	 * current’s data with index’s data. And for each current’s value, index is the
	 * next to current node which traverse from current’s next node till null. And
	 * then the value of current node is compared with every value from its next
	 * node till last and if the value is smaller than the current value, then the
	 * values are swapped and in this way the least value comes as current index.
	 */

	// Time complexity: O(n ^ 2)
	// Space complexity: O(1)
	public void sortBubble() {
		Node node = head, index = null;
		if (node == null)
			return;
		while (node != null) {
			index = node.next;
			while (index != null) {
				if (index.value < node.value) {
					int temp = node.value;
					node.value = index.value;
					index.value = temp;
				}
				index = index.next;
			}
			node = node.next;
		}
	}

	/*
	 * In the Insertion sort technique, we assume that all the elements before the
	 * current element in the list is already sorted, and we begin with the current
	 * element. The current element is compared with all the elements before it and
	 * swapped if not in order. This process is repeated for all the subsequent
	 * elements. In general, the Insertion sort technique compares each element with
	 * all of its previous elements and sorts the element to place it in its proper
	 * position.
	 */
	// Time complexity: O(n ^ 2)
	// Space complexity: O(1)
	public void sortInsertion() {

	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(9);
		list.add(-1);
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
