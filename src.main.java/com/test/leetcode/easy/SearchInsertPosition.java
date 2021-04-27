package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/search-insert-position/
 * 
 * Given a sorted array and a target value, return the index if the target is found. If not,
 * return the index where it would be if it were inserted in order.You may assume no duplicates in the array.
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * 
 * @author amit
 *
 */
public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int target = 0;
		System.out.println(searchInsertPosition(nums, target));
	}
	private static int searchInsertPosition(int[] nums, int target) {
		
		
		if(nums[0]>target) {
			return 0;
		}
		if(nums[0]==target) {
			return 0;
		}
		
		int index =1;
		for(int i = 1; i<nums.length; i++) {
			if(nums[i] == target) {
				return i;
			}
			if(nums[i]>target) {
				return i;
			}
			
			index = i;
		}
		
		return index+1;
	}
}
