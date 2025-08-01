package com.test.collection.array.product;

import java.util.HashSet;
import java.util.Set;

/**
 * Working solution: https://leetcode.com/problems/maximum-product-of-word-lengths/description/
 * 
 * Given a string array words, return the maximum value of length(word[i]) * length(word[j]) 
 * where the two words do not share common letters. If no such two words exist, return 0.
 *  
 */

public class MaximumProductOfWordLengths {

	public static void main(String[] args) {
		MaximumProductOfWordLengths obj = new MaximumProductOfWordLengths();
		String[] words = new String[] {"a","ab","abc","d","cd","bcd","abcd"};
		System.out.println(obj.maxProduct(words));

	}
	
	public int maxProduct(String[] words) {
		int max = 0;
        for(int i=0; i<words.length-1; i++) {
            Set<Character> set = new HashSet<Character>();
            char[] arrStr = words[i].toCharArray();
			for(char c : arrStr){
                set.add(c);
            }
            for(int j=i+1; j<words.length; j++) {
                char[] str = words[j].toCharArray();
                boolean matched = false;
                for(char c : str){
                    if(set.contains(c)) {
                    	matched = true;
                        break;
                    }
                }
                if(!matched) {
                	max = Math.max(max, arrStr.length *str.length);
                }
                
            }
            
        }
        return max;
    }

}
