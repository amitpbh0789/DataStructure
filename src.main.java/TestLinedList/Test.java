package TestLinedList;

public class Test {

	public static void main(String[] args) {
		
		Node head = new Node(2);
		Node n1 = new Node(3);
		Node n12 = new Node(3);
		Node n13 = new Node(3);
		Node n2 = new Node(4);
		Node n3 = new Node(5);
		
		head.next = n1;
		n1.next = n12;
		n12.next = n13;
		n13.next = n2;
		n2.next = n3;
//		
//		while(head != null) {
//			System.out.println(head.val);
//			head = head.next;
//		}
		
		
//		
//		head = deleteNode(head, 2);
//		
//		while(head != null) {
//			System.out.println(head.val);
//			head = head.next;
//		}
		
		
//		head = removeDuplicates(head);
//		
//		while(head != null) {
//			System.out.println(head.val);
//			head = head.next;
//		}
		
//		head = reverseList(head);
//		
//		while(head != null) {
//			System.out.println(head.val);
//			head = head.next;
//		}
		
		head = insertionSortList(head);
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
		
	}
	
	/**
	 * https://leetcode.com/problems/remove-linked-list-elements/
	 * @param head
	 * @param key
	 * @return
	 */
	private static Node deleteNode(Node head, int key) {
		
		while(head != null && head.val == key) {
			head = head.next;
		}
		Node curr = head;
		Node pre = null;
		
		while(curr != null) {
			if(curr.val == key) {
				pre.next = curr.next;
			}else {
				pre = curr;
				curr = curr.next;
			}
		}
		
		if(pre == null) {
			return head;
		}
		return head;
	}
	
	/**
	 * 2,3,3,3,4,5
	 * @param head
	 */
	private static Node removeDuplicates(Node head) {
		
		Node curr = head;
		Node prev = null;
		
		while(curr != null && curr.next != null) {
			if(curr.val == curr.next.val) {
				Node next = curr.next;
				prev.next = curr.next;
				curr = next;
				
			}else {
				prev = curr;
				curr = curr.next;
			}
		}
		return head;
	}
	
	private static Node reverseList(Node head) {
		
		Node prev = null;
		while(head != null) {
			Node next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		
		return prev;
	}
	
	
	private static Node insertionSortList(Node head) {
		
		Node dummy = new Node(-1);
		Node prev = dummy;
		
		Node next = null;
		Node curr = head;
		
		while(curr != null) {
			next = curr.next;
			
			while(prev.next != null && prev.next.val<curr.val) {
				prev = prev.next;
			}
			curr.next = prev.next;
			prev.next = curr;
			curr = next;
			prev =  dummy; // so that we can iterate again 
		}
		return dummy.next;
		
	}
	
}
