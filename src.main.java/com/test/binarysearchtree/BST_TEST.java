package com.test.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class BST_TEST {

	Node root;
	int index = 0;

	public BST_TEST() {
		root = null;  
	}

	public static void main(String[] args) {


		BST_TEST bst = new BST_TEST();
		bst.insertNode(50); 
		bst.insertNode(30); 
		bst.insertNode(20); 
		bst.insertNode(40); 
		bst.insertNode(70); 
		bst.insertNode(60); 
		bst.insertNode(80); 

		System.out.println("BST created");

		System.out.println("Find Kth smallest element from the tree");
		System.out.println(bst.findKthElement(bst.root, 2));

		System.out.println("Find Kth largest element from the tree");
		System.out.println(bst.findKthLargestElement(bst.root, 3));


		System.out.println("Check if each internal node of a BST has exactly one child");
		System.out.println(bst.hasOnlyOneChild(bst.root));

		int[] arr = {19, 23, 25, 30, 45};

		System.out.println("Check if an array represents Inorder of Binary Search tree or not");
		System.out.println(bst.isInorder(arr, 5));

		System.out.println("Largest number in BST which is less than or equal to N");
		System.out.println(bst.findMaxForN(bst.root, 25));


		int inOrder[] = {4, 2, 5, 1, 3};  
		int preOrder[] = {1, 2, 4, 5, 3};

		//	    Construct binary tree;
		
		bst.constructBinaryTree(inOrder, preOrder);
		
		
		System.out.println("\nDelete 20"); 
		bst.deleteKey(bst.root,20); 

	}


	private void insertNode(int val) {
		root = insertRec(root, val);
	}

	private Node insertRec(Node root, int val) {

		if(root == null) {
			root = new Node(val);
			return root;
		}

		if(val<root.data) {
			root.left = insertRec(root.left, val);
		}else if(val>root.data){
			root.right = insertRec(root.right, val);
		}
		return root;
	}

	private int findKthElement(Node root, int kth) {
		List<Integer> list = new ArrayList<>();
		inorder(root, list);
		return list.get(kth-1);

	}

	private void inorder(Node root, List<Integer> list){

		if(root != null) {
			inorder(root.left, list);
			list.add(root.data);
			inorder(root.right, list);
		}
	}


	private int findKthLargestElement(Node root, int kth) {

		List<Integer> list = new ArrayList<>();
		inorder(root, list);
		return list.get(list.size()-kth);

	}

	private boolean hasOnlyOneChild(Node root) {

		//		Recursive
		//		if(root != null) {
		//			
		//			if(root.left!= null && root.right != null)
		//				return false;
		//			hasOnlyOneChild(root.left);
		//			hasOnlyOneChild(root.right);
		//			
		//		}
		//		
		//		return true;


		while(root != null) {

			if(root.left!= null && root.right != null)
				return false;

			if(root.left== null && root.right == null)
				break;
			if(root.left != null)
				root = root.left;
			if(root.right != null)
				root = root.right;

		}

		return true;
	}

	private boolean isInorder(int[] arr, int length) {
		if(length<=1)
			return true;

		for(int i=0; i<length-1; i++) {
			if(arr[i]>arr[i+1])
				return false;
		}

		return true;
	}

	private int findMaxForN(Node root, int num) {

		if(root == null)
			return -1;

		if(root.data == num)
			return root.data;

		if(num>root.data) {
			int k = findMaxForN(root.right, num);
			if(k == -1)
				return root.data;
			else
				return k;
		}else if(num<root.data) {
			return findMaxForN(root.left, num);
		}

		return -1;
	}

	private Node constructBinaryTree(int[] in, int[] pre) {

		return construct(in, pre, 0, in.length-1);

	}

	private Node construct(int[] in, int[] pre, int start, int end) {

		if(start>end)
			return null;

		Node rootNode = new Node(pre[index++]);

		if(start == end)
			return rootNode;

		//		find root node index in inorder
		int rootIndex = findNodeIndex(in, rootNode.data);
		
		rootNode.left = construct(in, pre, start, rootIndex-1);
		rootNode.right = construct(in, pre, rootIndex+1, end);

		return rootNode;
	}

	private int findNodeIndex(int in[], int nodeValue) {

		for(int i=0; i<in.length-1; i++) {
			if(in[i] == nodeValue)
				return i;
		}
		return -1;

	}
	
	
	private Node deleteKey(Node root, int key) {
		
		if(root == null)
			return null;
		if(key<root.data)
			root.left = deleteKey(root.left, key);
		else if (key>root.data) {
			root.right = deleteKey(root.right, key);
		}else {
			if(root.left == null)
				return root.right;
			if(root.right == null)
				return root.left;
			Node minNode = minNode(root.right);
			root.data = minNode.data;
			deleteKey(root.right, minNode.data);
		}
		return root;
	}
	
	public Node minNode(Node root) {
		while(root.left != null)
			root = root.left;
		return root;
	}
	
}
