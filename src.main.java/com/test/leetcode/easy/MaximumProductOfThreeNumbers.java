package com.test.leetcode.easy;

/**
 * 
 * https://leetcode.com/problems/maximum-product-of-three-numbers/
 * 
 * 1. Max of 3 numbers could be of product of max 3 positive numbers
 * 
 * OR
 * 
 * 2. Product of Max positive number and 2 negative numbers(smallest negative)
 * 
 * @author amit
 *
 */
public class MaximumProductOfThreeNumbers {

	public static void main(String[] args) {
		
		MaximumProductOfThreeNumbers obj = new MaximumProductOfThreeNumbers();
		int[] nums = {1,2,3,4};
		System.out.println(obj.maximumProduct(nums));
		
	}
	
	public int maximumProduct(int[] nums) {
	    
		if(nums == null || nums.length <1)
			return 0;
		
//		3 Max positive number
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;
		
//		2 negative smallest number. Negative*negative becomes positive.
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		
		
		for(int n : nums) {
			
			if(n>max1) {
				max3=max2;
				max2 = max1;
				max1 = n;
			}else if(n>max2) {
				max3 = max2;
				max2 = n;
			} else if(n>max3) {
				max3 = n;
			}
			
			if(n<min1) {
				min2=min1;
				min1 = n;
			}else if(n<min2) {
				min2=n;
			}
		}
		return Math.max(max1*max2*max3, max1*min1*min2);
    }
}
