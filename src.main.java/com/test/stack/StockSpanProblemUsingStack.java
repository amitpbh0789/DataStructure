package com.test.stack;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 *
 */
public class StockSpanProblemUsingStack {

	public static void main(String[] args) {
		int price[] = { 10,3, 4, 5, 3, 8, 100 }; 
	    int n = price.length; 
	    int span[] = new int[n];
	    calculateStockSpan(span, n, price);
	    
	    for(int i : span) {
	    	System.out.println(i);
	    }
	}
	
	private static void calculateStockSpan(int[] span, int n, int[] price) {
		
//		Stock span for first element will be one always
		span[0] = 1;
		Stack<Integer> stack = new Stack<>();
		stack.push(0); // store indexes
		
		for(int i = 1; i<n; i++) {
			while(!stack.isEmpty() && price[stack.peek()]<=price[i]) {
				stack.pop();
			}
			
			span[i] = stack.isEmpty()? (i+1) : (i-stack.peek());
			
			stack.push(i);
		}
		
	}
	
}
