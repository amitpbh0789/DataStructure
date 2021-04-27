package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 *  A -> 1
 *  B -> 2
 *  C -> 3
 *  ...
 *  Z -> 26
 *  AA -> 27
 *  AB -> 28
 *   
 * @author amit
 *
 */
public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		System.out.println(excelSheetColumnNumber("AA"));
	}
	private static int excelSheetColumnNumber(String str) {
		if(str == null)
			return 0;
		if(str.length() == 1)
			return str.charAt(0)-'A'+1;
		
		char[] arr = str.toCharArray();
		int res = 0;
		for(int i=0; i<arr.length; i++) {
			res = (res*26)+arr[i]-'A'+1;
		}
		return res;
	}
}
