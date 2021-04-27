package com.test.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueue_Test {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		pq.add(10);
		pq.add(20);
		pq.add(15);
		
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		
//		@Note: Sort custom object with inner class way
		
//		PriorityQueue<Person> priorityQueue = new PriorityQueue<>(new Comparator<Person>() {
//			@Override
//			public int compare(Person p1, Person p2) {
//				return p1.getName().compareTo(p2.getName());
//			}
//		});
		
//		@Note: Java 8 way
		
		PriorityQueue<Person> priorityQueue = new PriorityQueue<>((p,q)->p.getName().compareTo(q.getName()));
		
		priorityQueue.add(new Person("abc", 10));
		priorityQueue.add(new Person("xyz", 20));
		priorityQueue.add(new Person("hyc", 15));
		
		while(!priorityQueue.isEmpty()) {
			System.out.println(priorityQueue.poll());
		}
		
	}
}
