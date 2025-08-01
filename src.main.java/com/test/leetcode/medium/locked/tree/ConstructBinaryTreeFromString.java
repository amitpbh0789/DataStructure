package com.test.leetcode.medium.locked.tree;

/**
 * 
 * Sort of Sliding window approach.
 * Node to find root val and then recursively we can call for left and rigth subtree.
 * If current root.left is null then always populate left first and populate right only when left is already populated,
 */
public class ConstructBinaryTreeFromString {

	public static void main(String[] args) {
		ConstructBinaryTreeFromString obj = new ConstructBinaryTreeFromString();
		String str = "4(2(3)(1))(6(5))";
		obj.stringToTree(str);
	}

	private TreeNode stringToTree(String str) {
		if(str == null || str.length() == 0) {
			return null;
		}

		// Find the root node value
		int idx = str.indexOf('(');
		// If String doesn't contain open bracket
		if(idx == -1) {
			return new TreeNode(Integer.parseInt(str));
		}

		// Find the value for root node
		int val = Integer.parseInt(str.charAt(0) == '-' ? str.substring(1, idx) :  str.substring(0, idx));
		TreeNode root = new TreeNode(val);
		
		// Now process for left and right nodes.
		int start = idx;
		int open = 0;
		for(int i=idx; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				open++;
			} else if(str.charAt(i) == ')'){
				open--;
			}

			// when you see open as 0 means need to add into root
			if(open == 0) {
				if(root.left == null) {
					root.left = stringToTree(str.substring(start+1, i));
				} else {
					root.right = stringToTree(str.substring(start+1, i));
				}
				start = i+1; // increasing pointer to process next bracket set
			}
		}
		
		return root;

	}

}
