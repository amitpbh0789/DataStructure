package com.test.leetcode.hard;

import java.util.PriorityQueue;

public class MergeKSortedLists {

	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(3);
		
		ListNode[] lists = new ListNode[]{l1, l2, l3};
		
		MergeKSortedLists obj = new MergeKSortedLists();
		ListNode ans = obj.mergeKLists(lists);
		while(ans!=null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		
//		base condition
		if(lists == null || lists.length == 0)
			return null;
		
//		Add into priority queue;
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b)->a.val-b.val);
		for(ListNode ln : lists)
			pq.add(ln);
		
//		Now take out one by one and keep on adding into list
		ListNode dummy = new ListNode();
		ListNode head = dummy;
		while(!pq.isEmpty()) {
			dummy.next = pq.poll(); // add one element into dummy node
			dummy = dummy.next; // move the pointer of dummy node 
			if(dummy.next != null){ // now if dummy node still has data then add back to pq so that pq can sort it
				pq.add(dummy.next);
			}
		}
		
		return head.next;
	}

}

class ListNode{
	int val;
	ListNode next;
	
	public ListNode() {
		
	}
	
	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}
