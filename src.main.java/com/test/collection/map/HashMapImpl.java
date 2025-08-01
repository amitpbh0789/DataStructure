package com.test.collection.map;
import java.util.Objects;

/**
 * 
 * 1. For LikedList --> Create Node with key, value and next Node reference
 * 2. For Bucket --> Array Node
 * 3. Initialize HashMap. Take size and initialize Bucket with provided size
 */
public class HashMapImpl {

	public static void main(String[] args) {

		HashMapImpl map = new HashMapImpl(10);

		map.put("FB", "1");
		map.put("Ea", "2");
		map.put("3", "3");
		System.out.println(map.get("3"));
		map.put("3", "4");
		System.out.println(map.get("3"));
		System.out.println(map.get("Ea"));
		System.out.println(map.get("FB"));
		System.out.println(map.get("8"));

	}

	public int hashCode(Object key) {
		return Objects.hashCode(key);
	}

	Node[] buckets;
	int n;
	public HashMapImpl(int n) {
		this.n = n;
		buckets = new Node[n];
	}

	public void put(Object key, Object value) {

		int hasCode = hashCode(key);
		int idx = hasCode%n;
		if(buckets[idx] == null) {
			buckets[idx] = new Node(key, value);
		}else {
			buckets[idx].add(key, value);
		}
	}

	public Object get(Object key) {

		int hasCode = hashCode(key);
		int idx = hasCode%n;
		Node node = buckets[idx];
		if(node == null)
			return null;
		else {
			return node.get(key);
		}
	}
	
	/** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(Object key) {
        int idx = hashCode(key);
        if(buckets[idx] != null){
            if(buckets[idx].key == key){
            	buckets[idx] = buckets[idx].next;
            }else{
            	buckets[idx].remove(key);    
            }
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
	
	public void remove(Object key){
        Node curr = this;
        Node prev = null;
        while(curr.next != null){
            if(curr.key == key){
                prev.next = curr.next;
                return;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
    }
}