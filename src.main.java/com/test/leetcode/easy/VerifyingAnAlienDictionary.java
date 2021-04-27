package com.test.leetcode.easy;

public class VerifyingAnAlienDictionary {

	public static void main(String[] args) {
		VerifyingAnAlienDictionary obj = new VerifyingAnAlienDictionary();
		String[] words = new String[] {"hello","leetcode"};
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		System.out.println(obj.isAlienSorted(words, order));
	}
	
	int[] mappings = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
    	
        for(int i=0; i<order.length(); i++){
            mappings[order.charAt(i)-'a'] = i;
        }
        
        for(int i=1; i<words.length; i++){
            if(bigger(words[i-1], words[i]))
                return false;
        }
        return true;
    }
    
    /*
    to compare 2 string
    return true if s1 is bigger than s2 else false;
    */
    public boolean bigger(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        
        for(int i=0; i<n && i<m; i++){
            if(s1.charAt(i) != s2.charAt(i))
                return mappings[s1.charAt(i)-'a']>mappings[s2.charAt(i)-'a']; // if char in s1 is greater than true else false;
        }
        return n>m; // incase lenght is not same then return true if s1 is bigger than s2
    }
}
