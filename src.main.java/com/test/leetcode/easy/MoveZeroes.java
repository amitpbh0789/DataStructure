package com.test.leetcode.easy;

/**
 * // Traverse the array. If element encountered is 
        // non-zero, then replace the element at index 'count' 
        // with this element 
 * @author amit
 *
 */
public class MoveZeroes {

	public static void main(String[] args) {
		int[] arr = {1,0,0,6,0,73,7,0,0};
		moveZeros(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	private static void moveZeros(int[] arr) {
		
		int count =0;
		
		for(int i=0; i<arr.length; i++) {
			
			if(arr[i] != 0) {
				arr[count++] = arr[i];
			}
			
		}
		// Now all non-zero elements have been shifted to 
        // front and 'count' is set as index of first 0. 
        // Make all elements 0 from count to end. 
		while(count<arr.length) {
			arr[count++] = 0;
		}
	}
}
