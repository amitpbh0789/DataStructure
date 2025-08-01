package com.test.collection.array.sum;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.geeksforgeeks.org/maximum-even-sum-subsequence-of-length-k/
 * 
 * Given an array arr[] consisting of N positive integers, and an integer K, 
 * the task is to find the maximum possible even sum of any subsequence of size K. 
 * If it is not possible to find any even sum subsequence of size K, then print -1.
 *
 *Scenarios to handle:
 *Pre: Create 2 list for odd and even
 *1. If k is odd then take even first
 *2. else if both size is greater than 1 then compare (even+even) and (odd+odd) and add the max value
 *3. If even list is greater than 1, keep adding even (even+even)
 *4. else add of (odd+odd) 
 *
 * Time Complexity: O(K * NK)
 * Auxiliary Space: O(K)
 */
public class MaximumEvenSumSubsequenceOfLengthK {

	// Driver code
	public static void main(String[] args){
		int arr[] = {5, 5, 2, 4, 3};
		int N = arr.length;
		int K = 3;
		MaximumEvenSumSubsequenceOfLengthK obj = new MaximumEvenSumSubsequenceOfLengthK();

		System.out.println(obj.evenSumK(arr, N, K));
	}

	public int evenSumK(int arr[], int N, int K){

		// If count of elements is less than K
		if (K > N) {
			return -1;
		}

		// Stores maximum even subsequence sum
		int maxSum = 0;

		// Stores Even numbers
		ArrayList<Integer> Even = new ArrayList<Integer>();
		// Stores Odd numbers
		ArrayList<Integer> Odd = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			if (arr[i] % 2 == 1) {
				Odd.add(arr[i]);
			}
			else {
				Even.add(arr[i]);
			}
		}

		Collections.sort(Odd);
		Collections.sort(Even);

		// Stores current index Of Even[] array
		int i = Even.size() - 1;
		// Stores current index Of Odd[] array
		int j = Odd.size() - 1;

		while (K > 0) {

			// If K is odd, then I can take 1 even and next (even+even) or (odd+odd)
			if (K % 2 == 1) { // If count of elements in Even[] >= 1
				if (i >= 0) {
					maxSum = maxSum + Even.get(i);
					i--;
				}
				else {
					return -1;
				}
				K--;
			} else if (i >= 1 && j >= 1) { // If count of elements in Even[] and odd[] >= 2

				int evenSum = Even.get(i) + Even.get(i - 1);
				int oddSum = Odd.get(j) + Odd.get(j - 1);
				
				if (evenSum <= oddSum) {
					maxSum += oddSum;
					j = j-2;
				}
				else {
					maxSum += evenSum;
					i = i-2;
				}
				K = K-2;
			} else if (i >= 1) { // If count of elements in Even[] array >= 2.
				maxSum += Even.get(i) + Even.get(i - 1);
				i = i-2;
				K = K-2;
			} else if (j >= 1) { // // If count of elements in Odd[] array >= 1
				maxSum += Odd.get(j) + Odd.get(j - 1);
				j = j-2;
				K = K-2;
			}
		}
		return maxSum;
	}
}
