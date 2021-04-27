package com.test.leetcode.easy;

public class MergeTwoSortedArray {

	public static void main(String[] args) {
		int[] arr1 = {1,3,4,5};
		int[] arr2 = {3,4,7,8,9};
		int length1 = arr1.length;
		int length2 = arr2.length;
		
		int[] arr3 = new int[length1 + length2];
		
		mergeSortedArray(arr1, arr2, arr3, length1, length2);
		
		for(int i=0; i<arr3.length; i++) {
			System.out.println(arr3[i]);
		}
	}
	
	private static void mergeSortedArray(int[] arr1, int[] arr2, int[] arr3, int length1, int length2) {
		
		int i=0,j=0,k=0;
		
		while(i<length1 && j<length2) {
			if(arr1[i]<arr2[j]) {
				arr3[k++] = arr1[i++]; 
			}else {
				arr3[k++] = arr2[j++];
			}
		}
		while(i<length1) {
			arr3[k++] = arr1[i++];
		}
		
		while(j<length2) {
			arr3[k++] = arr2[j++];
		}
	}
}
