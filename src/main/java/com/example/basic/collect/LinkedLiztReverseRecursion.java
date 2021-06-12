package com.example.basic.collect;

class LinkedLizt<T> {

	Node<T> root;

	public void add(T value) {
		Node<T> newNode = new Node<T>(value);
		Node<T> node = root;
		if (node == null) {
			this.root = newNode;
			return;
		}
		while (node.next != null) {
			node = node.next;
		}
		node.next = newNode;
	}

	public Node<T> reverse(Node<T> node) {

		if (node == null || node.next == null) {
			return node;
		}

		Node<T> newHeadNode = reverse(node.next);

		// change references for middle chain
        node.next.next = node;
        node.next = null;

        // send back new head node in every recursion
        return root = newHeadNode;
	}

	public void print(Node<T> node) {
		if (node == null) {
			return;
		}
		System.out.print(" " + node.value);
		print(node.next);
	}

	private class Node<T> {
		T value;
		Node<T> next;

		Node(T value) {
			this.value = (T) value;
			this.next = null;
		}
	}
}

public class LinkedLiztReverseRecursion {

	public static void main(String[] args) {
		LinkedLizt<Integer> list = new LinkedLizt<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(" Init");
		list.print(list.root);
		
		list.reverse(list.root);
		
		System.out.println(" \n After Reverse");
		list.print(list.root);
		
		list.add(4);
		System.out.println(" \n Added 4");
		list.print(list.root);
		
		list.reverse(list.root);
		System.out.println(" \n Reverse");
		list.print(list.root);
	}
}
