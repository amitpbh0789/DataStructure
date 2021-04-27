package com.test.leetcode.medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * 
 * @author amit
 *
 */
public class EvaluateReversePolishNotation {

	public static void main(String[] args) {

		EvaluateReversePolishNotation obj = new EvaluateReversePolishNotation();
		
		String[] tokens = {"4", "13", "5", "/", "+"};
		
		System.out.println(obj.evalRPN(tokens));
	}

	public int evalRPN(String[] tokens) {

		if(tokens == null || tokens.length == 0)
			return 0;

		Stack<Integer> stack = new Stack<>();

		int length = tokens.length-1;

		String operators = "*/-+";

		for(int i=0; i<=length; i++){

			if(operators.contains(tokens[i])){

				int num1 = stack.pop();
				int num2 = stack.pop();

				if(tokens[i].equals("*"))
					stack.push(num2*num1);
				else if(tokens[i].equals("+"))
					stack.push(num2+num1);
				else if(tokens[i].equals("-"))
					stack.push(num2-num1);
				else
					stack.push(num2/num1);
			}else{
				stack.push(Integer.parseInt(tokens[i]));
			}
		}

		return stack.pop();

	}
}
