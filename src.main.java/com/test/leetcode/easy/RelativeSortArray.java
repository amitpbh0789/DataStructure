package com.test.leetcode.easy;

import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * https://leetcode.com/problems/relative-sort-array/
 * 
 * @author amit
 *
 */
public class RelativeSortArray {

	public static void main(String[] args) {

		RelativeSortArray obj = new RelativeSortArray();
		int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
		int[] arr2 = {2,1,4,3,9,6};
		int[] res = obj.relativeSortArray(arr1, arr2);
	}

	public int[] relativeSortArray(int[] arr1, int[] arr2) {

		Map<Integer, Integer> map = new TreeMap<>();
		for(int i=0; i<arr1.length; i++){
			map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
		}

		int index = 0;
		for(int j=0; j<arr2.length; j++){

			int count = map.get(arr2[j]);
			for(int k=0; k<count; k++){
				arr1[index++] = arr2[j];
			}
			map.remove(arr2[j]);
		}

		for(int key :  map.keySet()){
			for(int j = 0; j < map.get(key); j++) {
				arr1[index++] = key;
			}
		}
		return arr1;
	}
}
