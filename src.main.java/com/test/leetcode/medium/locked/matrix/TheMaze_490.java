package com.test.leetcode.medium.locked.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). 
 * The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. 
 * When the ball stops, it could choose the next direction.

Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] 
and destination = [destinationrow, destinationcol], return true if the ball can stop at the destination, otherwise return false.

You may assume that the borders of the maze are all walls (see examples).

BFS solution

Idea: 
1. Will add start position into queue and follow standard process of getting the current cell and going in all 4 directions. 
2. Catch: Once you get next cell, you can not stop until hit the wall
3. once you hit the wall, you need to reduce it to prev cell as current one will be pointing to wall
4. check if destination then return true else add into queue for further pricessing 
5. return false at the end
 */
public class TheMaze_490 {
	
	public static void main(String[] args) {
		
	}
	
	public boolean hasPathBFS(int[][] maze, int[] start, int[] destination) {
		int[][] directions = new int[][] {{1,0}, {0,1}, {-1, 0}, {0,-1}};
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {start[0], start[1]});
		maze[start[0]][start[1]] = 2; // marking as visited
		
		while(!queue.isEmpty()) {
			int[] currCell = queue.poll();
			int cr = currCell[0];
			int cc = currCell[1];
			
			for(int[] dir : directions) {
				
				while(cr >= 0 && cr <= maze.length && cc >= 0 && cc <= maze.length && maze[cr][cc] != 1) { // keep rolling until you get the wall
					cr += dir[0];
					cc += dir[1];
				}
				// now roll back to just prev cell before hitting wall
				cr -= dir[0];
				cc -= dir[1];
				
				if(maze[cr][cc] != 2) {
					if(cr == destination[0] && cc == destination[1]) {
						return true;
					}
					queue.add(new int[] {cr, cc});
					maze[cr][cc] = 2; // Mark as visited
				}
			}
		}
		return false;
	}

}
