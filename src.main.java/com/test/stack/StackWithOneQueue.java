package com.test.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithOneQueue {

	private Queue<Integer> q1 = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		StackWithOneQueue stack = new StackWithOneQueue();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
	}
	
	
	 void push(int data) {
		int size = q1.size();
		q1.add(data);
		
		for(int i=0; i<size; i++) {
			int x = q1.remove();
			q1.add(x);
		}
	}
	
	int pop() {
		if(q1.isEmpty()) {
			return -1;
		}
		int x = q1.remove();
		return x;
	}
	
	int peek() {
		if(q1.isEmpty()) {
			return -1;
		}
		return q1.peek();
	}
}
