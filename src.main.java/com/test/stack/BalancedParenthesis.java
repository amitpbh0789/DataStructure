package com.test.stack;

public class BalancedParenthesis {

	private final int MAX_SIZE=3;
	int top = -1;
	char a[] = new char[MAX_SIZE];

	public static void main(String[] args) {

		char exp[] = {'{','(','(',')','}','[',']'}; 
		if (areParenthesisBalanced(exp)) 
			System.out.println("Balanced "); 
		else
			System.out.println("Not Balanced ");  
	}

	public static boolean areParenthesisBalanced(char exp[]) {
		BalancedParenthesis stack = new BalancedParenthesis();
		for(int i =0; i<exp.length; i++) {

			if(exp[i]=='(' || exp[i]=='{' || exp[i]=='[') {
				stack.push(exp[i]);
			}
			else if(exp[i]==')' || exp[i]=='}' || exp[i]==']') {

				if(stack.isEmpty()) {
					return false;
				}

				//				check if top of the stack is opening for this or not
				if(!checkParenthesisEquality(stack.pop(), exp[i])) {
					return false;
				}
			}

		}

		if(stack.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}

	public static boolean checkParenthesisEquality(char first, char second) {
		if(first=='(' && second==')') {
			return true;
		} else if(first=='{' && second=='}') {
			return true;
		} else if(first=='[' && second==']') {
			return true;
		}else {
			return false;
		}
	}

	public boolean isEmpty() {
		return (top<0);
	}

	public boolean push(char data) {
		if(top>= (MAX_SIZE-1)) {
			System.out.println("Stack Overflow"); 
			return false;
		}else {
			a[++top]=data;
			System.out.println(data + " pushed into stack"); 
			return true;
		}
	}
	public char pop() {

		if(top<0) {
			System.out.println("Stack Underflow");
			return '\0';
		}else {
			char x = a[top--];
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
