package com.test.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MaxFrequency {

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,1,4,2};
        System.out.println(degreeOfArray(arr));
    }
    
    private static int degreeOfArray(int[] arr) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        int degree = 0;
        for(Integer key : map.keySet()) {
            if(map.get(key)>degree) {
                degree += map.get(key)+1;
            }
        }
        return degree;
    }
}
