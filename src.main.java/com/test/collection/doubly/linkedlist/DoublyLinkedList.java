package com.test.collection.doubly.linkedlist;

public class DoublyLinkedList {
	
	DoublyNode head;
	
	class DoublyNode{
		int data;
		DoublyNode next;
		DoublyNode prev;
		public DoublyNode(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		
		DoublyLinkedList obj = new DoublyLinkedList();
		obj.addInFront(10);
		
	}
	
	public void addInFront(int data) {
		DoublyNode node = new DoublyNode(data);
		node.next = head;
		node.prev = null;
		
		// if head is not null then point head prev to node
		if(head != null) {
			head.prev = node;
		}
		
		// now make node as head
		head = node;
	}
	
	public void insertAfter(DoublyNode prevNode, int data) {
		if(prevNode == null) {
			return;
		}
		
		DoublyNode newNode = new DoublyNode(data);
		
		newNode.next = prevNode.next;
		prevNode.next = newNode;
		
		newNode.prev = prevNode;
		
		// now check if this was last or has any next node
		
		if(newNode.next != null) {
			newNode.next.prev = newNode;
		}
	}
}


