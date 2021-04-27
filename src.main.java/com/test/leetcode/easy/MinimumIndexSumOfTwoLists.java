package com.test.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 * 
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite
 * restaurants represented by strings.You need to help them find out their common interest with the least
 * list index sum. If there is a choice tie between answers, output all of them with no order requirement.
 * You could assume there always exists an answer.
 * 
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".

 * @author amit
 *
 */
public class MinimumIndexSumOfTwoLists {

	public static void main(String[] args) {
		String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
		String[] result = findRestaurant(list1, list2);
		System.out.println(result[0]);
	}
	private static String[] findRestaurant(String[] list1, String[] list2) {
        
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		for(int i=0; i<list1.length; i++) {
			map1.put(list1[i], i);
		}
		
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		for(int i=0; i<list2.length; i++) {
			map2.put(list2[i], i);
		}
		String[] result = new String[1];
		int min = Integer.MAX_VALUE;
		int[] indexArr = new int[2];
		for(String restro : map1.keySet()) {
			if(map2.containsKey(restro) && map2.get(restro)+ map1.get(restro)<min) {
				min = map2.get(restro)+ map1.get(restro);
				indexArr[0] = map1.get(restro);
				indexArr[1] = map2.get(restro);
			}
		}
		for(int i=0; i<list1.length; i++) {
			if(i==indexArr[0]) {
				result[0] = list1[i];
			}
		}
		return result;
    }
}
