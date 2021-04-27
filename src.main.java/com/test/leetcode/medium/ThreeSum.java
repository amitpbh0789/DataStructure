package com.test.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 *  Find all unique triplets in the array which gives the sum of zero.
 * 
 * Concise O(N^2) Java solution
 * 
 * @author amit
 *
 */
public class ThreeSum {

	public static void main(String[] args) {

		int[] num = {-1, 0, 1, 2, -1, -4};
		ThreeSum obj = new ThreeSum();
		List<List<Integer>> ans = obj.threeSum(num);
		System.out.println(ans);
		
	}

	public List<List<Integer>> threeSum(int[] num) {
		
		List<List<Integer>> res = new LinkedList<>();
		if(num == null || num.length == 0)
			return res;
		
		Arrays.sort(num);
		
		for(int i=0; i<num.length-2; i++){
			
			if(i==0 || num[i] != num[i-1]) {
				
				int left = i+1;
				int right = num.length-1;
				int sum = 0-num[i];
				
				while(left<right) {
					if(num[left] + num[right] == sum) {
						res.add(Arrays.asList(num[i], num[left], num[right]));
						while(left<right && num[left] == num[left+1])
							left++;
						while(left<right && num[right]== num[right-1])
							right--;
						left++;
						right--;
					} else if(num[left]+num[right]<sum) {
						left++;
					}else {
						right--;
					}
				}
			}
		}
		return res;
	}
}
