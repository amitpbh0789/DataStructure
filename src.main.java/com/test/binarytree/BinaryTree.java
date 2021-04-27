package com.test.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	
	static Node root;
	
	BinaryTree(int data){
		root = new Node(data);
	}
	
	BinaryTree(){
		root = null;
	}

	public static void main(String[] args) {
		
		root = new Node(5);
		
		root.left = new Node(3);
		root.right = new Node(10);
		root.left.left = new Node(8);
		
		int key = 12; 
		inorderTraversal(root);
        insert(root, key); 
        System.out.println("Print nodes in inorder after insertion");
        inorderTraversal(root);
        System.out.println("Preorder traversal");
        preOrderTRaversal(root);
        System.out.println("Postorder traversal");
        postorder(root);
        
        System.out.println("inorderWithoutRecursion");
        inorderWithoutRecursion(root);
	}
	
	public static void insert(Node root, int key) {
		Node temp = root;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(temp);
		
		while(!queue.isEmpty()) {
			
			temp = queue.peek();
			queue.remove();
			
			if(temp.left == null) {
				temp.left = new Node(key);
				break;
			}else {
				queue.add(temp.left);
			}
			
			if(temp.right == null){
				temp.right = new Node(key);
				break;
			}else {
				queue.add(temp.right);
			}
		}
		
		System.out.println("Node inserted into Binary Tree");
	}
	
	public void deleteKey(Node root, int key) {
		
	}
	
	public static void inorderTraversal(Node root) {
		if(root == null) {
			return;
		}
		
		inorderTraversal(root.left);
		System.out.println(root.data);
		inorderTraversal(root.right);
	}
	
	public static void preOrderTRaversal(Node root) {
		
		if(root == null){
			return;
		}
		System.out.println(root.data);
		preOrderTRaversal(root.left);
		preOrderTRaversal(root.right);
	}
	
	public static void postorder(Node root) {
		if(root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.data);
	}
	
	public static void inorderWithoutRecursion(Node root) {
		
		if(root == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		Node current = root;
		
		while(current != null || stack.size()>0) {
			
			while(current != null) {
				
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			System.out.println(current.data);
			current = current.right;
		}
	}
}
