package com.test.algorithm.sort;

/**
 * https://www.geeksforgeeks.org/quick-sort/
 *	Worst Case:  O(n2)
 *	Average: NlogN
 */
public class QuickSort {
	
	public static void main(String[] args) {
		int arr[] = {10, 7, 8, 9, 1, 5}; 
        int n = arr.length;
        
        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);
        System.out.println("Sorted");
        for(int i=0; i<arr.length; i++)
        	System.out.println(arr[i]);
	}
	
	public void sort(int[] arr, int low, int high) {
		
		if(low<high) {
			int pivot = partition(arr, low, high); 
			sort(arr, low, pivot-1);
			sort(arr, pivot, high);
		}
	}

	public int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low-1;
		
		for(int j=low; j<high; j++) {
			if(arr[j]<pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		
		return i+1;
	}

}


