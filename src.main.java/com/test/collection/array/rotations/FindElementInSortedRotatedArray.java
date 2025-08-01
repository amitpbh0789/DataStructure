package com.test.collection.array.rotations;

/**
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 * 
 * Given a sorted and rotated array arr[] of size N and a key, the task is to find the key in the array.
 * 
 * Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}, key = 3
 * Output : Found at index 8
 * 
 * Time: O(log N) Binary Search requires log n comparisons to find the element.
 * Space: O(1)
 */
public class FindElementInSortedRotatedArray {

	public static void main(String[] args) {
		int [] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		int key = 3;
		FindElementInSortedRotatedArray obj = new FindElementInSortedRotatedArray();
		System.out.println(obj.findElement(arr, arr.length, key));
	}
	
	/**
	 * Logic to find out the key once you know from where Array is Rotated
	 */
	private int findElement(int arr[], int n, int key) {
		// Find the Pivot Index
		int pivot = findPivot(arr, 0, n - 1);
		
		// If Pivot was not found, then Arrays is not rotated we can apply Binary Search directly
		if(pivot == -1)
			binarySearch(arr, 0, n-1, key);
		
		//If we found a pivot, then first compare with pivot
		if(arr[pivot] == key)
			return pivot;
		
		// then search in two subarrays around pivot
		if(arr[0]<=key)
			return binarySearch(arr, 0, pivot-1, key);
		return binarySearch(arr, pivot+1, n-1, key);
	}
	
	/**
	 * To Calculate from where array is rotated. Rotation Index
	 */
	private int findPivot(int arr[], int low, int high) {
		// base cases
        if (high < low)
            return -1;
        if (high == low)
            return low;
 
        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        return findPivot(arr, mid + 1, high);
	}
	
	/**
	 * Normal Binary Search Logic
	 */
	private int binarySearch(int[] arr, int low, int high, int key) {
		
		if (high < low)
            return -1;
 
        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid - 1), key);
		
	}
}
