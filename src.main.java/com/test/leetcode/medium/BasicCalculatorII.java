package com.test.leetcode.medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 * 
 * @author amit
 *
 */
public class BasicCalculatorII {

	public static void main(String[] args) {

		BasicCalculatorII obj = new BasicCalculatorII();
		String s = " 3/2 ";
		System.out.println(obj.calculate(s));
	}

	public int calculate(String s) {
		
		s = s.trim();
		int len = s.length();
		
		if(s == null || len == 0) 
			return 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int num = 0;
		int op = '+';
		int result = 0;
		
		for(int i=0; i<len; i++) {
			
			if(Character.isDigit(s.charAt(i))) {
//	IMP 		num*10 is not needed if input contains single digit from 1 to 9 but when input is like 45
//				then num*10 is needed to make the whole digit ready
				num = num*10+s.charAt(i)-'0';
			}
			
			if((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == len-1) {
				if(op == '-') {
					stack.push(-num);
				}else if(op=='+') {
					stack.push(num);
				}else if(op == '*') {
					stack.push(stack.pop()*num);
				}else if(op == '/') {
					stack.push(stack.pop()/num);
				}
				num = 0;
				op = s.charAt(i);
			}
			
		}
		
		for(int i :  stack) {
			result = result + i;
		}
		return result;
		
	}
}
