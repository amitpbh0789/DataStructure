package com.test.set;


import java.util.Objects;

public class MySet {

	int capacity;
	int size;
	MySetNode[] bucket;

	public MySet(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		bucket = new MySetNode[capacity];
	}

	public int hashCode(String data) {
		return Objects.hashCode(data);
	}

	public void add(String data) {
		int hash = hashCode(data);
		int idx = hash%capacity;

		if(bucket[idx] ==null) {
			MySetNode newNode = new MySetNode(data);
			bucket[idx] = newNode;
			size++;
		}else {
			boolean res = bucket[idx].add(data);
			if(res) {
				size++;
				System.out.println("item added");
			}else {
				System.out.println("Item ignored");
			}
		}
	}

	public boolean remove(String data){
		int hash = hashCode(data);
		int idx = hash%capacity;

		if(bucket[idx] == null) {
			System.out.println("No element found ");
			return false;
		}else {
			MySetNode curr = bucket[idx];
			if(curr.data.equals(data)) { // if data found at first place then update bucket node
				bucket[idx] = curr.next;
				size--;
				return true;
			}else {
				return bucket[idx].delete(data);
			}
		}
	}

	public int size() {
		return size;
	}

	//	Tester
	public static void main(String[] args) {
		MySet mySet = new MySet(10);
		mySet.add("FB");
		mySet.add("Ea");
		mySet.add("a");
		System.out.println("Before dleetion size"+mySet.size());
		mySet.remove("test");
		mySet.remove("a");
		System.out.println("After dleetion size"+mySet.size());

		System.out.println();
	}

}


class MySetNode{
	String data;
	MySetNode next;

	public MySetNode(String data) {
		this.data = data;
		this.next = null;
	}

	public boolean add(String data) {
		MySetNode curr = this;
		while(curr.next != null) {
			if(curr.data.equals(data)) {
				return false;
			}
			curr = curr.next;
		}
		curr.next = new MySetNode(data);
		return true;

	}

	public boolean delete(String data) {
		MySetNode curr = this;

		MySetNode prev = curr;
		while(curr != null) {
			if(curr.data.equals(data)) {
				prev.next = curr.next;
				return true;
			}
			prev = curr;
			curr = curr.next;
		}
		return false;
	}
}
