package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/shortest-distance-to-a-character/
 * 
 * Given a string S and a character C, return an array of integers representing the shortest distance 
 * from the character C in the string.
 * 
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * 
 * Time Complexity: O(N), where NN is the length of S. We scan through the string twice.
 * Space Complexity: O(N), the size of ans
 */
public class ShortestDistanceToACharacter {

	public static void main(String[] args) {
		String S = "loveleetcode";
		char C = 'e';
		ShortestDistanceToACharacter obj = new ShortestDistanceToACharacter();
		int[] res = obj.shortestToChar(S, C);
		System.out.println(res);
	}

	public int[] shortestToChar(String S, char C) {
		int[] res = new int[S.length()];
        int n = S.length();
        int prev = -n;
        
        for(int i=0; i<n; i++){ // move forward and calculate distance from C
            if(S.charAt(i)==C){
                prev = i;
            }
            res[i] = i - prev;
        }
        
//         Now start from last and move backward by calculating the min distance
        // pos = Integer.MAX_VALUE;
        for (int i = prev - 1; i >= 0; --i) {
             if(S.charAt(i) == C){
                prev = i;
            }
            res[i] = Math.min(res[i], prev-i);
        }
        return res;
	}
}
