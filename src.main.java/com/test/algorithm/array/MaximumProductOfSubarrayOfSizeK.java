package com.test.algorithm.array;

/**
 * https://www.geeksforgeeks.org/largest-product-subarray-size-k/
 *	Similar to max Vowels in SubArray size k
 */
public class MaximumProductOfSubarrayOfSizeK {

	// driver program 
	public static void main (String[] args) { 
		int arr[] = {1, 5, 9, 8, 2, 4, 1, 8, 1, 2}; 
		int k = 6; 
		int n = arr.length; 
		System.out.println(findMaxProduct(arr, n, k)); 
	} 

	static int findMaxProduct(int arr[], int n, int k) { 
		// Initialize the MaxProduct to 1, as all elements 
		// in the array are positive 
		int MaxProduct = 1; 
		for (int i=0; i<k; i++) // get max product of 1st window of size k
			MaxProduct *= arr[i]; 

		int prev_product = MaxProduct; 

		for (int i=1; i<=n-k; i++) { // now divide by last element and multiply current number and see if its greater than prev product
			int curr_product = (prev_product/arr[i-1]) * arr[i+k-1]; 
			MaxProduct = Math.max(MaxProduct, curr_product); 
			prev_product = curr_product; 
		} 
		// Return the maximum product found 
		return MaxProduct; 
	} 

}
