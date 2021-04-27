package com.test.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {

	Queue<Integer> queue;
	public NumberOfRecentCalls() {
		queue = new LinkedList<Integer>();
	}

	public static void main(String[] args) {
		NumberOfRecentCalls calls = new NumberOfRecentCalls();
		System.out.println(calls.ping(1));
		System.out.println(calls.ping(100));
		System.out.println(calls.ping(3001));
		System.out.println(calls.ping(3002));
	}

	private int ping(int t) {

		queue.add(t);

		while(queue.peek()<t-3000){
			queue.poll();
		}

		return queue.size();
	}
}
