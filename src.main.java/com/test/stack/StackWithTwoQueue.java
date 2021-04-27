package com.test.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueue {

	Queue<Integer> q1 = new LinkedList<Integer>(); 
	Queue<Integer> q2 = new LinkedList<Integer>(); 
	
	public static void main(String[] args) {
		StackWithTwoQueue s = new StackWithTwoQueue();
		s.push(1); 
        s.push(2); 
        s.push(3); 
        
        System.out.println(s.peek()); 
        s.pop(); 
        System.out.println(s.peek()); 
        s.pop(); 
        System.out.println(s.peek()); 
	}
	
	public void push(int data) {
		
		q2.add(data);
		
		while(!q1.isEmpty()) {
			q2.add(q1.peek());
			q1.remove();
		}
		Queue<Integer> q = q1;
		q1 = q2;
		q2 = q;
	}
	
	public void pop() {
		if(q1.isEmpty()) {
			return;
			
		}
		q1.remove();
	}
	
	public int peek() {
		if (q1.isEmpty()) 
            return -1; 
        return q1.peek();
	}
}
