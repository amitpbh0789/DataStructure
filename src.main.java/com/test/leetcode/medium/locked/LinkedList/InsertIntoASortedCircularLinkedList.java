package com.test.leetcode.medium.locked.LinkedList;

/**
 * Cases explained here: https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/editorial/
 * 
 * Idea: Will have 2 pointer approach. Here we need to handle 4 different cases
 * Case1: If key is in between current and prev node in sorted order e.g. 5 -> key(6) --> 7
 * Case2.1: key is greater then prev and also greate rthan curr e.g. 9 --> key(10) --> 1
 * Case2.2: key is Key is greater than prev and less than curr e.g. 9 --> key(0) --> 1
 * Case4: Key is greater than prev and curr both e.g. 3 --> key(10) --> 3
 * 
 * Idea: Will have 2 pointer head as prev and head.next as curr. Now will process and see where these condtion fits and inseert accordingly
 * 
 */
public class InsertIntoASortedCircularLinkedList {

	public static void main(String[] args) {
		
	}
	
	public Node insert(Node head, int val) {
		
		if(head == null) {
			Node node = new Node(val);
			node.next = node;
			return node;
		}
		
		Node prev = head;
		Node curr = head.next;
		boolean toInsert = false;
		
		do {
			if(val >= prev.val && val <= curr.val) {// Case #1
				toInsert = true;
			} else if(prev.val > curr.val) {
				if(val>= prev.val || val <= curr.val) { // case #2 and #3
					toInsert = true;
				}
			}
			
			if(toInsert) {
				prev.next = new Node(val, curr);
				return head;
			}
			
			prev = curr;
			curr = curr.next;
		} 
		while(prev != head);
		
		// Case #4
		prev.next = new Node(val, curr);
		return head;
	}
}







class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}