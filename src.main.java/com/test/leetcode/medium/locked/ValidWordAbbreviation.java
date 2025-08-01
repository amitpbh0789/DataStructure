package com.test.leetcode.medium.locked;

/**
 * Given a non-empty string word and an abbreviation abbr, return whether the string matches with the given abbreviation. 
 * A string such as "word" contains only the following valid abbreviations:
 * 
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * 
 * Input : s = "internationalization", abbr = "i12iz4n"
 * Output : true
 * 
 * Input : s = "apple", abbr = "a2e"
 * Output : false
 * 
 * Time: O(M+N), M and N is the length of the word and abbreviation
 * Space: O(1)
 */
public class ValidWordAbbreviation {
	
	public static void main(String[] args) {
		
		System.out.println(ValidWordAbbreviation.validWordAbbreviation("internationalization", "i12iz4n"));
		
	}
	
	private static boolean validWordAbbreviation(String word, String abbr) {
		int m = word.length();
		int n = abbr.length();
		int i=0;
		int j=0;
		int x = 0;
		
		while(i<m && j<n) {
			char c = abbr.charAt(j);
			
			if(Character.isDigit(c)) {
				if (c == '0' && x == 0) {
                    return false;
                }
                x = x * 10 + (c - '0');
			} else {
				i = i+x;
				x = 0;
				if(i>=m || word.charAt(i) != c) {
					return false;
				}
				i++;
			}
			j++;
		}
		
		return i+x == m && j == n;
	}

}
