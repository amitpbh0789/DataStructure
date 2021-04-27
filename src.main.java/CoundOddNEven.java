
public class CoundOddNEven {

	public static void main(String[] args) {
		int number = 12549;
		countOddEven(number);

	}
	
	private static void countOddEven(int number) {
		
		int odd = 0, even = 0;
		 while (number != 0) {
			 int lastNumber = number%10;
			 if(lastNumber%2 == 0) {
					even = even+1;
				}else {
					odd = odd + 1;
				}
				number = number/10;
		 }
		
		 System.out.println("Even count is "+ even +" Odd number count is "+odd);
	}

}
