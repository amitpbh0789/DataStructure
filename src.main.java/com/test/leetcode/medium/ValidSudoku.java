package com.test.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * 
 * @author amit
 *
 */
public class ValidSudoku {

	public static void main(String[] args) {
		
	}

	/**
	 * Working
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku(char[][] board) {
		
		HashSet<String> visited = new HashSet<>();
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				int currentVal = board[i][j];
				if(board[i][j] != '.') {
					
					if(!visited.add(currentVal + " for row "+i)
							|| !visited.add(currentVal + " for column "+j)
							|| !visited.add(currentVal + " for cube "+i/3+"-"+j/3)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	
	/**
	 * NOt working
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku2(char[][] board) {
		
		Set<Character> row = new HashSet<>();
		Set<Character> column = new HashSet<>();
		Set<Character> cube = new HashSet<>();
		
		for(int i=0; i<9; i++) {
			
			for(int j=0; j<9; j++) {
				
				if(board[i][j] != '.' && !row.add(board[i][j])) {
					return false;
				}
				if(board[j][i] != '.' && !column.add(board[j][i])) {
					return false;
				}
				
				int rowIndex = i/3;
				int colIndex = j/3;
				
				if(board[rowIndex][colIndex] != '.' && !cube.add(board[rowIndex][colIndex])) {
					return false;
				}
				
			}
		}
		return true;
	}
}
