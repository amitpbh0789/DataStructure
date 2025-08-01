package com.test.leetcode.medium.locked.tree;

/**
 * https://leetcode.com/problems/closest-binary-search-tree-value/description/
 * 
 * Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target. 
 * If there are multiple answers, print the smallest.
 * 
 * Input: root = [4,2,5,1,3], target = 3.714286	Output: 4
 * 
 */
public class ClosestBinarySearchTreeValue {

	int minVaL = Integer.MAX_VALUE;

	public int closestValue(TreeNode root, double target) {

		if(root.left == null && root.right == null) {
			return root.val;
		}
		
		
		int ans = root.val; // by default considering first one 
		int curr;
		
		while(root != null) {
			curr = root.val;
			
			// if prev idff is less than current diff or if they are equal but curr node's val is less than prev ans node
			ans = Math.abs(curr - target) < Math.abs(ans - target) 
					|| ((Math.abs(curr - target) == Math.abs(ans - target)) && (curr < ans)) ? curr : ans;
			
			// traverse now based on value 
			root = ans < root.val ? root.left : root.right;
		}
		
		return ans;
	}

}





class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}