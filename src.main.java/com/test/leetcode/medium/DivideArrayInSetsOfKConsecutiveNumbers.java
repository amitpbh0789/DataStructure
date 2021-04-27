package com.test.leetcode.medium;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 *
 */
public class DivideArrayInSetsOfKConsecutiveNumbers {
	
	public static void main(String[] args) {
		DivideArrayInSetsOfKConsecutiveNumbers obj = new DivideArrayInSetsOfKConsecutiveNumbers();
		int[] nums = new int[] {1,2,3,6,2,3,4,7,8};
		int k = 3;
		System.out.println(obj.isPossibleDivide(nums, k));
	}

	public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        
        for(int i : nums)
            treeMap.put(i, treeMap.getOrDefault(i, 0)+1);
        
        while(treeMap.size()>0){
            int first = treeMap.firstKey();
            
            for(int j=first; j<first+k; j++){
                if(!treeMap.containsKey(j)){
                    return false;
                }
                int count = treeMap.get(j);
                if(count==1)
                    treeMap.remove(j);
                else
                    treeMap.replace(j, count-1);
            }
        }
        return true;
    }
}
