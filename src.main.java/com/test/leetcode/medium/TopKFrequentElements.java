package com.test.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 
 * @author amit
 *
 */
public class TopKFrequentElements {

	public static void main(String[] args) {

		TopKFrequentElements obj = new TopKFrequentElements();
		int[] nums = {1,1,1,2,2,3,3,3,3,3,3,3};
		int k = 2;
		int[] res = obj.topKFrequent(nums, k);
		for(int i : res)
			System.out.println(i);
	}

	public int[] topKFrequent(int[] nums, int k) {

		int[] res = new int[k];
		if(nums == null || nums.length == 0)
			return res;

		Map<Integer, Integer> map = new HashMap<>();

		for(int i : nums) {
			map.put(i, map.getOrDefault(i, 0)+ 1);
		}

//	IMP  It will reverse the pq Java8 feature
		PriorityQueue<Map.Entry<Integer, Integer>> pq =
	            new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());
//		Add all the map entry in sorted order as per value
	    pq.addAll(map.entrySet());

//	    Iterate and take out top k elements and add into res
		for(int i=0; i<k; i++) {
			res[i] = pq.poll().getKey();
		}
		return res;

	}
}
