package com.test.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-distance-in-arrays/
 * 
 * @author amit
 *
 */
public class MaximumDistanceInArrays {

	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		Collections.sort(list);
		lists.add(list);
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(4);
		list1.add(5);
		Collections.sort(list1);
		lists.add(list1);
		List<Integer> lis3 = new ArrayList<Integer>();
		lis3.add(1);
		lis3.add(2);
		lis3.add(9);
		Collections.sort(lis3);
		lists.add(lis3);
		
		System.out.println(findMaxDistance(lists));
	}
	private static int findMaxDistance(List<List<Integer>> lists) {
		
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(List<Integer> list : lists) {
			if(list != null && list.get(0)<min) {
				min = list.get(0);
			}
			int size = list.size()-1;
			if(list != null && list.get(size)>max) {
				max = list.get(size);
			}
		}
		return max-min;
	}
}
