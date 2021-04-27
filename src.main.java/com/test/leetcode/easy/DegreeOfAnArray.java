package com.test.leetcode.easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/degree-of-an-array/
 * 
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as
 *  the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums,
 *  that has the same degree as nums.
 *  Input: [1, 2, 2, 3, 1]
 *  Output: 2
 *  Explanation: 
 *  The input array has a degree of 2 because both elements 1 and 2 appear twice.
 *  Of the subarrays that have the same degree:
 *  [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 *  The shortest length is 2. So return 2.
 *  
 * @author amit
 *
 */
public class DegreeOfAnArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(nums));
    }
    
    private static int findShortestSubArray(int[] nums) {
        
        Map<Integer, Integer> leftMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> rightMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums.length; i++) {
            if(leftMap.get(nums[i]) == null)
                leftMap.put(nums[i], i);
            rightMap.put(nums[i], i);
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0)+1);
        }
        
        int result = nums.length;
        int maxOccurance = Collections.max(countMap.values());
        
        for(Integer num : countMap.keySet()) {
            if(countMap.get(num) == maxOccurance) {
                result = Math.min(result, (rightMap.get(num) - leftMap.get(num))+1);
            }
        }
        
        return result;
    }
}
