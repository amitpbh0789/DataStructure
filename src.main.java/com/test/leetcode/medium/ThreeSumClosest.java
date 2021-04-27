package com.test.leetcode.medium;

import java.util.Arrays;

/**
 * 
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * 
 * @author amit
 *
 */
public class ThreeSumClosest {

	public static void main(String[] args) {

		ThreeSumClosest obj = new ThreeSumClosest();
		int[] nums = {-1,2,1,-4};
		int target = 1;
		System.out.println(obj.threeSumClosest(nums, target));
		
	}

	public int threeSumClosest(int[] nums, int target) {

		if(nums == null || nums.length == 0)
			return 0;
		
		Arrays.sort(nums);
		
		int result = nums[0] + nums[1] + nums[nums.length - 1];
		
		for(int i=0; i<nums.length-2; i++) {
			
			int left = i+1;
			int right = nums.length-1;
			
			while(left<right) {
				
				int sum = nums[i]+nums[left] + nums[right];
				
				if(sum<target) {
					left++;
				}else {
					right--;
				}
				
				if(Math.abs(sum-target) < Math.abs(result - target))
					result = sum;
			}
			
		}
		
		
		
		return result;
	}
}
