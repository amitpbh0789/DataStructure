package com.test.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxVowels {

	public static void main(String[] args) {
		
		String s= "abciiidef";
		int k = 3;
		
		MaxVowels obj = new MaxVowels();
		obj.maxVowels(s, k);
	}
	
	public int maxVowels(String s, int k) {
	    
		Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		
        int max = 0, n = s.length();
        int count = 0;
        for(int i = 0; i < k; i++) {
            if(vowels.contains(s.charAt(i))) count++;
        }
        max = count;
		// build first window size k
        for(int  i = k; i < n; i++) {
			// remove the contribution of the (i - k)th character which is no longer in the window
            if(vowels.contains(s.charAt(i - k))) count--;
			// add the contribution of the current character
            if(vowels.contains(s.charAt(i))) count++;
			// update max at for each window of size k
            max = Math.max(max, count);
        }
        return max;
    }
}
