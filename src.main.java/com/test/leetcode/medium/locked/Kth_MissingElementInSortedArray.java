package com.test.leetcode.medium.locked;

/**
 * Given an integer array nums which is sorted in ascending order and all of its elements are unique and given also an integer k, 
 * return the kth missing number starting from the leftmost number of the array.
 * 
 * Input: nums = [4,7,9,10], k = 1
Output: 5
Explanation: The first missing number is 5.
Example 2:

Input: nums = [4,7,9,10], k = 3
Output: 8



 * Binary search 
 * Time: LogN
 * Space: O(1)
 */
public class Kth_MissingElementInSortedArray {

	public static void main(String[] args) {

	}

	public int missingElement(int[] nums, int k) {
		// Edge case: if k is greater than missing between 0 and last num in the array
		int totalMissingNUmber = missingNumbers(nums, nums.length-1);
		if(k> totalMissingNUmber) {
			return nums[nums.length-1] + k - totalMissingNUmber;
		}
		
		int start = 0;
		int end = nums.length-1;
		
		while(start < end) {
			int mid = start + (end-start)/2;
			
			if(missingNumbers(nums, mid) < k) {
				start = mid+1;
			} else {
				end = mid;
			}
		
		}
		
		// Start number + (k - missing number till start numbers index)
		return nums[start - 1] +  (k - missingNumbers(nums, start - 1));
	}
	
	// Returns total missing number between 0 and idx in array
	private int missingNumbers(int[] nums, int idx) {
		return nums[idx]-nums[0] - idx;
	}
}
