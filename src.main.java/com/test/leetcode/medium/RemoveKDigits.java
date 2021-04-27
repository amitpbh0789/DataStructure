package com.test.leetcode.medium;

import java.util.Stack;

public class RemoveKDigits {

	public static void main(String[] args) {

		RemoveKDigits obj = new RemoveKDigits();
		String num = "1432219";
		int k = 3;
		System.out.println(obj.removeKdigits(num, k));
	}

	public String removeKdigits(String num, int k) {

		int size = num.length();

		if(size == k)
			return "0";

		//         Create stack 
		Stack<Character> stack = new Stack<>();

		int counter = 0;

		//         Add digits into stack until couter reaches to size
		while(counter<size){

			//             if top of stack is greater than current digit then remove top from stack until k becomes 0
			while(k>0 && !stack.isEmpty() && stack.peek() > num.charAt(counter)){
				stack.pop();
				k--;
			}

			stack.push(num.charAt(counter));
			counter++;
		}

		//         Handle repeating digits scenrio, coz above logic will add everything after not finding anything less

		while(k>0){
			stack.pop();
			k--;
		}

		//         Take out one by one and add into StringBuilder
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}

		//         Reverse the string as we have appended the digits not prepended 
		sb.reverse();

		//         Handle leading 0 case. It will remove all the leading zero's from the string
		while(sb.length()>1 && sb.charAt(0) == '0'){
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}
}
