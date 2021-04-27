package com.test.linkedlist;

public class ImplementSinglyLinkedList {

	public static void main(String[] args) {

		LinkedList linkedList = new LinkedList();
		//		Create Head
		linkedList.head = new Node(5);

		//		Create 2 more nodes
		Node node3 = new Node(7);
		Node node1 = new Node(10);
		Node node2 = new Node(15);


		linkedList.head.next = node3;
		node3.next = node1;
		node1.next = node2;
		System.out.println("Linked list created with 3 nodes");
		printNodes(linkedList);

		deleteNode(linkedList, 10);
		System.out.println("Priting after deletion");
		printNodes(linkedList);

		System.out.println("delete node at "+1);
		deleteKeyAtGivenLocation(0, linkedList);
		printNodes(linkedList);

		System.out.println("Add node at "+1);
		Node node = new Node(25);
		addNode(node, 0, linkedList);
		printNodes(linkedList);

		//		Find the length 
		findTheLength(linkedList);

		System.out.println("find node at 1st");
		findNthNode(linkedList, 0);

		nthNodeFromEnd(linkedList, 1);

		printMiddleElement(linkedList);

	}

	private static void printNodes(LinkedList linkedList) {
		Node head = linkedList.head;
		while(head != null) {
			System.out.println(head.data);
			head = head.next;
		}

	}

	private static void deleteNode(LinkedList linkedList, int delete) {

		Node res = linkedList.head; 
		Node temp = linkedList.head; 
		Node prev = null;

		if(temp != null && temp.data == delete) {
			linkedList.head = temp.next;
			return;
		}

		while(temp!= null && temp.data != delete) {
			prev = temp;
			temp = temp.next;
		}
		if(temp == null) {
			return;
		}
		prev.next = temp.next;


		System.out.println("node deleted");
	}

	private static void deleteKeyAtGivenLocation(int position, LinkedList linkedList) {
		Node temp = linkedList.head;
		Node prev = null;
		if(linkedList.head == null) {
			System.out.println("Linked list is empty");
			return;
		}
		if(position == 0) {
			linkedList.head = temp.next;
			return;
		}

		for(int i =0; i<position; i++) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;
		System.out.println("Delete node value is "+temp.data);
	}

	private static void addNode(Node node, int position, LinkedList linkedList) {

		Node temp = linkedList.head;
		Node prev = null;
		if(position == 0) {
			node.next = temp;
			linkedList.head = node;
			return;
		}
		for(int i =0; i<position; i++) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = node;
		node.next = temp;

		System.out.println("Node added at given location");

	}

	private static void findTheLength(LinkedList linkedList) {
		Node head = linkedList.head;
		int count=0;
		if(linkedList.head == null) {
			return;
		}
		while(head!=null) {
			count++;
			head = head.next;
		}
		System.out.println("size of the linked list is "+ count);
	}

	private static void findNthNode(LinkedList linkedList, int nth) {
		Node head = linkedList.head;
		int count=0;
		if(head==null) {
			return;
		}
		while(head != null) {
			if(count == nth) {
				break;
			}else {
				head = head.next;
			}
			count++;
		}
		System.out.println("nth Node data is "+ head.data);
	}

	private static void nthNodeFromEnd(LinkedList linkedList, int nth) {

		Node head = linkedList.head;
		Node temp = linkedList.head;
		int count=0;
		if(head == null) {
			return;
		}
		while(head != null) {

			head = head.next;
			count++;
		}
		int nodeLocation = count-nth+1;
		count =1;
		while(temp !=null) {
			if(count == nodeLocation) {
				System.out.println("nth eleement data from last node is "+temp.data);
				break;
			}
			temp = temp.next;
			count++;
		}
	}

	private static void printMiddleElement(LinkedList linkedList) {

		Node head= linkedList.head;
		Node oneHead = linkedList.head;
		Node twoHead = linkedList.head;

		while(twoHead != null && twoHead.next!=null) {
			oneHead = oneHead.next;
			twoHead = twoHead.next.next;
		}
		System.out.println("Middle element is "+oneHead.data);

	}

	
}
