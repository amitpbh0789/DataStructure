package com.test.set;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Best case time complexity: O(1)
 * Worst case time complexity: O(N)
 * 
 * @author amit
 *
 */
public class MyHashSet {

	int capacity;
	Node[] bucket;
	int size;

	public static void main(String[] args) {
		MyHashSet mySet = new MyHashSet(10);
		mySet.add("FB");
		mySet.add("Ea");
		mySet.add("a");

		System.out.println();
	}

	public MyHashSet(int capacity) {
		this.capacity = capacity;
		bucket = new Node[capacity];
		this.size = 0;
	}

	public void add(String num) {

		int index = getIndex(num);
		//		Check if there is any node at above index
		Node node = bucket[index];
		Node tempNode = new Node(num);
		if(node == null) {
			bucket[index] = new Node(num);
			size++;
			return;
		}
//		Node exist at given index then iterate and check if value matches. If matches then return else keep iteratign at the end
		while(node.next != null) {
			if(node.value.equals(num)) {
				return;
			}
			node = node.next;
		}

		//			If there was no matching string then we need to add formed node at the end
		node.next = tempNode;
		size++;
	}

	public boolean remove(String num) {
		
		int index = getIndex(num);
		Node node = bucket[index];
		if(node == null)
			throw new NoSuchElementException("No Element Found");
		
		if(node.value.equals(num)) {
			bucket[index] = node.next;
			size--;
		}
		
		Node prev = node;
		while(node != null) {
			
			if(node.value.equals(num)) {
				prev.next = node.next;
				size--;
				return true;
			}
			prev = node;
			node = node.next;
		}
		
		return false;
	}
	
	public int size() {
		return size;
	}


	public int getIndex(String value) {
		int hashCode = Objects.hashCode(value);
		return hashCode%capacity;
	}

	class Node{
		private String value;
		private Node next;

		public Node(String value) {
			this.value = value;
			this.next = null;
		}
	}
}
