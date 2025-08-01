package com.test.leetcode.medium.locked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestCommonSubsequenceBetweenSortedArrays {
	public static void main(String[] args) {
		LongestCommonSubsequenceBetweenSortedArrays obj = new LongestCommonSubsequenceBetweenSortedArrays();
		obj.getCommon();
		
	}
	
	private List<Integer> getCommon(){
		int[][] arrays = new int[][] {{1, 2, 3, 4}, {1, 3, 5, 7, 9, 11}, {1, 3, 4, 5, 7}};
		List<Integer> ans = new ArrayList<>();
        if(arrays == null || arrays.length == 1){
            return ans;
        }

        int[] prev = arrays[0];
        
        for(int i=1; i<arrays.length; i++){
            prev = getCommonSubSequenceUsingPointers(prev, arrays[i]);
        }

        for(int i:prev) {
        	System.out.println(i);
        }
        
        // Find subsequence using Map
        List<Integer> list = getCommonSubSequenceUsingMap(arrays);
        return list;
	}
	
	/**
	 * Using two Pointer 
	 */
	private int[] getCommonSubSequenceUsingPointers(int[] arr1, int[] arr2){
        int i=0;
        int j=0;
        List<Integer> list = new ArrayList<>();
        while(i<arr1.length && j<arr2.length){
            if(arr1[i] == arr2[j]){
                list.add(arr1[i]);
                i++;
                j++;
            } else if(arr1[i]<arr2[j]){
                i++;
            } else if (arr2[j]<arr1[i]){
                j++;
            }
        }

        return list.stream().mapToInt(k->k).toArray();
    }
	
	/**
	 * Since Arrays are strictly sorted so I'm assuming there would not be a duplicate number and all the arrays would be sorted in increasing order.
	 * Since it is strictly sorted, I can rely on each numbers total frequency in all the array
	 * If any number is common then frequency should be equals to size of the input Array
	 * 
	 * Also:
	 * Create Map to store number and frequency. 
	 * Fetch all the keys whose frequency matches with size of the array
	 */
	private List<Integer> getCommonSubSequenceUsingMap(int[][] arrays){
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int[] arr : arrays) {
			for(int i: arr) {
				map.put(i, map.getOrDefault(i, 0) + 1);
			}
		}
		
		Set<Integer> keys = map.keySet();
		int size = arrays.length;
		List<Integer> ans = new ArrayList<>();
		for(Integer key : keys) {
			if(map.get(key) == size) {
				ans.add(key);
			}
		}
		
		System.out.println(ans);
		return ans;
		
	}
	
	
/**
Tabulation|Bottom Up | Iterative solution

Approach
d[i][j] : LCS between str1(0...i) and str2(0...j)
If match: d[i][j] = 1 + d[i−1][j−1])
If not match: d[i][j] = max(d[i−1][j]), d[i][j−1]d[i])

Time complexity: O(m*n)
Space complexity: O(m*n)

*/
	public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        
        for(int i=m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        // return the value at dp[0][0]
        return dp[0][0];
    }  

}
