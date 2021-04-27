package com.test.algorithm.sort;

/**
 * 1. Keep on dividing until reaches to one element
 * 2. Merge 
 * 
 * 
 * Time: O(nlogn)
 * Space: O(n)
 * 
 * @author amit
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		MergeSort obj = new MergeSort();
		int[] arr = {12, 11, 13, 5, 6, 7};
		int l=0;
		int r = arr.length-1;
		obj.mergeSort(arr,l,r);
		
		for(int a : arr) {
			System.out.print(a+" ");
		}
	}
	
	private void mergeSort(int[] arr, int l, int r) {
		
		if(l<r) {
			
			int mid = l + (r-l)/2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, r);
			
			merge(arr, l, mid, r);
		}
	}
	
	private void merge(int[] arr, int l, int m, int r) {
		
//		Get the size of 2 subarrays
		int n1 = m-l+1;
		int n2 = r-m;
		
//		Create Temp arrays based on above size;
		int[] L = new int[n1];
		int[] R = new int[n2];
		
//		copy data 
		
		for(int i=0; i<n1; i++)
			L[i] = arr[l+i];
		for(int j=0; j<n2; j++)
			R[j] = arr[m+1+j];
		
		// Initial indexes of first and second subarrays 
		int i=0, j=0;
		// Initial index of merged subarry array 
        int k = l; 
		
//		Merge two arrays. Actual sorting happens here
		while(i<n1 && j<n2) {
			if(L[i]<=R[j]) {
				arr[k++] = L[i++];
			}else {
				arr[k++] = R[j++];
			}
		}
		
//		Now add remaining array elements into arr
		while(i<n1) {
			arr[k++]=L[i++];
		}
		
		while(j<n2) {
			arr[k++] = R[j++];
		}
		
	}
}
