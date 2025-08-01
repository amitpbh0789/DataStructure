package com.test.leetcode.medium.locked.LinkedList;

/**
 * 
 * Step1: Create 2 Node assuming as Head and Tail of the Doubly linked List
 * Step2:  
 */
public class BST_To_SortedDoublyLinkedList {
	ListNode head = null;
	ListNode tail = null;
	
	public ListNode treeToDoublyList(ListNode root) {
		if(root == null) {
			return null;
		}
		
		// Process 
		helper(root);
		
		// Now connect tail to head head prev ref to Tail
		tail.right = head;
		head.left = tail;
		
		return head;
		
	}
	// Actual Implementation 
	private void helper(ListNode root) {
		if(root == null) {
			return;
		}
		
		// left traversal
		helper(root.left);
		
		// setting up the list
		if(tail != null) {
			tail.right = root;
			root.left = tail;
		} else {
			head = root;
		}
		// making node as tail
		tail = root;
		
		// right subtree traversal
		helper(root.right);
		
	}
}

class ListNode{
	public int val;
    public ListNode left;
    public ListNode right;
   
    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }
}
