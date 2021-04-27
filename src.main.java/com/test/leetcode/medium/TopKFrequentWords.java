package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 * 
 * @author amit
 *
 */
public class TopKFrequentWords {

	public static void main(String[] args) {

		TopKFrequentWords obj = new TopKFrequentWords();
		String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		int k = 4;
		System.out.println(obj.topKFrequent(words, k));

	}

	public List<String> topKFrequent(String[] words, int k) {

		List<String> list = new ArrayList<>();
		if(words == null || words.length == 0)
			return list;

		Map<String, Integer> map = new HashMap<>();
		for(String str : words) {

			map.put(str, map.getOrDefault(str, 0)+1);
		}

//		IMP 
		PriorityQueue<Map.Entry<String,Integer>> maxHeap = new PriorityQueue<>(k, (a,b) -> 
        a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue()-a.getValue()); 

		maxHeap.addAll(map.entrySet());

		for(int i=0; i<k; i++) {
			list.add(maxHeap.poll().getKey()); //Adding to 0 index to have entries reversed
		}

		return list;
	}
}
