package com.test.linkedlist;

import java.util.Stack;

/**
 * Check if LinkedList contains a palindrome
 * @author amit
 *
 */
public class LinkedListPalindromCheck {
	
	public static void main(String[] args) {
		Node head = new Node();
		Node one = new Node(1); 
	    Node two = new Node(2); 
	    Node three = new Node(3); 
	    Node four = new Node(6); 
	    Node five = new Node(3); 
	    Node six = new Node(2); 
	    Node seven = new Node(1);
	    head = one;
	    one.next = two; 
        two.next = three; 
        three.next = four; 
        four.next = five; 
        five.next = six; 
        six.next = seven;
//        System.out.println(checkPalindrom(head));
        System.out.println(checkPalindromeWithoutUsingAnyLibrary(head));
	}
	
	/**
	 * @Desc: 
	 * Put all the elements in Stack.
	 * Start popping elements from stack one by one and compare against original linkedList element
	 * 
	 * @param head
	 * @return
	 */
	private static boolean checkPalindrom(Node head) {
		
		Node temp = head;
		boolean isPalindrome = true;
		
		if(temp == null) {
			return false;
		}
		Stack<Integer> integerStack = new Stack<>();
		while(temp != null) {
			integerStack.push(temp.data);
			temp = temp.next;
		}
		
		while(head!=null ) {
			int number = integerStack.pop();
			if(number == head.data) {
				isPalindrome = true;
			}else {
				isPalindrome = false;
				break;
			}
			head = head.next;
		}
		return isPalindrome;
	}
	
	public static boolean checkPalindromeWithoutUsingAnyLibrary(Node head) {
		
		Node fast = head;
		Node slow = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if(fast != null)
			slow = slow.next;
		
//		reverse slow pointer
		slow = reverse(slow);
		fast = head;
		while(slow!=null) {
			if(slow.data != fast.data)
				return false;
			slow = slow.next;
			fast = fast.next;
		}
		return true;
	}
	
	
	public static Node reverse(Node node) {
		Node prev = null;
		while(node!=null) {
			Node next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
		return prev;
	}

}
