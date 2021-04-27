package com.test.leetcode.medium;

public class MaximumProductSubarray {

	public static void main(String[] args) {

	}

	public int maxProduct(int[] nums) {
		
		// store the result that is the max we have found so far
		int max = Integer.MIN_VALUE;
		
		// imax/imin stores the max/min product of
	    // subarray that ends with the current number nums[i]
		int iMax = 1;
		int iMin = 1;
		
		for(int i=0; i<nums.length; i++) {
			
// multiplied by a negative makes big number smaller, small number bigger so we redefine the extremums by swapping them
			if(nums[i]<0) {
				int temp = iMax;
				iMax = iMin;
				iMin = temp;
			}
			
			iMax = Math.max(nums[i]*iMax, nums[i]);
			iMin = Math.min(nums[i]*iMin, nums[i]);
			
			max = Math.max(max, iMax);
		}
		
		return max;

	}
}
