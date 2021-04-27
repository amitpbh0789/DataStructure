package com.test.leetcode.easy;

import java.util.PriorityQueue;

public class LastStoneWeight {

	public static void main(String[] args) {
		
		LastStoneWeight obj = new LastStoneWeight();
		int[] stones = {2,7,4,1,8,1};
		System.out.println(obj.lastStoneWeight(stones));

	}

	public int lastStoneWeight(int[] stones) {
		
		PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> (b-a));
		
		for (int stone : stones) {
            queue.offer(stone);
        }
		
		for(int i=0; i<stones.length-1; i++) {
			queue.offer(queue.poll()-queue.poll());
		}
		
		return queue.poll();
	}

}
