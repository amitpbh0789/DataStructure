package com.test.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class BinarySearchTree {

	Node root;
	static int sum = 0;

	BinarySearchTree() {  
		root = null;  
	} 

	public static void main(String[] args) {

		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50); 
		tree.insert(30); 
		tree.insert(20); 
		tree.insert(40); 
		tree.insert(70); 
		tree.insert(60); 
		tree.insert(80); 
		System.out.println("BST created");

		System.out.println("Check if tree is BST");
		System.out.println(tree.isBST(tree.root));

		System.out.println("Find Kth smallest element from the tree");
		System.out.println(tree.findKthElement(tree.root, 2));

		System.out.println("Find Kth largest element from the tree");
		System.out.println(tree.findKthLargestElement(tree.root, 3));

		System.out.println("Check if each internal node of a BST has exactly one child");
		System.out.println(tree.hasOnlyOneChild(tree.root));

		int[] arr = {19, 23, 25, 30, 45};

		System.out.println("Check if an array represents Inorder of Binary Search tree or not");
		System.out.println(tree.isInorder(arr, 5));


		System.out.println("Largest number in BST which is less than or equal to N");
		System.out.println(tree.findMaxForN(tree.root, 55));

		System.out.println("PreOrder traversal of the given tree"); 
		tree.preOrderTraversal(tree.root); 

		System.out.println("\nPostOrder traversal of the given tree"); 
		tree.postOrderTraversal(tree.root); 

		System.out.println("\nInorder traversal of the given tree"); 
		tree.inOrderTraversal(tree.root);

		System.out.println("\nFind Lowest Common Ancestor in a Binary Search Tree");
		tree.findLowestCommonAncestor(tree.root);

		System.out.println("\nDelete 20"); 
		tree.deleteKey(tree.root,20); 
		System.out.println("Inorder traversal of the modified tree"); 
		tree.inOrderTraversal(tree.root); 

		System.out.println("\nDelete 30"); 
		tree.deleteKey(tree.root,30); 
		System.out.println("Inorder traversal of the modified tree"); 
		tree.inOrderTraversal(tree.root); 

		System.out.println("\nDelete 50"); 
		tree.deleteKey(tree.root,50); 
		System.out.println("Inorder traversal of the modified tree"); 
		tree.inOrderTraversal(tree.root); 

		System.out.println("\nRemove all leaf nodes from the binary search tree");
		tree.removeAllLeafNodes(tree.root);
		System.out.println("Inorder traversal after removing all the leaf nodes"); 
		tree.inOrderTraversal(tree.root); 

		System.out.println("\nFind Node with Min value");
		System.out.println(tree.findMinNode(tree.root));
		
		
//		LeetCode problem: https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
		
		BinarySearchTree tree1 = new BinarySearchTree();
		tree1.insert(50); 
		tree1.insert(30); 
		tree1.insert(20); 
		tree1.insert(40); 
		BinarySearchTree tree2 = new BinarySearchTree();
		tree2.insert(5); 
		tree2.insert(300); 
		tree2.insert(280); 
		tree2.insert(487); 
		System.out.println("Two tree into merged into sorted array");
		List<Integer> mergedList = getAllElements(tree1.root, tree2.root);
		
		mergedList.stream().forEach(i -> System.out.println(i));
		
		
		BinarySearchTree tree3 = new BinarySearchTree();
		tree3.insert(50); 
		tree3.insert(30); 
		tree3.insert(20); 
		tree3.insert(40); 
		tree3.insert(70); 
		tree3.insert(60); 
		tree3.insert(80); 
		
		System.out.println("Get all the elements in bst between the range");
		List<Integer> list = new ArrayList<>();
		getRangeNums(tree3.root, 20, 60, list);
		System.out.println(list);
		
		System.out.println("Get sum of all the nodes between the range");
		getRangeSum(tree3.root, 20, 60);
		System.out.println(sum);
		
		
		System.out.println("get all the elements low and greater than given range");
		List<Integer> notInRangeList = new ArrayList<>();
		elementsNotInRange(tree3.root, 30, 60, notInRangeList);
		System.out.println(notInRangeList);
		
	}

	private void insert(int key) {

		root = insertRec(root, key);

	}

	private Node insertRec(Node root, int key) {

		if(root == null) {
			root = new Node(key);
			return root;
		}

		if(key<root.data) {
			root.left = insertRec(root.left, key);
		} else if (key>root.data) {
			root.right = insertRec(root.right, key);
		}

		return root;
	}

	private void inOrderTraversal(Node root) {

		if (root != null) { 
			inOrderTraversal(root.left); 
			System.out.print(root.data + " "); 
			inOrderTraversal(root.right); 
		} 

	}

	private void preOrderTraversal(Node root) {

		if (root != null) { 
			System.out.print(root.data + " "); 
			preOrderTraversal(root.left); 
			preOrderTraversal(root.right); 
		} 

	}

	private void postOrderTraversal(Node root) {

		if(root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.data + " "); 
		}
	}

	/**
	 * https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
	 * 
	 * @param root
	 * @param key
	 */
	private void deleteKey(Node root, int key) {
		deleteKeyRec(root, key);
	}
	private Node deleteKeyRec(Node root, int key) {

		if (root == null)  return root;

		if(key<root.data) {
			root.left = deleteKeyRec(root.left, key);
		} else if(key>root.data) {
			root.right = deleteKeyRec(root.right, key);
		} else {
			if(root.left == null) {
				return root.right;
			} else if(root.right == null) {
				return root.left;
			}

			//          Get min node in right side of the tree			
			Node minNode = getMin(root.right);
			//          Copy min node value to original node(which is deleted) value
			root.data = minNode.data;
			//          Now pass the right tree of the node which is replaced with new value, and delete the copied value
			root.right = deleteKeyRec(root.right, root.data);
		}
		return root;
	}

	private Node getMin(Node root) {

		while(root.left !=null) {
			root = root.left;

		}
		return root;
	}

	/**
	 * https://www.geeksforgeeks.org/find-the-minimum-element-in-a-binary-search-tree/
	 * 
	 * @param root
	 * @return
	 */
	private int findMinNode(Node root) {

		if(root.left == null) {
			return 0;
		}
		while(root.left != null) {
			root = root.left;
		}
		return root.data;

	}


	/**
	 * https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
	 * @Desc: Recursive solution
	 * @param root
	 * @return
	 */
	private Node findLowestCommonAncestor(Node root) {

		if(root == null)
			return null;
		int n1 = 20;
		int n2 = 60;
		Node lcaNodeIterative = findLCAByIterativeSolution(root, n1, n2);
		Node lcaNodeRecursive = findLCAByRecursive(root, n1, n2);
		System.out.println("LCA By Iterative Solution "+lcaNodeIterative.data);
		System.out.println("LCA By Recursive Solution "+lcaNodeRecursive.data);
		return lcaNodeRecursive;
	}

	/**
	 * 
	 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
	 * 
	 * @Desc: Recursive solution
	 * 
	 * @param root
	 * @param n1
	 * @param n2
	 * @return
	 */
	private Node findLCAByRecursive(Node root, int n1, int n2) {

		if (root == null) 
			return null; 

		if(root.data>n1 && root.data>n2) {
			return findLCAByRecursive(root.left, n1, n2);
		}
		if(root.data<n1 && root.data<n2) {
			return findLCAByRecursive(root.right, n1, n2);
		}

		return root;
	}

	/**
	 * 
	 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
	 * 
	 * @Desc: Iterative solution
	 * 
	 * @param root
	 * @param n1
	 * @param n2
	 * @return
	 */
	private Node findLCAByIterativeSolution(Node root, int n1, int n2) {

		if(root == null)
			return null;
		while(root != null) {
			if(root.data>n1 && root.data>n2) {
				root = root.left;
			}else if(root.data<n1 && root.data<n2) {
				root = root.right;
			} else {
				break;
			}
		}
		return root;
	}

	/**
	 * https://leetcode.com/problems/validate-binary-search-tree/
	 * 
	 * https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
	 * 
	 * @Desc: program to check if a binary tree is BST or not
	 * @param root
	 * @return
	 */
	private boolean isBST(Node root) {

		if(root == null) {
			return false;
		}

		if(root.data < Integer.MIN_VALUE || root.data > Integer.MAX_VALUE) {
			return false;
		}
		if((root.left != null && root.data>root.left.data) && (root.right != null && root.data<root.right.data)) {
			return true;
		}
		return (isBST(root.left) && isBST(root.right));
	}

	/**
	 * URL: https://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
	 * @Desc: Find k'th smallest element in BST
	 * @param root
	 * @param k
	 * @return
	 */
	private int findKthElement(Node root, int k) {
		List<Integer> list = new Vector<>();
		return getInorderArray(root, list).get(k-1);
	}

	private List<Integer> getInorderArray(Node root, List<Integer> list) {
		if(root != null) {
			getInorderArray(root.left, list);
			list.add(root.data);
			getInorderArray(root.right, list);
		}
		return list;
	}

	/**
	 * https://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	private int findKthLargestElement(Node root, int k) {

		List<Integer> list = new Vector<>();

		getInorderArray(root, list);
		int length = list.size();
		return list.get(length-k);

	}

	/**
	 * https://www.geeksforgeeks.org/check-if-each-internal-node-of-a-bst-has-exactly-one-child/
	 * 
	 * @param root
	 * @return
	 */
	private boolean hasOnlyOneChild(Node root) {

		while(root != null) {
			if(root.left != null && root.right != null) {
				return false;
			}
			if(root.left == null && root.right == null) {
				break;
			}
			if(root.left != null)
				root = root.left;
			else if(root.right != null)
				root = root.right;
		}

		return true;
	}


	/**
	 * https://www.geeksforgeeks.org/check-array-represents-inorder-binary-search-tree-not/
	 * 
	 * @param arr
	 * @param length
	 * @return
	 */
	private boolean isInorder(int[] arr, int length) {

		if(length ==0 || length == 1)
			return true;

		for(int i=1; i<arr.length; i++) {
			if(arr[i-1]>arr[i])
				return false;
		}
		return true;
	}

	/**
	 * https://www.geeksforgeeks.org/largest-number-bst-less-equal-n/
	 * @Desc: Largest number in BST which is less than or equal to N
	 * @param root
	 * @param n
	 * @return
	 */
	private int findMaxForN(Node root, int n) {

		if(root == null)
			return -1;
		if(root.data == n)
			return n;
		else if(root.data<n) {
			int k = findMaxForN(root.right, n);
			if(k == -1)
				return root.data;
			else
				return n;
		}
		else if (root.data > n)  
			return findMaxForN(root.left, n); 
		return -1;
	}

	/**
	 * https://www.geeksforgeeks.org/remove-leaf-nodes-binary-search-tree/
	 * Desc: Remove all leaf nodes from the binary search tree
	 * @param root
	 * @return
	 */
	private Node removeAllLeafNodes(Node root) {

		//		Boundary condition
		if(root == null)
			return null;

		//		Base case
		if(root.left == null && root.right == null)
			return null;

		root.left = removeAllLeafNodes(root.left);
		root.right = removeAllLeafNodes(root.right);

		return root;
	}

	public static List<Integer> getAllElements(Node root1, Node root2) {

		ArrayList<Integer> list1 = inOrder(root1, new ArrayList<Integer>());
		ArrayList<Integer> list2 = inOrder(root2, new ArrayList<Integer>());

		if(root1 == null)
			return list2;
		if(root2 == null)
			return list1;

		int i = 0;
		int j = 0;
		List<Integer> mergedList = new ArrayList<>();

		while(i<list1.size() && j<list2.size()){
			if(list1.get(i)<=list2.get(j)){
				mergedList.add(list1.get(i++));
			}else{
				mergedList.add(list2.get(j++));
			}
		}

		while(i<list1.size())
			mergedList.add(list1.get(i++));
		while(j<list2.size())
			mergedList.add(list2.get(j++));

		return mergedList;
	}

	public static ArrayList<Integer> inOrder(Node root, ArrayList<Integer> list){
		if(root!=null){
			inOrder(root.left, list);
			list.add(root.data);
			inOrder(root.right, list);
		}
		return list;
	}
	
	public static void getRangeNums(Node root, int low, int high, List<Integer> list){

		if(root==null)
			return;

		if(low<root.data) // expand left side
			getRangeNums(root.left, low, high, list);

		if(low<=root.data && root.data<=high) // print the element
			list.add(root.data);

		if(root.data<high) // expand right side
			getRangeNums(root.right, low, high, list);
	}

	public static void getRangeSum(Node root, int low, int high){

		if(root==null)
			return;

		if(low<root.data) // expand left side
			getRangeSum(root.left, low, high);

		if(low<=root.data && root.data<=high) // print the element
			sum = sum + root.data;

		if(root.data<high) // expand right side
			getRangeSum(root.right, low, high);
	}
	
	public static void elementsNotInRange(Node root, int low, int high, List<Integer> list) {
		if(root == null)
			return;
		
		elementsNotInRange(root.left, low, high, list);
		
		if(root.data<low || root.data>high)
			list.add(root.data);
		
		elementsNotInRange(root.right, low, high, list);
	}
}
