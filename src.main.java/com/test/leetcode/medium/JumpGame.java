package com.test.leetcode.medium;

/**
 * 
 * https://leetcode.com/problems/jump-game/
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * 
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * 
 * @author amit
 *
 */
public class JumpGame {

	public static void main(String[] args) {

		JumpGame obj = new JumpGame();
		int[] nums = {2,3,1,1,4};
		
		System.out.println(obj.canJump1(nums));
	}

	/**
	 * Backward checking. Will check if index+index value>= last good index;
	 * @param nums
	 * @return
	 */
	public boolean canJump1(int[] nums) {

		if(nums == null || nums.length == 0)
			return false;
		
		int lastGoodIndex = nums.length-1;
		
		for(int i=nums.length-1; i>=0; i--) {
			
			if(i+nums[i]>= lastGoodIndex)
				lastGoodIndex = i;
		}
		
		return lastGoodIndex == 0;
	}
}
