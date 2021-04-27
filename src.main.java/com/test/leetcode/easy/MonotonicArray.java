package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/monotonic-array/
 * 
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * Return true if and only if the given array A is monotonic.
 * 
 * Input: [1,2,2,3]
 * Output: true

 * @author amit
 *
 */
public class MonotonicArray {

	public static void main(String[] args) {

		int[] A = {1,2,3,4};
		System.out.println(isMonotonic(A));
	}
	private static boolean isMonotonic(int[] A) {
		if(A.length <= 1)
            return true;
		boolean isInc = false;
		boolean isDesc = false;
		boolean isEqual = false;
		for(int i=0; i<A.length-1; i++) {

			if(!isInc && !isDesc) {
				if(A[i]<A[i+1]) {
					isInc = true;
				} else if(A[i]>A[i+1]) {
					isDesc = true;
				} else {
					isEqual = true;
				}
			}
			if(isInc && A[i]>A[i+1]) {
				return false;
			}
			if(isDesc && A[i]<A[i+1]) {
				return false;
			}
		}
		if(isInc || isDesc || isEqual)
			return true;
		else
			return false;
	}
}
