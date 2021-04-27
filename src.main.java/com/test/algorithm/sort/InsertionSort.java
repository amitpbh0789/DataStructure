package com.test.algorithm.sort;

/**
 * https://www.geeksforgeeks.org/insertion-sort/
 * 
 * Time Complexity: O(n^2)
 * Auxiliary Space: O(1)
 * 
 * 1: Iterate from arr[1] to arr[n] over the array
 * 2: Compare the current element (key) to its predecessor.
 * 3: If the key element is smaller than its predecessor, compare it to the elements before. 
 * Move the greater elements one position up to make space for the swapped element.
 * 
 * @author amit
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		
		InsertionSort obj = new InsertionSort();
		int[] arr = {64, 34, 25, 12, 22, 11, 90};
		obj.insertionSort(arr);
		
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}
	
	private void insertionSort(int[] arr) {
		
		for(int i=1; i<arr.length; i++) {
			
			int key = arr[i];
			int j = i-1;
			
			while(j>=0 && arr[j]>key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
}
