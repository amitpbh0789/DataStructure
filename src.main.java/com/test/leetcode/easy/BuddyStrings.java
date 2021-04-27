package com.test.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/buddy-strings/
 * 
 * @author amit
 *
 */
public class BuddyStrings {

	public static void main(String[] args) {
		BuddyStrings obj = new BuddyStrings();
		String A = "ab";
		String B = "ab";
		System.out.println(obj.buddyStrings(A, B));
	}
	
	public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length())
            return false;
        Set<Character> set = new HashSet<>();
//         This If condition will handle cases where A and B is equal. We need to check there any duplicate.
//        If duplicate found the true else false. e.g. AA, AA and AB, AB
        if(A.equals(B)){
            for(char c: A.toCharArray()){
                set.add(c);
            }
            return set.size()<A.length();
        }
            
//         Now we need to check count of diff. It should 2 and index of 0 in A should be equal to 
//        index of 1 in B and vice versa.
        List<Integer> dif = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) 
            if (A.charAt(i) != B.charAt(i)) 
                dif.add(i);
        
        return dif.size() == 2 && A.charAt(dif.get(0)) == B.charAt(dif.get(1)) && A.charAt(dif.get(1)) == B.charAt(dif.get(0));
        
    }
}
