package com.test.algorithm.mathematical;

/**
 * @Note: This formula applies only incase of 2 numbers
 * Formula: a x b = LCM(a, b) * GCD (a, b)
 * LCM(a, b) = a x b/GCD (a, b)
 * 
 * 	We know,
 		LCM(a, b)=\frac{a*b}{gcd(a, b)}
		The above relation only holds for two numbers,
 		LCM(a, b, c)\neq \frac{a*b*c}{gcd(a, b, c)}
 
 * @author amit
 *
 */
public class FindLCM {

	public static void main(String[] args) {
		int a = 15, b = 20; 
		FindLCM obj = new FindLCM();
		System.out.println(obj.findLCM(a, b));
	}
	
	/**
	 * @Desc Get the GCD and apply formula
	 * @param a
	 * @param b
	 * @return
	 */
	public int findLCM(int a, int b) {
		int gcd = findGCD(a, b);
		int lcm = (a*b)/gcd;
		return lcm;
	}
	
	/**
	 * @Desc This method will calculate GCD of 2 numbers
	 * @param a
	 * @param b
	 * @return
	 */
	public int findGCD(int a, int b) {
		if(b==0)
			return a;
		
		return findGCD(b, a%b);
	}
}
