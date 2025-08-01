package com.test.collection.array.rotations;

/**
 * Rotate list by given number of times
 * @author amit
 *
 */
public class RotateArrayByN {

	public static void main(String[] args) {
		int[] arr = {23,1,4,6};
		int n = 3;
		for(int i=0; i<n;i++) {
			rotateListByN(arr);
		}
		for (int i : arr) {
			System.out.println(i);
		}
	}
	
	private static void rotateListByN(int[] arr) {
		
		int first = arr[0];
		int j;
		for(j=0; j<arr.length-1; j++) {
			arr[j] = arr[j+1];
		}
		arr[j] = first;
	}
}
