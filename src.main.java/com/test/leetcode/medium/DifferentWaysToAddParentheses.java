package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 * 
 */
public class DifferentWaysToAddParentheses {

	Set<Character> opsSet = new HashSet<Character>(Arrays.asList('*','-','+')); // for set of Ops allowed
	Map<String,List<Integer>> map = new HashMap<>(); // to keep result into memory
	
	public static void main(String[] args) {
		String str = "2+3";
		DifferentWaysToAddParentheses obj = new DifferentWaysToAddParentheses();
		System.out.println(obj.diffWaysToCompute2(str));
	}

	
	
	/**
	 * Recursion with memorization
	 */
	public List<Integer> diffWaysToCompute2(String input) {
		
		if(map.containsKey(input)) { // if we encounter with same input then return from map. This will avoid recalculation
			return map.get(input);
		}
		
		List<Integer> result = new ArrayList<Integer>();
		boolean hasOps = false;
		for(int i=0; i<input.length(); i++) {
			
			if(opsSet.contains(input.charAt(i))) {
				hasOps = true;
				List<Integer> part1  = diffWaysToCompute2(input.substring(0,i));
	            List<Integer> part2  = diffWaysToCompute2(input.substring(i+1,input.length()));
	            
	            //now compute values using both parts
	            for(Integer x : part1) {
					for(Integer y : part2) {
						if(input.charAt(i)=='+')
	                         result.add(x+y);
	                     else if(input.charAt(i)=='-')
	                         result.add(x-y);
	                     else if(input.charAt(i)=='*')
	                         result.add(x*y);
					}
				}
			}
		}
		if(!hasOps) { // if there is no operator then add into result
			result.add(Integer.parseInt(input));
		}
		
		// Also add into Memory map so that next time we can get from there itself
		map.put(input, result);
		
		return result;
		
	}
	
	
	/** Solution1: Greedy approach
	 * Greedy approach. Idea is to partition the string into two parts whenever we find binary operator 
 * and now solve the question for smaller problem, that is Greedy approach . 
 * 
 * This process keep going until we hit a string of length = 1, our base case
	 */
	public List<Integer> diffWaysToCompute(String input) {

		//Base case
		if(input.length()==1){
			List<Integer>temp = new ArrayList<>();
			int num = input.charAt(0)-'0';
			temp.add(num);
			return temp;
		}
		List<Integer>ans = new ArrayList<>();
		for(int i=0;i<input.length();i++){

			char curr = input.charAt(i);
			//If there is a binary operator, then partition
			if(curr =='+'||curr=='-'||curr=='*'){
				String p1 = input.substring(0,i);
				String p2 = input.substring(i+1);

				List<Integer>res1 = diffWaysToCompute(p1);
				List<Integer>res2 = diffWaysToCompute(p2);

				//Now compute values using both parts
				for(int t1 : res1){
					for(int t2 : res2){
						if(input.charAt(i)=='+'){
							ans.add(t1+t2);
						}else if(input.charAt(i)=='-'){
							ans.add(t1-t2);
						}else {
							ans.add(t1*t2);
						}
					}
				}
			}
		}
		//Means there is no operator in Input string, that's why ans list is empty
		if(ans.size()==0)
			ans.add(Integer.valueOf(input));
		
		return ans;

	}
}
