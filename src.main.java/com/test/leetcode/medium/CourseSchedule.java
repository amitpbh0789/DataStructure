package com.test.leetcode.medium;

import java.util.LinkedList;

/**
 * 
 * https://leetcode.com/problems/course-schedule/
 * 
 * @author amit
 *
 */
public class CourseSchedule {

	public static void main(String[] args) {

		CourseSchedule obj = new CourseSchedule();
		int numCourses = 4;
		int[][] prerequisites = {{0,1}, {1,2}, {2,3}};
		System.out.println(obj.canFinish(numCourses, prerequisites));
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		
//		Convert graph presentation from edges to indegree of adjacent list.
		int[] inDegree = new int[numCourses];
		
		int count = 0;
		
		for(int i=0; i<prerequisites.length; i++) {
			inDegree[prerequisites[i][0]]++; // Indegree - how many prerequisites are needed.
		}
		
		LinkedList<Integer> stack = new LinkedList<>();
		
//		Add all the vertics who doesnt have any prerequisites
		for(int i=0; i<inDegree.length; i++) {
			if(inDegree[i] == 0)
				stack.push(i);
		}
		
//		Coarse vertics who doesnt have prerequisites means coarse can be taken directly
		count = stack.size();
		
//		Now take out vertics from stack and get adjecent node.
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			
			for(int i=0; i<prerequisites.length; i++) {
				
//				Check if prerequisites adjecent node equals to popup up adjecent node.
				if(prerequisites[i][1] == curr) {
					
//					If yes, then reduce inDegree of that vertics by 1
					inDegree[prerequisites[i][0]]--;
					
//					check if vertics has become 0 then add into stack and count else ignore
					if(inDegree[prerequisites[i][0]] == 0) {
						count++;
						stack.push(prerequisites[i][0]);
					}
				}
			}
		}
		return count == numCourses;
	}
}
