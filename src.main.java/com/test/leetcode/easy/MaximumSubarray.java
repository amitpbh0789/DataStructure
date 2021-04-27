package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 *  which has the largest sum and return its sum.
 * 
 * @author amit
 *
 */
public class MaximumSubarray {

	public static void main(String[] args) {
		int[] input = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(findMax(input));
	}
	public static int findMax(int[] input) {
		int max=input[0], sum=input[0];
		for(int i=1; i<input.length;i++) {
			
			max = Math.max(input[i], max+input[i]);
			if(sum<max) {
				sum=max;
			}
		}
		
		return sum;
	}
}
