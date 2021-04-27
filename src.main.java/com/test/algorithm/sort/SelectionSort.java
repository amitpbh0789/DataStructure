package com.test.algorithm.sort;

/**
 * ### Find the minimum element in arr and place it at beginning
 * 
 * Time Complexity: O(n2) as there are two nested loops.
 * Space Complexity: O(1)
 * 
 * @author amit
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		
		SelectionSort obj = new SelectionSort();
		int[] arr = {64, 34, 25, 12, 22, 11, 90};
		obj.selectionSort(arr);
		
		for(int i : arr) {
			System.out.print(i+" ");
		}
		
		System.out.println("\n" + "Recursive solution");
		int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
		obj.recusriveSelectionSort(arr1, 0);
		
		for(int i : arr1) {
			System.out.print(i+" ");
		}
		
	}
	
	/**
	 * Time Complexity: O(n2) as there are two nested loops.
	 * Space Complexity: O(1)
	 * 
	 * @param arr
	 */
	private void selectionSort(int[] arr) {
		
		for(int i=0; i<arr.length-1; i++) {
			int min_index = i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j]<arr[min_index]) {
					min_index = j;
				}
			}
			int temp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = temp;
		}
	}
	
	/**
	 * Time Complexity: O(n2) as there are two nested loops.
	 * Space Complexity: O(1)
	 * 
	 * @param arr
	 */
	private void recusriveSelectionSort(int[] arr, int position) {
		
		if(position == arr.length)
			return;
		
		int min_index = position;
		for(int i=position; i<arr.length-1; i++) {

			if(arr[i+1]<arr[i]) {
				min_index = i+1;
			}
			
		}
		int temp = arr[min_index];
		arr[min_index] = arr[position];
		arr[position] = temp;
		
		recusriveSelectionSort(arr, position+1);
	}
}
