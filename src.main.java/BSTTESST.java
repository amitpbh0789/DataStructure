import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BSTTESST {

	Node22 root;

	public BSTTESST() {
		this.root = null;
	}

	public static void main(String[] args) {
		BSTTESST obj = new BSTTESST();
		obj.add(15);
		obj.add(12);
		obj.add(135);
		obj.add(132);

		BSTTESST obj1 = new BSTTESST();
		obj1.add(16);
		obj1.add(1);
		obj1.add(20);

		System.out.println("Merged bst's ");
		obj.mergeBST(obj.root, obj1.root);

		System.out.println("is BST valid --> "+obj.isValid(obj.root));
		System.out.println("Max Height of the tree -> "+ obj.maxHeight(obj.root));
		System.out.println("Min Height of the tree -> "+ obj.minHeight(obj.root));

		obj.levelOrderTraversal(obj.root);

		int[] arr = new int[] {12, 15, 135};
		obj.constructBST(arr);
	}

	public void mergeBST(Node22 root1, Node22 root2) {

		Node22 root = merge(root1, root2);
		System.out.println("tree merged");
	}

	public Node22 merge(Node22 root1, Node22 root2) {
		if(root1 == null && root2 == null)
			return null;
		if(root1 == null)
			return root2;
		if(root2 == null)
			return root1;
		
		Node22 root = new Node22((root1!=null?root1.data:0) + (root2!=null?root2.data:0));
		
		root.left = merge(root1.left, root2.left);
		root.right = merge(root1.right, root2.right);
		
		return root;
	}


	public void constructBST(int[] arr) {
		BSTTESST bst = new BSTTESST();
		int end = arr.length-1;
		Node22 root = bst.construct(arr, 0, end);

		System.out.println("BST created from sorted array");
	}

	public Node22 construct(int[] arr, int start, int end) {

		if(start>end)
			return null;

		int mid = start + (end-start)/2;
		Node22 root = new Node22(arr[mid]);

		root.left = construct(arr, 0, mid-1);
		root.right = construct(arr, mid+1, end);

		return root;

	}

	public void add(int num) {
		root = insertNode(root, num);
	}

	public Node22 insertNode(Node22 root, int num) {
		if(root == null)
			return new Node22(num);

		if(num<root.data) {
			root.left = insertNode(root.left, num);
		}
		if(num>root.data) {
			root.right = insertNode(root.right, num);
		}
		return root;
	}

	public void levelOrderTraversal(Node22 root) {
		System.out.println("Print level order traversal -> ");
		List<List<Integer>> ans = new ArrayList<>();
		Deque<Node22> deque = new LinkedList<>();
		deque.addLast(root);

		while(!deque.isEmpty()) {
			int size = deque.size();
			List<Integer> level = new ArrayList<>();
			for(int i=0; i<size; i++) {
				Node22 curr = deque.removeFirst();
				level.add(curr.data);
				if(curr.left != null)
					deque.addLast(curr.left);

				if(curr.right!=null) {
					deque.addLast(curr.right);
				}
			}
			ans.add(level);
		}

		//		For reverse order execute Collections.sort(ans);
		ans.stream().forEach(a -> {
			System.out.print(a);
		});
	}

	public boolean isValid(Node22 root) {
		if(root == null)
			return  false;

		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isValidBST(Node22 root, int min, int max) {

		//		base condition
		if(root == null)
			return true;

		if(root.data<min || root.data>max)
			return false;
		return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
	}


	public int maxHeight(Node22 root) {
		if(root == null)
			return 0;

		int left = maxHeight(root.left);
		int right = maxHeight(root.right);

		return Math.max(left, right)+1;
	}

	public int minHeight(Node22 root) {
		if(root == null)
			return 0;
		int left = minHeight(root.left);
		int right = minHeight(root.right);

		if(left == 0 || right == 0)
			return left + right +1;

		return Math.min(left, right)+1;
	}
}

class Node22{
	int data;
	Node22 left;
	Node22 right;

	public Node22(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
