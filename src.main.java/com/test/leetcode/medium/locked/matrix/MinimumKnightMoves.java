package com.test.leetcode.medium.locked.matrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-knight-moves/

BFS Solution
Start with start index and traverse in all 8 direction.
When target found, return the res else keep exploring. After exploring if target not found then return -1;

@Notes:
The key thing to note here is
x = Math.abs(x);
y = Math.abs(y);
Here we are forcing the original co-ordinates to be in 1st Quadrant only.
you cannot reach from 0,0 to 1,1 using only 1st quadrant. hence we allow x >=-1 y>=-1 instead of x>=0, y>=0 limit

Input: x = 2, y = 1      Output: 1      Explanation: [0, 0] → [2, 1]
Input: x = 5, y = 5		Output: 4		Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]

Time; O(M*N)   Space: O(M*N)

 */
public class MinimumKnightMoves {
	
	int[][] directions = new int[][]{{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
	
	public static void main(String[] args) {
		MinimumKnightMoves obj = new MinimumKnightMoves();
		System.out.println(obj.minKnightMoves(2, 1));
		System.out.println(obj.minKnightMoves(5, 5));
	}
	
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x); // check notes
        y = Math.abs(y);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        Set<String> visited = new HashSet<>();
        visited.add("0"+ "," + "0");
        int ans = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] curr = queue.poll();
                int currX = curr[0];
                int currY = curr[1];
                if(currX == x && currY == y){
                    return ans;
                }

                // traverse to each directions
                for(int[] dir : directions){
                    int newX = currX + dir[0];
                    int newY = currY + dir[1];
                    // check notes why considering till -1
                    if(!visited.contains(newX+","+newY) && newX >= -1 && newY >= -1){
                        queue.add(new int[]{newX, newY});
                        visited.add(newX+ ","+ newY);
                    }
                }
            }
            ans++;
        }
        return -1; // if not found
    }
}
