package com.test.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {

	public static void main(String[] args) {

		ContainsDuplicateIII obj = new ContainsDuplicateIII();
		int[] nums = {-1,2147483647};
		int k = 1;
		int t = 2147483647;
		System.out.println(obj.containsNearbyAlmostDuplicate(nums, k, t));
	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		Map<Integer, Integer> map = new HashMap<>();

		for(int i=0; i<nums.length; i++){

			int current = nums[i];

			for(Integer value : map.keySet()){
				int diff;
				if(current>value)
					diff = current - value;
				else
					diff = value-current;
					
				if(diff <= t && Math.abs(i-map.get(value))<=k){
					return true;
				}
			}
			map.put(current, i);
		}

		return false;
	}
}
