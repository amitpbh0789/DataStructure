package com.test.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {


	class Node{
		Node prev, next;
		int key;
		int value;
	}

	Map<Integer, Node> cache = new HashMap<Integer, Node>();
	int size;
	int capacity;
	Node head, tail;

	public LRUCache(int capacity) {

		this.size =0;
		this.capacity = capacity;
		head = new Node();
		tail = new Node();

		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {

		Node node = cache.get(key);
		if(node == null)
			return -1;

		//		else move the node to the head so that we can identify LRU node and return node.value
		moveToHead(node);

		return node.value;
	}

	public void put(int key, int value) {

		Node node = cache.get(key);
		if(node == null) {
			//			Construct node for key and value
			Node newNode = new Node();
			newNode.key = key;
			newNode.value = value;
			//			 put into cache
			cache.put(key, newNode);
			//			Add newly constructed node into original list
			addNode(newNode);
			size++;

			//			Now check if size is more than capacity then remove LRU element
			if(size>capacity) {
				//				POP the tail node
				Node poppedNode = popTail();
				//				Remove the entry from cache
				cache.remove(poppedNode.key);
			}

		} else {
			//			Since element is already present, update the value
			node.value = value;
			//			Move to head
			moveToHead(node);
		}

	}

	private void moveToHead(Node node) {

		/**
		 * Move certain node in between to the head.
		 */
		//		Remove Node. It could be last node or any in between node
		removeNode(node);
		//		Add Node. Move to the head
		addNode(node);

	}

	/**
	 * @Desc: This method will remove element anywhere from the list 
	 * @param node
	 */
	private void removeNode(Node node) {

		//		Remove existing node from the list
		Node prev = node.prev;
		Node next = node.next;
		prev.next = next;
		next.prev = prev;

	}

	/**
	 * Always add the new node right after head.
	 *
	 *Doubly LinkedList
	 * @param node
	 */
	private void addNode(Node node) {

		//		Left to right for Doubly LinkedList
		node.prev = head;
		node.next = head.next;

		//		Reverse order for Doubly LinkedList
		head.next.prev = node;
		head.next = node;

	}

	/**
     * Pop the current tail.
     */
	private Node popTail() {

		Node res = tail.prev;
		removeNode(res);
		return res;
	}
	
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(10);
		cache.put(1, 121);
		System.out.println(cache.get(1));
	}
}
