package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * 
 * Given an array of integers that is already sorted in ascending order, find two numbers
 *  such that they add up to a specific target number.
 *  The function twoSum should return indices of the two numbers such that they add up to the target,
 *  where index1 must be less than index2.
 *  Note:
 *  Your returned answers (both index1 and index2) are not zero-based.
 *  You may assume that each input would have exactly one solution and you may not use the same element twice.
 *  Input: numbers = [2,7,11,15], target = 9
 *  Output: [1,2]
 *  Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * @author amit
 *
 */
public class TwoSumInSortedArray {

	public static void main(String[] args) {
		int[] arr = new int[] {2,7,11,15};
		int[] sum = sum(arr, 26);
		System.out.println("Indexes are "+ sum[0] + " and "+sum[1]);
	}
	private static int[] sum(int[] arr, int target) {
		
		if(arr.length ==0 || arr == null)
			return null;
		
		int i=0, j=arr.length-1;
		
		while(i<j) {
			
			if(arr[i] + arr[j] == target)
				break;
			if(arr[i]+arr[j]>target)
				j--;
			else
				i++;
			
		}
		return new int[]{i, j};
		
	}
}
