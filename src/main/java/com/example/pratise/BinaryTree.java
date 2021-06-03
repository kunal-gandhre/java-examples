package com.example.pratise;

class Node {
	int value;
	Node left, right;

	public Node(int val) {
		this.value = val;
		left = right = null;
	}

}

public class BinaryTree {

	// Root of Binary Tree
	private Node root;

	BinaryTree() {
		root = null;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(12);
		tree.root.right = new Node(9);
		tree.root.left.left = new Node(5);
		tree.root.left.right = new Node(6);

		// left, root, right
		System.out.println("Inorder traversal");
		tree.inorder(tree.root);

		// root, left right
		System.out.println("\nPreorder traversal ");
		tree.preorder(tree.root);

		// left right root
		System.out.println("\nPostorder traversal");
		tree.postorder(tree.root);
	}

	private void postorder(Node node) {
		// left right root
		if (node == null)
			return;
		inorder(node.left);
		inorder(node.right);
		System.out.print(node.value + "->");

	}

	private void preorder(Node node) {
		if (node == null)
			return;
		// root, left right
		System.out.print(node.value + "->");
		inorder(node.left);
		inorder(node.right);

	}

	private void inorder(Node node) {
		if (node == null)
			return;
		// left root right
		inorder(node.left);
		System.out.print(node.value + "->");
		inorder(node.right);
	}

}
