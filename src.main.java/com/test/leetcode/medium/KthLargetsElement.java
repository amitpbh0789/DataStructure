package com.test.leetcode.medium;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * 
 * @author amit
 *
 */
public class KthLargetsElement {


	public static void main(String[] args) {

		int[] arr = {3,2,3,1,2,4,5,5,6,10};
		int k = 10;
		System.out.println(findKthLargestElement(arr, k));
	}
	private static int findKthLargestElement(int[] arr, int k) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for(int i:arr)
		{
			minHeap.add(i);
			if(minHeap.size()>k)
			{
				minHeap.poll();
			}
		}

		return minHeap.peek();
	}
}
