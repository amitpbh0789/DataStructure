package com.test.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.programiz.com/dsa/bucket-sort#java-code
 * Worst Case O(n^2)
 * Best Case O(n)
 * 
 * @author amit
 *
 */
public class BucketSort {

	public static void main(String[] args) {
		float arr[] = { (float)0.897, (float)0.565, 
                (float)0.656, (float)0.1234,  
                (float)0.665, (float)0.3434 }; 
		
		BucketSort obj = new BucketSort();
		obj.bucketSort(arr, arr.length);
	}
	
	public void bucketSort(float[] arr, int n) {
		
//		Step1 - Create a bucket of size n
		ArrayList<Float>[] bucket = new ArrayList[n];
		
//		Step2 Initialize each bucket 
		for(int i=0; i<n;i++) {
			bucket[i] = new ArrayList<>();
		}
		
//		Step3 - Iterate original array, calculate index and add into corresponding list of array
		for(int i=0; i<arr.length; i++) {
			int idx = (int)arr[i]*n;
			bucket[idx].add(arr[i]);
		}
		
//		Step4 - Sort each bucket
		for(int i=0; i<n; i++) {
			Collections.sort(bucket[i]);
		}
		
//		Step5 - add back into original list
		int index = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<bucket[i].size(); j++) {
				arr[index++] = bucket[i].get(j);
			}
		}
		
//		Step6 Print the array
		for(float f : arr)
			System.out.println(f);
	}
}
