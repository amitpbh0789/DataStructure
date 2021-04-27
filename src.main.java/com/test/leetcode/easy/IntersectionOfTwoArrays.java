package com.test.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * 
 * Given two arrays, write a function to compute their intersection.
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * @author amit
 *
 */
public class IntersectionOfTwoArrays {
	
	public static void main(String[] args) {
		
		int[] arr1 = {1,2,2,1};
		int[] arr2 = {2,2};
		int[] resultSet = findIntersection(arr1, arr2);
		for(int i=0; i<resultSet.length; i++) {
			System.out.println(resultSet[i]);
		}
	}
	
	private static int[] findIntersection(int[] arr1, int[] arr2) {
		
		Set<Integer> resultSet = new HashSet<>();
		
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<arr1.length; i++) {
			set.add(arr1[i]);
		}
		
		for(int i=0; i<arr2.length; i++) {
			if(set.contains(arr2[i])) {
				resultSet.add(arr2[i]);
			}
		}
		int count = 0;
		int[] result = new int[resultSet.size()];
		for(int num : resultSet) {
			result[count] = num;
			count++;
		}
		return result;
	}

}
