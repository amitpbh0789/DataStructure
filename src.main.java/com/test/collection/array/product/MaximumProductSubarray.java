package com.test.collection.array.product;

/**
 * 
 * https://leetcode.com/problems/maximum-product-subarray/
 * 
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * 
 * Example 1:
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 */
public class MaximumProductSubarray {

	public static void main(String[] args) {
		
		MaximumProductSubarray obj = new MaximumProductSubarray();
		int[] nums = new int[] {2,3,-2,4};
		System.out.println(obj.maxProduct(nums));
		
	}
	
	public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int iMax = 1;
        int iMin = 1;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++) {

            if(nums[i]<0){
                int temp = iMax;
                iMax = iMin;
                iMin = temp;
            }

            iMax = Math.max(nums[i], iMax*nums[i]);
            iMin = Math.min(nums[i], iMin*nums[i]);

            max = Math.max(iMax, max);
        }
        return max;
    }

}
