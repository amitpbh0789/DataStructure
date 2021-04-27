package com.test.collection.map;
import java.util.Objects;

public class HashMapImpl {

	public static void main(String[] args) {

		HashMapImpl map = new HashMapImpl(10);

		map.put("FB", "1");
		map.put("Ea", "2");
		map.put("3", "3");
		System.out.println(map.get("3"));
		map.put("3", "4");

		System.out.println(map.get("Ea"));
		System.out.println(map.get("FB"));
		System.out.println(map.get("8"));

	}

	public int hasCode(Object key) {
		return Objects.hashCode(key);
	}

	Node[] buckets;
	int n;
	public HashMapImpl(int n) {
		this.n = n;
		buckets = new Node[n];
	}

	public void put(Object key, Object value) {

		int hasCode = hasCode(key);
		int idx = hasCode%n;
		if(buckets[idx] == null) {
			buckets[idx] = new Node(key, value);
		}else {
			buckets[idx].add(key, value);
		}
	}

	public Object get(Object key) {

		int hasCode = hasCode(key);
		int idx = hasCode%n;
		Node node = buckets[idx];
		if(node == null)
			return null;
		else {
			return node.get(key);
		}
	}
}

class Node{
	Object key;
	Object val;
	Node next;

	public Node(Object key, Object val) {
		this.key = key;
		this.val = val;
		this.next =null;
	}

	public void add(Object key, Object value) {

		Node node = this;
		Node prev = null;
		while(node != null) {
			if(node.key == key) {
				node.val =value;
				return;
			}else {
				prev = node;
				node = node.next;
			}
		}
		if(prev !=null){
			prev.next = new Node(key, value);
		}else{
			prev = new Node(key, value);;
		}
	}

	public Object get(Object key) {
		Node node = this;
		while(node !=null) {
			if(node.key == key) {
				return node.val;
			}else {
				node = node.next;
			}
		}
		return null;
	}
}