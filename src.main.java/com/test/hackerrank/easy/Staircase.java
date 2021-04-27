package com.test.hackerrank.easy;

/**
 * https://www.hackerrank.com/challenges/staircase/problem?h_r=next-challenge&h_v=zen
 *
 */
public class Staircase {

	public static void main(String[] args) {
		for(int i=6; i>0; i--){
			int inx = 1;
			while(inx<=6){
				if(inx<i){
					System.out.print(" ");
				}else{
					System.out.print("#");
				}
				inx++;
			}
			System.out.println();
		}
	}
}
