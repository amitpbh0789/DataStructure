package com.test.collection.array.sum;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * 
 * Time: O(N)
 * Space: O(1)
 * 
 * Sliding Window Approach
 * 
 * Keep on reducing nums[i] from sum until becomes less than or equal to 0
 * if becomes 0 then calculate the min length and add current value which will make next window
 * 
 * If no solution found, then mod n+1 will return 0 else min length calculated so far
 *
 */
public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		MinimumSizeSubarraySum obj = new MinimumSizeSubarraySum();
		int[] nums = new int[] {2,1,1,4,3};
		int target = 7;
		System.out.println(obj.minSubArrayLen(target, nums));
	}
	
	public int minSubArrayLen(int target, int[] nums) {
		int i=0; // to track start of the window
        int j=0; // to tarck end of the window
        int sum=0;
        int minLength=Integer.MAX_VALUE; // minimum length found so far
        while(j<nums.length){ // Iterate the array
            sum+=nums[j];
// once sum is greater or equal to target, keep removing numbers from starting point until becomes less than target
            while(sum>=target){ 
                sum-=nums[i];
                minLength=Math.min(j-i+1,minLength); // this is to calculate the current min
                i++; // increase the starting point since items are being removed 
            }
            j++;
        }
        if(minLength==Integer.MAX_VALUE){
            return 0;
        }
        return minLength;
    }
}
