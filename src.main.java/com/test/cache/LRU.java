package com.test.cache;

import java.util.HashMap;
import java.util.Map;

public class LRU {

	public static void main(String[] args) {
		LRUCache obj = new LRUCache(3);
		obj.put(1,2);
		obj.put(2,3);
		obj.put(11,22);
		obj.get(1);
		obj.put(12,232);
		obj.put(45,456);
		Map<Integer, Node> res = obj.cache;
		for(Integer i : res.keySet()) {
			System.out.println(res.get(i).value);
		}
	}
}

/**
 * Cache implementation using LRU approach
 * Collection used:
 * 	HashMap --> to store entry in cache
 * 	DoublyLinkedList --> to track the uses of each entry so that LRU could be implemented
 *
 */
class LRUCache{
	
	int capacity;
	int size;
	Map<Integer, Node> cache;
	
	Node head;
	Node tail;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		cache = new HashMap<>();
		
		this.head = new Node();
		this.tail = new Node();
		
		head.next = tail;
		tail.prev = head;
	}
	
	public int get(int key) {
		
		Node entry = cache.get(key);
		if(entry!= null) {
//			since it is used recently, remove from wherever it is and move to head
			moveToHead(entry);
			
			return entry.value;
		}
		return -1;
	}
	
	public void put(int key, int value) {
		
		Node entry = cache.get(key);
		
		if(entry != null) {
			
//			update the value 
			entry.value = value;
//			move to head
			moveToHead(entry);
			
		}else { // when there is no entry in the cache
			
			if(size == capacity) {
				Node deletedEntry = deleteFromTail();
				cache.remove(deletedEntry.key);
				size--;
			}
			
			Node newNode = new Node(key, value);
//			add into head
			addEntry(newNode);
			cache.put(key, newNode); //add into cache and ncrease the size
			size++;
		}
	}
	
	
	/**
	 * This method is going to delete and move to the head
	 */
	public void moveToHead(Node entry) {
		
		deleteEntry(entry);
		addEntry(entry);
	}
	
	public void deleteEntry(Node entry) {
		
//		Get the prev and next nde ref
		Node left = entry.prev;
		Node right = entry.next;
		
//		Now assign left and right and entry would be deleted
		left.next = right;
		right.prev = left;
	}
	
	public void addEntry(Node entry) {
		
//		Add links from new node
		entry.prev = head;
		entry.next = head.next;
		
//		add links from neighouring nodes
		head.next.prev = entry;
		head.next = entry;
	}
	
	/**
	 * When size is full then this method will delete one entry from the tail.
	 */
	public Node deleteFromTail() {
		Node nodeToBeDeleted = tail.prev;
		deleteEntry(nodeToBeDeleted);
		return nodeToBeDeleted;
	}
	
}

/**
 * Each node will have key, value and its prev and next nodes reference
 *
 */
class Node{
	int key;
	int value;
	
	Node prev;
	Node next;
	
	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
	
	public Node() {
		
	}
}
