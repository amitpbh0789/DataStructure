package com.test.leetcode.medium;

import java.util.Stack;

/**
 * 
 * https://leetcode.com/problems/course-schedule-ii/
 * Time O(V+E) --> Vertex and Edges
 * Space O(V+E)
 * @author amit
 *
 */
public class CourseScheduleII {

	public static void main(String[] args) {

		CourseScheduleII obj = new CourseScheduleII();
		int numCourses = 2;
		int[][] prerequisites = {{1,0}};
		int[] res = obj.findOrder(numCourses, prerequisites);
		for(Integer i : res)
			System.out.println(i);
		
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		if (numCourses == 0) 
			return null;
		
		//      Create Indegree array to stoe degree of each coarse
		int[] inDegree = new int[numCourses];

		//       Now iterate and populate inDegree array based on if prerequisites required for vertics or not
		for(int i=0; i<prerequisites.length; i++){
			inDegree[prerequisites[i][0]]++; // Indegree - how many prerequisites are needed for a peticular vertics
		}

		Stack<Integer> stack = new Stack<>();

		int[] list = new int[numCourses];
		int index = 0;

//		Push all the vertics who doesnt have any prerequisites and add into result array
		for(int i=0; i<numCourses; i++){
			if(inDegree[i] == 0){
				stack.push(i);
				list[index++] = i;
			}

		}

//		Now take out vertics from stack and get adjecent node.
		while(!stack.isEmpty()){

			int curr = stack.pop();
			for(int i=0; i<prerequisites.length; i++){

//			Check if prerequisites adjecent node equals to popup up adjecent node.
				if(curr == prerequisites[i][1]){
//					If yes, then reduce inDegree of that vertics by 1
					inDegree[prerequisites[i][0]]--;
					
//					check if vertics has become 0 then add into stack and also add into result list
					if(inDegree[prerequisites[i][0]]==0){
						list[index++] = prerequisites[i][0];
						stack.push(prerequisites[i][0]);
					}
				}
			}
		}
//		Check if index is same as numCourses return list else return empty array
		return index == numCourses? list:new int[0];
	}
}
