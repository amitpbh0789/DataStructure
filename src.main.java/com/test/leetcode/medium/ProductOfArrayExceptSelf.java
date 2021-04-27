package com.test.leetcode.medium;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * 
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal
 * to the product of all the elements of nums except nums[i].
 * 
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * @author amit
 *
 */
public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4};
		int[] resp = productExceptSelf(nums);
		for(int i=0; i<resp.length; i++) {
			System.out.println(resp[i]);
		}
	}
	private static int[] productExceptSelf(int[] nums) {
		
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		int[] product = new int[nums.length];
		
		left[0] = 1;
		for(int i = 0; i<nums.length-1; i++) {
			left[i+1] = left[i] * nums[i];
		}
		right[nums.length-1] = 1;
		for(int i=nums.length-2; i>=0; i--) {
			right[i] = right[i+1] * nums[i+1];
		}
		for(int i=0; i<nums.length; i++) {
			product[i] = left[i] * right[i];
		}
		return product;
	}
}
