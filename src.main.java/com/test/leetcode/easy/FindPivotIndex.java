package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/find-pivot-index/
 * 
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * We define the pivot index as the index where the sum of the numbers to the left of the index is
 * equal to the sum of the numbers to the right of the index.If no such index exists, we should return -1.
 * If there are multiple pivot indexes, you should return the left-most pivot index.
 * Input: 
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3. It's index value
 * 
 *@author amit
 *
 */
public class FindPivotIndex {

	public static void main(String[] args) {
		
		int[] nums = {1, 7, 3, 6, 5, 6};
		System.out.println(findPivotIndex(nums));
	}
	private static int findPivotIndex(int[] nums) {
		int i=0;
		int j = nums.length-1;
		int leftSum = nums[i];
		int rightSum = nums[j];
		while(i<j) {
			
			if(leftSum<rightSum) {
				leftSum = leftSum + nums[i];
				i++;
			}
			else if(leftSum>rightSum) {
				rightSum = rightSum + nums[j];
				j--;
			}
			else if(leftSum==rightSum){
				return i;
			}
		}
		return -1;
	}
}
