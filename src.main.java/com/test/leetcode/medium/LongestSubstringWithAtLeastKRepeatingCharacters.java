package com.test.leetcode.medium;

/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * 
 * Approach: Divide And Conquer
 * 
 * Formula: longestSustring(start, end) = max(longestSubstring(start, mid), longestSubstring(mid+1, end))
 * Problem: Finding the split position (mid)
 * 
 * Solution: The string would be split only when we find an invalid character. 
 * An invalid character is the one with a frequency of less than k
 * 
 * Time : O(N^2)
 * Space: O(N)
 *
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

	public static void main(String[] args) {
		LongestSubstringWithAtLeastKRepeatingCharacters obj = new LongestSubstringWithAtLeastKRepeatingCharacters();
		String s = "aaabbb";
		int k = 3;
		int res = obj.longestSubstringUtil(s, 0, s.length(), k);
		System.out.println(res);
	}
	
	public int longestSubstringUtil(String s, int start, int end, int k) {
        if (end < k) 
        	return 0;
        int[] countMap = new int[26];
        // update the countMap with the count of each character
        for (int i = start; i < end; i++)
            countMap[s.charAt(i) - 'a']++;
        
        // iterate through, whenever char encounter with frequency <k split the array
        for (int mid = start; mid < end; mid++) {
            if (countMap[s.charAt(mid) - 'a'] >= k) 
            	continue;
            int midNext = mid + 1;
            
            while (midNext < end && countMap[s.charAt(midNext) - 'a'] < k) // skip all the chars which has less frequency
            	midNext++;
            
            return Math.max(longestSubstringUtil(s, start, mid, k), longestSubstringUtil(s, midNext, end, k));
        }
        return (end - start);
    }
}
