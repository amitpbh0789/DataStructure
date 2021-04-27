package com.test.leetcode.medium;

/**
 * https://leetcode.com/problems/find-peak-element/
 * 
 * @author amit
 *
 */
public class FindPeakElement {

	public static void main(String[] args) {
		FindPeakElement obj = new FindPeakElement();
		int[] nums = {1,2,3,1};
		System.out.println(obj.findPeakElement(nums));
	}

	public int findPeakElement(int[] nums) {
		
		if(nums == null || nums.length == 0)
			return 0;
		
		for(int i=1; i<=nums.length-2; i++) {
			if(nums[i]>nums[i-1] && nums[i]>nums[i+1])
				return i;
		}
		return 0;
	}
}
