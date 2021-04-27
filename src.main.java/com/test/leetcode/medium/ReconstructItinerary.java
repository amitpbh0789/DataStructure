package com.test.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class ReconstructItinerary {

	public static void main(String[] args) {

		String[][] arr = new String[][] {{"SFO", "LAX"}, {"LAX", "DEN"}, {"DEN", "ATL"}, {"DEN", "ORD"}, {"ORD", "BAL"}};
		ReconstructItinerary obj = new ReconstructItinerary();
		List<String> ans = obj.findItinerary(arr);
		System.out.println(ans);
	}

	public List<String> findItinerary(String[][] tickets) {
		Map<String, PriorityQueue<String>> dests = new HashMap<>();

		for(String[] t: tickets) {
			dests.putIfAbsent(t[0], new PriorityQueue<>());
			dests.get(t[0]).add(t[1]);
		}
		List<String> res = new LinkedList<>();
		Stack<String> stack = new Stack<>();
		stack.push("SFO");
		while(!stack.empty()) {
			while(dests.containsKey(stack.peek()) && !dests.get(stack.peek()).isEmpty())
				stack.push(dests.get(stack.peek()).poll());
			res.add(0, stack.pop());
		}
		return res;
	}
}
