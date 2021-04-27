package com.test.binarysearchtree;

public class ValidateBinarySearchTree {

	Node1 root;
	
	public ValidateBinarySearchTree(){
		this.root = null;
	}
	public static void main(String[] args) {
		ValidateBinarySearchTree bst = new ValidateBinarySearchTree();
		bst.insert(2);
		bst.insert(1);
		bst.insert(3);
		
		System.out.println(bst.isValidBST(bst.root));
	}
	
	/**
	 * We need to make sure each node is valid by comparing its pre nodes.
	 * We don't validate node against children because it may be valid of that node but down the line subtrees might not be bst
	 * @param root
	 * @return
	 */
	public boolean isValidBST(Node1 root) {
		return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	public boolean isValid(Node1 root, long min, long max) {
		if(root == null) //if be go down time the end then means tree is valid
			return true;
		
		if(root.val>=max || root.val<=min) //condition to check if node is valid. return false if not
			return false;
		
//		Keep on checking each node against min and max defined for that node.
		return isValid(root.left, min, root.val) && isValid(root.right, root.val, max); 
		
	}
	
	public void insert(int val) {
		root = insertRec(root, val);
	}
	
	public Node1 insertRec(Node1 node, int val) {
		if(node == null) {
			node = new Node1(val);
			return node;
		}
		if(val<node.val)
			node.left = insertRec(node.left, val);
		if(val>node.val)
			node.right = insertRec(node.right, val);
		
		return node;
		
	}
}

class Node1{
	int val;
	Node1 left;
	Node1 right;
	public Node1(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}
