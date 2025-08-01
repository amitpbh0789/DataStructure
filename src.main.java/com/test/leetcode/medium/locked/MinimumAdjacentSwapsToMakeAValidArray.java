package com.test.leetcode.medium.locked;

/**
 * You are given a 0-indexed integer array nums. Swaps of adjacent elements are able to be performed on nums.

A valid array meets the following conditions:

The largest element (any of the largest elements if there are multiple) is at the rightmost position in the array.
The smallest element (any of the smallest elements if there are multiple) is at the leftmost position in the array.
Return the minimum swaps required to make nums a valid array.

Input: nums = [3,4,5,5,3,1]
Output: 6

Idea:

Step1: Find min and max element in the array
Step2: There might be multiple same numbers in array. hence find leftmost index of the min and rightmost index for the max
STep3: Now answer can be calculated with formula: minValIndex + ((arraysize-1) - maxValIndex).
@Note: Corner case: when min number index is greater than max number index then at some point min and max would swap each other 
hence we need to reduce 1 in above formula minValIndex + ((arraysize-1) - maxValIndex) - 1

 */
public class MinimumAdjacentSwapsToMakeAValidArray {

	public static void main(String[] args) {
		int[] nums = new int[] {3,4,5,5,3,1};
		System.out.println(MinimumAdjacentSwapsToMakeAValidArray.minimumSwaps(nums));
	}
	
	public static int minimumSwaps(int[] nums) {
		int minNum = Integer.MAX_VALUE;
		int minIdx = 0;
		int maxNum = Integer.MIN_VALUE;
		int maxIdx = 0;
		int length = nums.length;
		
		// Find min and max number
		for(int i=0; i<length; i++) {
			if(nums[i] < minNum) {
				minNum = Math.min(minNum, nums[i]);
			}
			
			if(nums[i] > maxNum) {
				maxNum = Math.max(maxNum, nums[i]);
			}
		}
		
		// Scan from left and find idx for first min number
		for(int i=0; i<length; i++) {
			if(nums[i] == minNum) {
				minIdx = i;
				break;
			}
		}
		
		// Scan from right and find idx for first max number
		for(int i=length-1; i>=0; i--) {
			if(nums[i] == maxNum) {
				maxIdx = i;
				break;
			}
		}
		
		
		if(minIdx <= maxIdx) {
			return minIdx + (length - 1 - maxIdx); 
		} else {
			return minIdx + (length - 1 - maxIdx) - 1; 
		}
		
	}
}
