package com.test.leetcode.medium;

import java.util.Iterator;
import java.util.LinkedList;

public class CountNumberOfTrees {

	private int V;

	private LinkedList<Integer> adj[];  

	public CountNumberOfTrees(int v)  
	{  
		V = v;  
		adj = new LinkedList[v];  
		for (int i = 0; i <  v; ++i)  
			adj[i] = new LinkedList();  
	}  

	private void addEdge(int v, int w) {  
		adj[v].add(w);
	}  

	private int countTrees() {

		boolean[] visited = new boolean[V];
		int count = 0;

		for(int i=0; i<V; i++) {
			if(!visited[i]) {
				DFSUtil(i, visited);
				count++;
			}
		}

		return count;
	}

	private void DFSUtil(int res, boolean[] visited) {
		visited[res] = true;
		Iterator<Integer> itr = adj[res].listIterator();
		while(itr.hasNext()) {

			int n = itr.next();

			if(!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}


	// Driver code 
	public static void main(String args[]) {  
		CountNumberOfTrees g = new CountNumberOfTrees(5);  

		g.addEdge(0, 1);  
		g.addEdge(0, 2);  
		g.addEdge(3, 4);  

		System.out.println(g.countTrees());  
	}  
}