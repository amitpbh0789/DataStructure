package com.test.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 * 
 * @author amit
 *
 */
public class SortCharactersByFrequency {

	public static void main(String[] args) {
		
		SortCharactersByFrequency obj = new SortCharactersByFrequency();
		System.out.println(obj.frequencySort("tree"));

	}

	public String frequencySort(String s) {

		if(s == null || s.length() == 0)
			return "";

		Map<Character, Integer> map = new HashMap<>();
		for(char c : s.toCharArray()){
			map.put(c, map.getOrDefault(c, 0)+1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

		pq.addAll(map.entrySet());

		StringBuilder sb = new StringBuilder();

		while(!pq.isEmpty()){
			Map.Entry mapEntry = pq.poll();

			for(int i =0; i<(int)mapEntry.getValue(); i++){
				sb.append(mapEntry.getKey());
			}
		}

		return sb.toString();
	}

}
