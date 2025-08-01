package com.test.leetcode.medium.locked.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 
 * BFS
 * Time: O(NLogN), N is for all the node travseral and logN is for putting into Map since its sorted and uses Red black tree
 * Space: O(N)
 */

public class BinaryTreeVerticalOrderTraversal {
	
	public static void main(String[] args) {
		
	}
	
	public List<List<Integer>> verticalOrder(TreeNode root) {
		
        // write your code here
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Pair<TreeNode, Integer> pair = new Pair<>(root, 0);
        queue.add(pair);

        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
 
 
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){
                Pair<TreeNode, Integer> curr = queue.poll();
                TreeNode currNode = curr.left;
                int offset = curr.right;
                if(!treeMap.containsKey(offset)){
                    treeMap.put(offset, new ArrayList<>());
                }
                treeMap.get(offset).add(currentNode.val);

                if(currNode.left != null){
                    queue.add(new Pair<>(root.left, offset-1));
                }
                if(root.right != null){
                    queue.add(new Pair<>(root.right, offset+1));
                }
            }
        }

        return new ArrayList<>(treeMap.values);
    }
}

class TreeNode{
	public int val;
	public TreeNode left, right;
	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}
