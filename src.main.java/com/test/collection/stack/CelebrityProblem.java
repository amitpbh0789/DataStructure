package com.test.collection.stack;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/the-celebrity-problem/
 * 
 * In a party of N people, only one person is known to everyone. 
 * Such a person may be present at the party, if yes, (s)he doesn’t know anyone at the party. 
 * We can only ask questions like “does A know B? “. Find the stranger (celebrity) in the minimum number of questions.
 */
public class CelebrityProblem {

	static int MATRIX[][] = {{0, 0, 1, 0},
							 {0, 0, 1, 0 },
							 {0, 0, 0, 0},
							 {0, 0, 1, 0}}; 
	
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
