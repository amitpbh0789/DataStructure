package com.test.algorithm.sort;

/**
 * 
 * ### In each iteration max element would be at right most side.
 * 
 * Time complexity: O(n ^ 2)
 * Space complexity: O(n)
 *  
 * @author amit
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		BubbleSort obj = new BubbleSort();
		int[] arr = {64, 34, 25, 12, 22, 11, 90};
		obj.bubbleSort(arr);
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
		System.out.println("\n"+"*** Optimized bubble sort ***");
		int[] arr1 = {64, 90, 12, 2, 6, 11, 90};
		obj.optimizedBubbleSort(arr1);
		
		for(int i : arr1) {
			System.out.print(i + " ");
		}
		
		
		System.out.println("\n"+"*** Recursive Solution for Bubble Sort ***");
		int[] arr2 = {64, 90, 12, 2, 6, 11, 90};
		obj.recursiveBubbleSort(arr2, arr2.length);
		
		for(int i : arr2) {
			System.out.print(i + " ");
		}
	}
	
	/**
	 * Time: O(n2)
	 * Space: O(1)
	 * @param arr
	 */
	private void bubbleSort(int arr[]) {
		
		int length = arr.length;
		for(int i=0; i<length-1; i++) {
			for(int j=0; j<length-i-1; j++) { // length-i-1 -> coz In each iteration max element 
//				would be at right most side. We dont have look at last element at each iteration.
				
				if(arr[j+1]<arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * Worst case Time: O(n2)
	 * Best Case time: O(n)
	 * Space: O(1)
	 * @param arr
	 */
	private void optimizedBubbleSort(int arr[]) {
		
		boolean flag;
		for(int i=0; i<arr.length-1; i++) {
			flag = false;
			for(int j=0; j<arr.length-i-1; j++) {
				
				if(arr[j+1]<arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = true;
				}
			}
			if(!flag)
				break;
		}
	}
	
	
	/**
	 * Time complexity: O(n ^ 2)
	 * Space complexity: O(n)
	 * @param arr
	 * @param n
	 */
	private void recursiveBubbleSort(int[] arr, int n) {
		
		if(n==1)
			return;
		
		for(int i=0; i<n-1; i++) {
			if(arr[i+1]<arr[i]) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
		recursiveBubbleSort(arr, n-1);
	}
}
