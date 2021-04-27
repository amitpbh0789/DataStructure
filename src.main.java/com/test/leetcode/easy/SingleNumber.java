package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/single-number/
 * 
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 * 
 * @author amit
 *
 */
public class SingleNumber {

	public static void main(String[] args) {
		int[] nums = {5,7,7,4,4,1,2,1,2};
		int resp = singleNumber(nums);
		System.out.println(0^3);
		System.out.println(resp);
		
	}
	private static int singleNumber(int[] nums) {
		int ans =0;
	    
        int len = nums.length;
        for(int i=0;i!=len;i++)
            ans ^= nums[i]; // A^B —> returns A-B (6^6 = 0, 6^3 = 3, 0^3 = 3)
        return ans;
	}
}
