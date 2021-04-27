package com.test.leetcode.easy;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 * 
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 *  
 * @author amit
 *
 */
public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		System.out.println(excelSheetColumnTitle(3));
	}
	private static String excelSheetColumnTitle(int number) {
		
		if(number<1) return null;
		String str = "";
		while(number>0) {
			number--;
			str = (char)('A'+number%26) + str;
			number = number/26;
		}
		return str;
	}
}
