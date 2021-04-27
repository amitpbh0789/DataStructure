package com.test.leetcode.medium.locked;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * 
 * Given a string s and an integer k, return the length of the longest substring of s that contains 
 * at most k distinct characters.
 * 
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: The substring is "ece" with length 3
 * 
 * 
 * Algorithm: Sliding Window approach
 * 
 * Return 0 if the string is empty or k is equal to zero.
 * Set both set pointers in the beginning of the string left = 0 and right = 0 and init max substring length max_len = 1.
 * While right pointer is less than N:
 	* Add the current character s[right] in the hashmap and move right pointer to the right.
 	* If hashmap contains k + 1 distinct characters, remove the leftmost character from the hashmap and move the 
 	* left pointer so that sliding window contains again k distinct characters only.
 	* Update max_len.
 	* 
 *
 *	Time: O(N)
 *	Space: O(K)
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

	public static void main(String[] args) {
		LongestSubstringWithAtMostKDistinctCharacters obj = new LongestSubstringWithAtMostKDistinctCharacters();
		String s = "eceeeba";
		int k = 3;
		System.out.println(obj.lengthOfLongestSubstringKDistinct(s, k));
	}
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n * k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;

        Map<Character, Integer> rightmostPosition = new HashMap<>();

        int maxLength = 1;

        while (right < n) {
            rightmostPosition.put(s.charAt(right), right++); // put into map and increase the right pointer
// rightmostPosition contains just last index of existance
            if (rightmostPosition.size() == k + 1) {
                int lowestIndex = Collections.min(rightmostPosition.values());
                rightmostPosition.remove(s.charAt(lowestIndex));
                left = lowestIndex + 1;
            }

            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
