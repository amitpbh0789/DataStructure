package com.test.binarysearchtree;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversal-set-2/
 * 
 * @author amit
 *
 */
public class CreateBSTFromPreOrder {

	Node root;

	public CreateBSTFromPreOrder() {
		root = null;
	}

	public static void main(String[] args) {

		CreateBSTFromPreOrder tree = new CreateBSTFromPreOrder();
		int[] preOrderArr = {10, 5, 1, 7, 40, 50};
		int size = preOrderArr.length;
		Node root = tree.createBST(preOrderArr, size);
		tree.printInorder(root);
	}

	private Node createBST(int[] preOrderArr, int size) {

		if(size==0) {
			return null;
		}
		Node root = new Node(preOrderArr[0]);
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		
		for(int i=1; i<size; i++) {
			
			Node temp =null;
			
			while(!stack.isEmpty() && preOrderArr[i]>stack.peek().data) {
				temp = stack.pop();
			}
			
			if(temp !=null) {
				temp.right = new Node(preOrderArr[i]);
				stack.push(temp.right);
			}
			
			else {
				temp = stack.peek();
				temp.left = new Node(preOrderArr[i]);
				stack.push(temp.left);
			}
		}
		
		return root;
	}
	
	private void printInorder(Node root) {
		
		if(root != null) {
			printInorder(root.left);
			System.out.println(root.data +" ");
			printInorder(root.right);
		}
	}

}
