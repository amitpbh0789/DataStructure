package com.test.leetcode.easy;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		int[] arr = {2,4,6,3,8,10};
		int key = 9;
		int[] result = twoSum(arr, key);
		System.out.println(result[0]+" and "+result[1]);
	}
	
	public static int[] twoSum(int[] inputArray, int key) {
		
		if(inputArray == null) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] result = new int[2];
		for(int i=0; i<inputArray.length; i++) {
			
			if(map.containsKey(key-inputArray[i])) {
				result[1] = i;
				result[0] = map.get(key-inputArray[i]);
			}
			map.put(inputArray[i], i);
		}
		return result;
	}
}
