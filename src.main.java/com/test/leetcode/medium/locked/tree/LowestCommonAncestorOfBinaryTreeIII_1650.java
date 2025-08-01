package com.test.leetcode.medium.locked.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/description/
 * 
 * Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA). Each node will have a reference to its parent node. 
 * 
 * The definition for Node is below:

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a tree T is the lowest node 
that has both p and q as descendants (where we allow a node to be a descendant of itself)."

Idea: Since each node has access to its parent, we will created set for visited nodes.
From given P node, keep move upwards 
Now take second node and keep moving upward until you meet visited node. If visited node met, thats the answer return it else keep moving up

 */
public class LowestCommonAncestorOfBinaryTreeIII_1650 {

	public static void main(String[] args) {
		
		
	}
	
	public Node lowestCommonAncestor(Node p, Node q) {
		
		Set<Node> visited = new HashSet<>();
		while(p != null) {
			visited.add(p);
			p = p.parent;
		}
		
		while(q != null) {
			if(visited.contains(q)) {
				return q;
			}
			q = q.parent;
		}
		
		return null;
	}
	
	class Node{
		int val;
		Node left;
		Node right;
		Node parent;
	}
}
