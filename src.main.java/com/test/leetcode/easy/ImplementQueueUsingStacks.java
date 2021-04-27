package com.test.leetcode.easy;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * 
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * 
 * @author amit
 *
 */
public class ImplementQueueUsingStacks {

	Stack<Integer> queue1;
	Stack<Integer> queue2;
	
	
	public static void main(String[] args) {
		ImplementQueueUsingStacks obj = new ImplementQueueUsingStacks();
		obj.push(2);
		obj.push(3);
		obj.push(6);
		obj.push(10);
		System.out.println("First Peek item "+obj.peek());
		System.out.println("First Pop item "+obj.pop());
		System.out.println("Second Peek item "+obj.peek());
		System.out.println("Is Queue empty "+obj.empty());
	}
	
	/** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        queue1 = new Stack<>();
        queue2 = new Stack<>();
    }
    
	/** Push element x to the back of queue. */
    public void push(int x) {
    	if(queue1.empty())
    		queue1.push(x);
    	else {
    		queue1.forEach(queue -> {
    			queue2.push(queue);
    		});
    		queue1.removeAllElements();
    		queue1.push(x);
    	}
    	queue2.forEach(q -> {
    		queue1.push(q);
    	});
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	return queue1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	boolean isEmpty = false;
    	if(queue1.size()>0) {
    		isEmpty = true;
    	}
        return isEmpty;
    }
}
