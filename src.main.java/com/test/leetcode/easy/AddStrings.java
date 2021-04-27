package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/add-strings/
 * 
 * @author amit
 *
 */
public class AddStrings {

	public static void main(String[] args) {

		AddStrings obj = new AddStrings();
		String num1 = "10";
		String num2 = "12325";
		
		System.out.println(obj.addStrings(num1, num2));
	}

	public String addStrings(String num1, String num2) {

		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for(int i=num1.length()-1, j=num2.length()-1;
				i>=0 || j>=0 || carry == 1; //carry 1 because maximum sum of 2 single digit could be 18 so carry would be 1
				i--, j--) {
			
			int a = i>=0?num1.charAt(i)-'0':0;
			int b = j>=0?num2.charAt(j)-'0':0;
			
//			To calculate what number to put after adding
			sb.append((a+b+carry)%10);
//			To find out carry to be forwarded. 
			carry = (a+b+carry)/10;
		}
		
		return sb.reverse().toString();
	}
}
