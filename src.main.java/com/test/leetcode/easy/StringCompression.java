package com.test.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/string-compression/
 * 
 * Given an array of characters, compress it in-place.
 * The length after compression must always be smaller than or equal to the original array.
 * Every element of the array should be a character (not int) of length 1.
 * After you are done modifying the input array in-place, return the new length of the array.
 * 
 * Input:
 * ["a","a","b","b","c","c","c"]
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 * 
 * @author amit
 *
 */
public class StringCompression {

	public static void main(String[] args) {
		String str = "aabbccc";
		char[] chars = str.toCharArray();
		System.out.println(compress(chars));
	}
	
	private static int compress(char[] chars) {

        if(chars.length == 0 || chars == null) {
			return 0;
		}
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<chars.length; i++){
            map.put(chars[i], map.getOrDefault(chars[i], 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(char key : map.keySet()){
            sb.append(key);
            if(map.get(key) > 1){
                String num = map.get(key).toString();
                for(char c : num.toCharArray()){
                   sb.append(c); 
                }
            }
        }
        return sb.toString().toCharArray().length;
	}
}

