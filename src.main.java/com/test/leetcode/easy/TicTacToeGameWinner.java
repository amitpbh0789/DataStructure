package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
 *
 */
public class TicTacToeGameWinner {

	public static void main(String[] args) {
		
		TicTacToeGameWinner obj = new TicTacToeGameWinner();
		int[][] moves = new int[][] {{0,0},{2,0},{1,1},{2,1},{2,2}};
		System.out.println(obj.tictactoe(moves));

	}

	public String tictactoe(int[][] moves) {
		int dia = 0;
		int reverseDia= 0; 
		
		int[] rows = new int[3];
		int[] cols = new int[3];

		int turn = 1;
		
		for(int[] move : moves){
			int r = move[0];
			int c = move[1];
			if(r == c) 
				dia+=turn;
			if(r + c == 2) 
				reverseDia+=turn;
			
			rows[r]+=turn;
			cols[c]+=turn;

			if(Math.abs(dia) == 3 || Math.abs(reverseDia) == 3 || 
					Math.abs(rows[r]) == 3 || Math.abs(cols[c]) == 3) 
				return turn == 1 ? "A" : "B"; 

			turn *= -1; 
		}
		return moves.length == 9? "Draw" : "Pending";
	}

}
