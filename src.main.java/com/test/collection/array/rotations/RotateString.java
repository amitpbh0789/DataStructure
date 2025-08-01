package com.test.collection.array.rotations;

public class RotateString {

	public static void main(String[] args) {
		
		String str = "ShruthiReddy";
		int d = 2;
//		leftRotation(str, d);
		rightRotation(str, d);
		
	}
	
	private static void leftRotation(String str, int d) {
		String ans = str.substring(d) + str.substring(0, d);
		System.out.println(ans);
	}
	
	private static void rightRotation(String str, int d) {
		
		  leftRotation(str, str.length() - d); 
		
	}
}
