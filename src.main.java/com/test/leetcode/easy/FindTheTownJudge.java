package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/find-the-town-judge/
 * 
 *  Intuition:
		Consider trust as a graph, all pairs are directed edge.
		The point with in-degree - out-degree = N - 1 become the judge.

	Explanation:
		Count the degree, and check at the end.

	Time Complexity:
		Time O(T + N), space O(N)

 * @author amit
 *
 */
public class FindTheTownJudge {

	public static void main(String[] args) {

		int N = 3;
		int[][] trust = {{1,3},{2,3},{3,1}};
		System.out.println(findTownJudge(N, trust));
	}
	private static int findTownJudge(int N, int[][] trust) {
		int[] count = new int[N+1]; //coz we dont want to consider 0th index

		for(int i=0; i<trust.length; i++){
			count[trust[i][0]]--;
			count[trust[i][1]]++;
		}

		for(int i=0; i<count.length; i++){
			if(count[i]==N-1)
				return i;
		}
		return -1;
	}

}
