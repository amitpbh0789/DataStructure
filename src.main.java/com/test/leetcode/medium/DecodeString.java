package com.test.leetcode.medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/decode-string/
 * @author amit
 *
 */
public class DecodeString {

	public static void main(String[] args) {

		System.out.println(decodeString("3[a2[c]]"));
		
		System.out.println(decodeStringSolution2("3[a2[c]]"));
	}
	private static String decodeString(String s) {

		if(s==null || s.length()<=1)
			return s;

		StringBuilder result = new StringBuilder();

		for(int i=0; i<s.length();) {
			char c = s.charAt(i);

			int start=i;

			if(c>='0' && c<='9') {

				while(c>='0' && c<='9') {
					i++;
					c = s.charAt(i);
				}

				int num = Integer.parseInt(s.substring(start, i));
				i++;
				int anchor = i;
				int bracketCount = 1;
				while(bracketCount != 0) {

					if(s.charAt(i) == '[') {
						bracketCount++;
					}else if(s.charAt(i) == ']') {
						bracketCount--;
					}
					i++;
				}
				i--;
				String resolved = decodeString(s.substring(anchor, i));
				result.append(decodeNumString(num, resolved));

			}else {
				result.append(c);
			}
			i++;
		}

		return result.toString();
	}

	public static String decodeNumString(int value, String str){
		//keep adding the string to a string builder for as many times as the value says
		StringBuilder path=new StringBuilder();
		while (value!=0){
			path.append(str);
			value--;
		}
		return path.toString();
	}


	private static String decodeStringSolution2(String s) {
		//      2 stack. one to store the integer and othet to store thr string
		Stack<Integer> intStack = new Stack<>();
		Stack<String> strStack = new Stack<>();

		int ptr = 0;
		String res = "";
		//      Loop through the string
		while(ptr<s.length()){
			char curr = s.charAt(ptr);
			//          If current char is digit then form comlete number and add into int Stack.
			if(Character.isDigit(curr)){
				int num = 0;
				while(Character.isDigit(s.charAt(ptr))){
					num = num*10+s.charAt(ptr)-'0';
					ptr++;
				}
				intStack.push(num);
			} else if(curr=='['){ //if opening bracket encounters, then add res string into Stack whatever is avaible and make res empty again
				strStack.push(res);
				res = "";
				ptr++;
			} else if(curr==']'){ //When closing encounters, poll out top from starting stack and append res string based on popped up number from the int stack.
				StringBuilder sb = new StringBuilder(strStack.pop());
				int count = intStack.pop();
				for(int i=1; i<=count; i++){
					sb.append(res);
				}
				res = sb.toString();
				ptr++;
			} else{ //if simple char encounters then keep on adding into res;
				res +=curr;
				ptr++;
			}

		}
		return res;
	}
}
