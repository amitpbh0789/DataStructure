package com.test.linkedlist;

public class RemoveDuplicateFromLinkedList {

	public static void main(String[] args) {
		Node head = new Node();
		Node one = new Node(1); 
	    Node two = new Node(2); 
	    Node three = new Node(2); 
	    Node four = new Node(6); 
	    Node five = new Node(7); 
	    Node six = new Node(8); 
	    Node seven = new Node(8);
	    head = one;
	    one.next = two; 
        two.next = three; 
        three.next = four; 
        four.next = five; 
        five.next = six; 
        six.next = seven;
        removeDuplicate(head);
	}
	
	
	private static void removeDuplicate(Node head) {
		
		Node temp = head;
		while(temp != null && temp.next!=null) {
			
			if(temp.data == temp.next.data) {
				temp.next = temp.next.next;
			}else {
				temp = temp.next;
			}
		}
		printNodes(head);
	}
	
	private static void printNodes(Node head) {
		while(head != null) {
			System.out.println(head.data);
			head = head.next;
		}

	}
}
