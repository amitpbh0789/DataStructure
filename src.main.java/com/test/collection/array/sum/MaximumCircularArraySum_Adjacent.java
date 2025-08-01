package com.test.collection.array.sum;

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
public class MaximumCircularArraySum_Adjacent {

	public static void main(String[] args) {
		MaximumCircularArraySum_Adjacent obj = new MaximumCircularArraySum_Adjacent();
		int[] arr = new int[] {1, 2, -3, 1};
//		int[] arr = new int[] {1, 2, 3, 1};
		int ans = obj.findMaxSum(arr, arr.length);
		System.out.println(ans);
	}

	public int findMaxSum(int arr[], int n) {
		
		if(n<=1) {
			return arr[0];
		}
		
		// Old approach
		int maxSum=Math.max(maxSum(arr, 0, n-1), maxSum(arr, 1, n)); 
		
		// New BEST approach
		int maxSum_WithBetterApproach = Math.max(maxSum_Better_Approach(arr, 0, n-1), maxSum_Better_Approach(arr, 1, n)); 
		
		System.out.println("Old logic sum: "+ maxSum + " New better approach sum: "+maxSum_WithBetterApproach);
		
		return maxSum_WithBetterApproach; 
	}
	
	public int maxSum_Better_Approach(int arr[], int start, int n) {  
		
		int num1 = 0;
		int num2 = 0;
		
		for(int i=start; i<n; i++) {
			int newSum = Math.max(num1+arr[i], num2);
			num1=num2;
			num2 = newSum;
		}
		return num2;
	}

	// Don't go with this approach
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
