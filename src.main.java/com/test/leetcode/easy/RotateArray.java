package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/rotate-array/
 * 
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * @author amit
 *
 */
public class RotateArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int k = 3;
		rotateArray(arr, k);
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	private static void rotateArray(int[] arr, int k) {
		
		for(int i =0; i<k; i++) {
			swapElements(arr);
		}
	}
	
	private static void swapElements(int[] arr) {
		
		int prev = arr[arr.length-1];
		
		for(int i =0; i<arr.length; i++) {
			int temp = arr[i];
			arr[i] = prev;
			prev = temp;
		}
	}
}
