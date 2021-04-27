
public class PossibleRotationOfNumber {

	public static void main(String[] args) {
		int number = 1234;
		printPossibleRotations(number);
	}
	private static void printPossibleRotations(int number) {
		
		int digit = countDigit(number);
		int powOfTen = (int)Math.pow(10, digit-1);
		
		for(int i =0; i<digit;i++) {
			
			int firstDigit = number/powOfTen;
			number = (number*10+firstDigit) - (firstDigit * ((int)Math.pow(10, digit)));
			
			System.out.println(number);
		}
		
	}
	private static int countDigit(int number) {
		int digit =0;
		while(number != 0) {
			digit= digit +1;
			number = number/10;
		}
		return digit;
	}
	
	
}
