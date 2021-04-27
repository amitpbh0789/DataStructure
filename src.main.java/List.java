
public class List {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		List obj = new List();
		ListNode ans = obj.add(l1, l2);
		System.out.println("");
		
	}
	
	public ListNode add(ListNode l1, ListNode l2) {
		
		ListNode dummy = new ListNode();
		ListNode head = dummy;
		int carry = 0;
		while(l1 != null || l2 != null || carry == 1) {
			int a = l1!=null ? l1.data:0;
			int b = l2 != null?l2.data:0;
			
			ListNode curr = new ListNode();
			curr.data = (a+b+carry) % 10;
			carry = (a+b+carry) / 10;
			
			dummy.next = curr;
			dummy = curr;
			
			l1 = l1!=null?l1.next:l1;
			l2 = l2!=null?l2.next:l2;
		}
		
		return head.next;
	}
}

class ListNode{
	int data;
	ListNode next;
	
	public ListNode(int data) {
		this.data = data;
		this.next = null;
	}
	
	public ListNode() {
		
	}
}
