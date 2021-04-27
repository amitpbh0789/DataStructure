package com.test.binarysearchtree;

/**
 * This Node class will be used in all the Binary search tree related logics
 * 
 * @author amit
 *
 */
public class Node {

	Node left;
	Node right;
	int data;
	
	public Node(int data) {
		left = right = null;
		this.data = data;
	}
}
