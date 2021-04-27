package com.test.leetcode.medium;

/**
 * https://leetcode.com/problems/word-search/
 * 
 * @author amit
 *
 */
public class WordSearch {

	public static void main(String[] args) {

		WordSearch obj = new WordSearch();
		char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
		String word = "ABCB";
		
		System.out.println(obj.exist(board, word));
		
	}

	public boolean exist(char[][] board, String word) {

		if(board == null || board.length == 0 || board[0].length == 0)
			return false;
		
		int m = board.length;
		int n = board[0].length;
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				
				if(wordSearch(board, word, 0, i, j)) {
					return true;
				}
			}
		}
		return false;
		
	}
	
	
	private boolean wordSearch(char[][] board, String word, int index, int i, int j) {
		
		if(index == word.length())
			return true;
		
		int m = board.length;
		int n = board[0].length;
		
//		Boundary condition. Row and column should not be less than 0 or greater than the length and 
//		if word index character doesn't match with matrix character at position i*j return false
		if(i<0 || i>=m || j<0 || j>=n || word.charAt(index) != board[i][j])
			return false;
		
		char c = board[i][j];
		
//		Making current index value as * so that same letter cell may not be used more than once.
		board[i][j] = '*';
		
		boolean res = wordSearch(board, word, index+1, i-1, j) || // check for above value
					  wordSearch(board, word, index+1, i+1, j) || // check for below value
					  wordSearch(board, word, index+1, i, j-1) || // check for left value
					  wordSearch(board, word, index+1, i, j+1);   // check for right value
		
//		Assign back to original value.
		board[i][j] = c;
		
		return res;
		
	}
}
