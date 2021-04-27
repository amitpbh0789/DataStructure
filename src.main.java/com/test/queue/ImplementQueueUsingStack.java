package com.test.queue;

import java.util.Stack;

public class ImplementQueueUsingStack {

	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
	}
}

class Queue {
	
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	
	public void enQueue(int x) {
		
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		stack1.push(x);
		
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
	}
	public int deQueue() {
		
		if(stack1.isEmpty()) {
			System.out.println("Queue is empty");
		}
		return stack1.pop();
	}
}