package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/missing-number/
 * 
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 *  
 * Example 1:
 * Input: [3,0,1]
 * Output: 2
 * 
 * @author amit
 *
 */
public class MissingNumber {

	public static void main(String[] args) {
		int[] nums = {9,6,4,2,3,5,7,0,1};
		int res = missingNumber(nums);
		System.out.println(res);
	}
	
	/**
	 * @param nums
	 * @return
	 */
	private static int missingNumber(int[] nums) {
		int actual = 0;
		int expected = 0;
		int n = nums.length;
		for(int i = 0; i<n; i++) {
			actual +=nums[i];
			expected += i+1;
		}
		return expected-actual;
	}
}
