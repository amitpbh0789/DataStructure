package com.test.leetcode.medium.locked.matrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://www.lintcode.com/problem/663/
 * https://leetcode.com/problems/walls-and-gates/description/
 * 
 * -1 A wall or obstacle
 * 0 A Gate
 * Integer.MAX_VALUE INfinite number
 * 
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 * 
 * Approach:
 * 
 * Collect all the gates and add into queue
 * Process each gate at same level in once and update nearest places with required distance 
 * Once process is done, add new places into queue and iterate them 
 * 
 * [[3, -1, 0, 1], [2, 2, 1, -1], [1, -1, 2, -1], [0, -1, 3, 4]]
 * 
 */
public class WallsAndGates_MultiSourceBFS {

	public static void main(String[] args) {
		int[][] arr = new int[][] {
			{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
			{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE, -1}, 
			{Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1}, 
			{0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}};
			
			WallsAndGates_MultiSourceBFS obj = new WallsAndGates_MultiSourceBFS();
			int[][] ans = obj.wallsAndGate(arr);
			System.out.println(ans);

	}
	
	private int[][] wallsAndGate(int[][] graph){
		
		int row = graph.length;
		int col = graph[0].length;
		
		Queue<int[]> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(graph[i][j] == 0) {
					queue.add(new int[] {i, j});
					visited.add(i+""+j);
				}
			}
		}
		
		// Once all the initial Gates are added. Lets process them
		
		int distance = 0;
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				int[] room = queue.poll();
				int r = room[0];
				int c = room[1];
				graph[r][c] = distance;
				addRooms(graph, r+1, c, queue, visited);
				addRooms(graph, r-1, c, queue, visited);
				addRooms(graph, r, c+1, queue, visited);
				addRooms(graph, r, c-1, queue, visited);
			}
			distance++;
			
		}
		return graph;
	}
	
	// Add condition for visited nodes
	private void addRooms(int[][] graph, int row, int col, Queue<int[]> queue, Set<String> visited) {
		if(row<0 || row>=graph.length || col<0 || col>=graph.length || graph[row][col] == -1 || visited.contains(row+""+col)) {
			return;
		}
		
		queue.add(new int[] {row, col});
		visited.add(row+""+col);
	}

}
