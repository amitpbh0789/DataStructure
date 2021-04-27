package com.test.algorithm.search;

/**
 * https://www.geeksforgeeks.org/linear-search/
 * 
 * @author amit
 *
 */
public class LinearSearch {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 10, 40 };  
	    int item = 10;
	    System.out.println(linearSearch(arr, item));
	}
	
	/**
	 * @param arr
	 * @param item
	 * @return
	 */
	private static int linearSearch(int[] arr, int item) {
		
		for(int i=0; i<arr.length; i++) {
			
			if(arr[i] == item)
			return i;
		}
		
		return -1;
	}
}
