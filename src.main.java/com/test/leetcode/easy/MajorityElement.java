package com.test.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * Input: [3,2,3]
 * Output: 3
 * 
 * @author amit
 *
 */
public class MajorityElement {

	public static void main(String[] args) {
		int[] arr = {2,2,1,1,1,2,2};
		System.out.println(mejorityElement(arr));
		
	}
	private static int mejorityElement(int[] arr) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		
		for(Integer n : map.keySet()) {
			if(map.get(n)>(arr.length/2)) {
				return n;
			}
		}
		return 0;
	}
}
