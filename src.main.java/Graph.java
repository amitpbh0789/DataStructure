import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *Graph used: https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 *
 */
public class Graph {

	int v;
	LinkedList<Integer>[] adj;
	
	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1); 
		g.addEdge(0, 2); 
		g.addEdge(1, 2); 
		g.addEdge(2, 0); 
		g.addEdge(2, 3); 
		g.addEdge(3, 3); 
		boolean[] visited1 = new boolean[5];
		
		System.out.println("BFS");
		g.printBFS(2, visited1);
		boolean[] visited2 = new boolean[5];
		System.out.println("\nDFS");
		g.printDFS(2, visited2);
		
		System.out.println("\nPossible paths are");
		System.out.println(g.countPath(2, 1));
	}
	
	public void addEdge(int src, int val) {
		adj[src].add(val);
	}
	
	
	public void printDFS(int start, boolean[] visited) {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(start);
		
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			
			if(!visited[curr]) {
				visited[curr] = true;
				System.out.print(curr+" ");
			}
			
			Iterator<Integer> itr = adj[curr].iterator();
			while(itr.hasNext()) {
				int child = itr.next();
				if(!visited[child]) {
					stack.push(child);
				}
			}
		}
	}
	
	public void printBFS(int start, boolean[] visited) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			System.out.print(curr+" ");
			Iterator<Integer> itr = adj[curr].iterator();
			while(itr.hasNext()) {
				int child = itr.next();
				if(!visited[child]) {
					visited[child] = true;
					queue.add(child);
				}
			}
			
		}
		
	}
	
	public int countPath(int start, int end) {
		
		boolean[] visited = new boolean[v];
		int count = 0;
		return countPossiblePath(start, end, visited, count);
	}
	
	public int countPossiblePath(int start, int end, boolean[] visited, int count) {
		visited[start] = true;
		if(start == end)
			count++;
		else {
			
			Iterator<Integer> itr = adj[start].iterator();
			while(itr.hasNext()) {
				int child = itr.next();
				if(!visited[child]) {
					count = countPossiblePath(child, end, visited, count);
				}
			}
		}
		
		visited[start] = false; // making dest false again so that next possible could reach dest
//		else it will never reach
		return count;
	}
	
}
