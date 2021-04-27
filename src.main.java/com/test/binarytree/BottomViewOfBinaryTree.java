package com.test.binarytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/**
 * https://www.geeksforgeeks.org/bottom-view-binary-tree/
 * 
 * A node x is there in output if x is the bottommost node at its horizontal distance. 
 * Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1,
 *  and that of right child is horizontal distance of x plus 1.
 *  
 *  Idea:
 *  Level order traversal putting hd and node value
 *  at last, take out all the elements form map, and print their values fro ans.
 *
 */
public class BottomViewOfBinaryTree {

	public static void main(String[] args) {
		
		BTNode root = new BTNode(20); 
        root.left = new BTNode(8); 
        root.right = new BTNode(22); 
        root.left.left = new BTNode(5); 
        root.left.right = new BTNode(3); 
        root.right.left = new BTNode(4); 
        root.right.right = new BTNode(25); 
        root.left.right.left = new BTNode(10); 
        root.left.right.right = new BTNode(14); 
        BottomViewOfBinaryTree tree = new BottomViewOfBinaryTree(); 
        System.out.println("Bottom view of the given binary tree:"); 
        tree.bottomView(root); 
		
	}
	
	public void bottomView(BTNode root) { 
        if (root == null) 
            return; 
  
        // Initialize a variable 'hd' with 0 for the root element. 
        int hd = 0; 
  
        // TreeMap which stores key value pair sorted on key value 
        Map<Integer, Integer> map = new TreeMap<>(); 
  
         // Queue to store tree nodes in level order traversal 
        Queue<BTNode> queue = new LinkedList<BTNode>(); 
  
        // Assign initialized horizontal distance value to root 
        // node and add it to the queue. 
        root.hd = hd; 
        queue.add(root); 
  
        // Loop until the queue is empty (standard level order loop) 
        while (!queue.isEmpty()) 
        { 
        	BTNode temp = queue.remove(); 
  
            // Extract the horizontal distance value from the 
            // dequeued tree node. 
            hd = temp.hd; 
  
            map.put(hd, temp.data); 
  
            if (temp.left != null) { 
                temp.left.hd = hd-1; 
                queue.add(temp.left); 
            } 
            // If the dequeued node has a right child add it to the 
            // queue with a horizontal distance hd+1. 
            if (temp.right != null) { 
                temp.right.hd = hd+1; 
                queue.add(temp.right); 
            } 
        } 
  
        // Extract the entries of map into a set to traverse 
        // an iterator over that. 
        Set<Entry<Integer, Integer>> set = map.entrySet(); 
  
        // Make an iterator 
        Iterator<Entry<Integer, Integer>> iterator = set.iterator(); 
  
        // Traverse the map elements using the iterator. 
        while (iterator.hasNext()) { 
            Map.Entry<Integer, Integer> me = iterator.next(); 
            System.out.print(me.getValue()+" "); 
        } 
    } 
}

class BTNode { 
    int data; //data of the node 
    int hd; //horizontal distance of the node 
    BTNode left, right; //left and right references 
  
    // Constructor of tree node 
    public BTNode(int key) 
    { 
        data = key; 
        hd = Integer.MAX_VALUE; 
        left = right = null; 
    } 
}
