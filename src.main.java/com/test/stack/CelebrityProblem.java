package com.test.stack;

import java.util.Stack;

public class CelebrityProblem {

	static int MATRIX[][] = {{0, 0, 1, 0},{0, 0, 1, 0 },{0, 0, 0, 0},{0, 0, 1, 0}}; 
	
	public static void main(String[] args) {
		
		int numberOfPeople = 4;
		
		int celebrityId = findCelebrity(numberOfPeople);
		System.out.println(celebrityId);
		
	}
	
	static boolean knows(int a, int b) {
		
		return (MATRIX[a][b] == 1) ? true:false;
	}
	
	static int findCelebrity(int numberOfPeople) {
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i <numberOfPeople; i++) {
			stack.push(i);
		}
		
		
		while(stack.size()>1) {
			
			int a = stack.pop();
			int b = stack.pop();
			
			if(knows(a, b)) {
				stack.push(b);
			}else {
				stack.push(a);
			}
		}
		
		int c = stack.pop();
		
		for(int i =0; i<numberOfPeople; i++) {
			if(i != c && (knows(c, i) || !knows(i,c))) {
				return -1;
			}
		}
		
		return c;
	}
}
