package com.test.algorithm.search;

/**
 * geeksforgeeks.org/binary-search/
 * Binary Search
 * @author amit
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		
		int[] arr = {2, 3, 4, 10, 40};
		int i =0;
		int l = arr.length-1;
		int num = 10;
		System.out.println(binarySearch_Recursive(arr, i, l, num));
		
		System.out.println(binarySearch_Iterative(arr, i, l, num));
	}
	
	private static int binarySearch_Recursive(int[] arr, int i, int l, int num) {
		
		if(i<l) {
			int mid = (i+l)/2;
			if(arr[mid] == num)
				return mid;
			if(arr[mid]<num)
				return binarySearch_Recursive(arr, mid+1, l, num);
			
			return binarySearch_Recursive(arr, i, mid-1, num);
				
		}
		return -1;
	}
	
	
	private static int binarySearch_Iterative(int[] arr, int i, int l, int num) {
		
		int ans =-1;
		while(i<l) {
			int mid = (i+l)/2;
			
			if(arr[mid]<num)
				i=mid+1;
			else {
				ans = mid;
				l = mid-1;
			}
		}
		return ans;
	}
}
