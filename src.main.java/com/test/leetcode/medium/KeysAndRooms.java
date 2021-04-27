package com.test.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/keys-and-rooms/
 * BFS
 * 
 *  Keep track of visited rooms.
 *  Once visited, add into Stack.
 *  Pop out Stack until it goes empty and see if size of the visited set is same as no of rooms we have
 * @author amit
 *
 */
public class KeysAndRooms {

	public static void main(String[] args) {

		KeysAndRooms obj = new KeysAndRooms();
		List<List<Integer>> rooms = new ArrayList<List<Integer>>();
		List<Integer> keys1 = new ArrayList<>();
		keys1.add(1);
		rooms.add(keys1);
		List<Integer> keys2 = new ArrayList<>();
		keys2.add(2);
		rooms.add(keys2);
		List<Integer> keys3 = new ArrayList<>();
		keys3.add(3);
		rooms.add(keys3);
		System.out.println(obj.canVisitAllRooms(rooms));
	}

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {

//		Add 0 room into visited as precondition
		Set<Integer> visited = new HashSet<>();
		visited.add(0);
		
//		Push 0 room into stack
		Stack<Integer> roomStack = new Stack<>();
		roomStack.add(0);
		
//		Loop through i=until stack gets empty
		while(!roomStack.isEmpty()) {
			
//			Get the keys in the room poped out from the stack
			List<Integer> keys = rooms.get(roomStack.pop());
			for(int key : keys) {
				if(!visited.contains(key)) {
					visited.add(key);
					roomStack.add(key);
				}
			}
			
		}
//		If visited rooms isze is same as rooms we have then it will return true else false
		return visited.size() == rooms.size();
		
	}

}
