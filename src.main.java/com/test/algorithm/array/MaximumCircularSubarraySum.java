package com.test.algorithm.array;

/**
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 *
 */
public class MaximumCircularSubarraySum {
	
	public static void main(String[] args) {
		
		MaximumCircularSubarraySum obj = new MaximumCircularSubarraySum();
		int[] arr= new int[] {1,-2,3,-2};
		System.out.println(obj.maxSubarraySumCircular(arr));
	}
	
	/*
	Use subarray max sum solution and find out max sum
	use total to calculate total sum 
	and also maintain minsum

	if max > 0, then either maxsum is the answer or total-min should be the answer

	corner case: if all the number are negative then just return maxsum default value;
	*/
	public int maxSubarraySumCircular(int[] A) {
        int total = 0;
        
        int maxSum = A[0];
        int minSum = A[0]; 
        
        int curMax = 0;
        int curMin = 0;
        
        for (int a : A) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
