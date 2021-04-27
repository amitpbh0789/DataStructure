package com.test.leetcode.medium;

/**
 * https://www.geeksforgeeks.org/maximum-sum-in-circular-array-such-that-no-two-elements-are-adjacent/
 * 
 * https://leetcode.com/problems/house-robber-ii/
 * 
 * Time Complexity: O(N^2)
 * 
 * It will work for both -VE and +VE numbers
 *
 */
public class CircularArraySum {

	public static void main(String[] args) {
		CircularArraySum obj = new CircularArraySum();
//		int[] arr = new int[] {1, 2, -3, 1};
		int[] arr = new int[] {1, 2, 3, 1};
		int sum = obj.findMaxSum(arr, arr.length);

		System.out.println(sum);
	}

	public int findMaxSum(int arr[], int n) {  
		int maxSum=Math.max(maxSum(arr, 0, n-1), maxSum(arr, 1, n)); 
		return maxSum; 
	}

	public int maxSum(int arr[], int start, int n) {  
		int dp[]=new int[n]; 
		int maxSum = 0;  

		for (int i = start; i < n; i++) {  

			// copy the element of original array to dp[]  
			dp[i] = arr[i];  
			// find the maximum element in the array  
			if (arr[i]>maxSum)  
				maxSum = arr[i];
		}  

		// start from 2nd to n-1th pos  
		for (int i = start+2; i < n; i++) {

			// traverse for all pairs, bottom-up approach  
			for (int j = 0; j < i - 1; j++) {  
				// dp-condition  
				if (dp[j] + arr[i] > dp[i]) {
					dp[i] = dp[j] + arr[i];  

					// find maximum sum  
					if (dp[i] > maxSum)  
						maxSum = dp[i];  
				}  
			}  
		}
		// return the maximum  
		return maxSum;  
	}  

}
