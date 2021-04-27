package com.test.leetcode.medium;

/**
 * https://leetcode.com/problems/surrounded-regions/
 * 
 * @author amit
 *
 ******DFS Solution*******
 */
public class SurroundedRegions {

	public static void main(String[] args) {

		SurroundedRegions obj = new SurroundedRegions();
		char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
		obj.solve(board);
	}

	public void solve(char[][] board) {
		
		if (board.length == 0 || board[0].length == 0) 
			return;
        if (board.length < 3 || board[0].length < 3) 
        	return;

		int m = board.length;
		int n = board[0].length;
		
//		//Any 'O' connected to a boundary can't be turned to 'X', so ...
		//Start from first and last column, turn 'O' to '*'.
		for(int i=0; i<m; i++) {
			if(board[i][0] == 'O')
				helper(board, i, 0);
			if(board[i][n-1]=='O')
				helper(board, i, n-1);
		}
		
		//Start from first and last row, turn '0' to '*'
		for(int j=0; j<n; j++) {
			if(board[0][j]=='O')
				helper(board, 0, j);
			if(board[m-1][j]=='O')
				helper(board, m-1, j);
		}
		
		//post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(board[i][j] == 'O')
					board[i][j] = 'X';
				if(board[i][j] == '*')
					board[i][j] = 'O';
			}
		}
		
	}
	
	/**
	 * //Use DFS algo to turn internal however boundary-connected 'O' to '*';
	 * 
	 * @param board
	 * @param i
	 * @param j
	 */
	private void helper(char[][] board, int i, int j) {
	
		if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || board[i][j] != 'O')
			return;
		
		board[i][j] = '*';
		helper(board, i-1, j);
		helper(board, i+1, j);
		helper(board, i, j-1);
		helper(board, i, j+1);
		
	}
}
