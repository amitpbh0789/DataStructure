package com.test.stack;

public class StackUsingArray {

	private final int MAX_SIZE=3;
	int top;
	int a[] = new int[MAX_SIZE];

	public static void main(String[] args) {

		StackUsingArray stack = new StackUsingArray();
		stack.push(1);
		stack.push(2);
		stack.push(3);

		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
	}


	public StackUsingArray() {

		top = -1;
	}

	public boolean isEmpty() {
		return (top<0);
	}

	public boolean push(int data) {
		if(top>= (MAX_SIZE-1)) {
			System.out.println("Stack Overflow"); 
			return false;
		}else {
			a[++top]=data;
			System.out.println(data + " pushed into stack"); 
			return true;
		}
	}
	public int pop() {

		if(top<0) {
			System.out.println("Stack Underflow");
			return 0;
		}else {
			int x = a[top--];
			return x;
		}
	}
	public int peek() {

		if(top<0) {
			System.out.println("Stack Underflow");
			return 0;
		}else {
			int x = a[top];
			return x;
		}
	}

}
