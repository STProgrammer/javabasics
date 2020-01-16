import java.util.Scanner;

public class CheckCreditCard {

	public static void main(String[] args) {
		while (true) {
			Scanner input = new Scanner(System.in);
			long cardNum;
			System.out.println("Type in a credit card number as a long integer: ");
			try {
				cardNum = input.nextLong();
				if (isValid(cardNum)) {
					System.out.println(cardNum + " is valid");
				}
				else {
					System.out.println(cardNum + " is invalid"); 
				}
			} catch (Exception e) {
				System.out.println("Invalid input, try again");
				continue;
			} // end try catch	
			
		} //end while loop

	} // end main
	public static boolean isValid(long number) {
		int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
		
		return ((prefixMatched(number, 4) || prefixMatched(number, 5)
				|| prefixMatched(number, 5) || prefixMatched(number, 37))
				&& getSize(number) <= 16 && getSize(number) >= 13 && (sum % 10 == 0));
		
	} // end isValid
	
	public static int sumOfDoubleEvenPlace(long number) {
		int sum = 0;
		number /= 10;
		int temp;
		while (number > 0) {
			temp = (int)(number % 10);
			sum = sum + getDigit(temp);
			number /= 100;
		}

		return sum;
	} // end sum even
	
	public static int getDigit(int number) {
		number = number * 2;
		if (number > 9) {
			number = (number / 10 + (number % 10));
		}
		return number;
	} // end get digit
	
	public static int sumOfOddPlace(long number) {
		int sum = 0;
		int temp;
		while (number > 0) {
			temp = (int)(number % 10);
			sum = sum + temp;
			number /= 100;
		}
		//System.out.println(sum);
		return sum;
	} // end sum odd place
	
	public static boolean prefixMatched(long number, int d) {
		int k = 1;
		if (d > 9) {
			k = 2;
		}
		return (d == getPrefix(number, k));
	}
	
	public static long getPrefix(long number, int k) {
		  long result = number;
		  for (int i = 0; i < getSize(number) - k; i++)
		    result /= 10;
		  return result;
		} // end get prefix

/* EN ALTERNATIV ER: 
 * public static boolean prefixMatched(long number) {
		int d = getPrefix(number);
		return ((d / 10 >= 4 && d / 10 <= 6) || d == 37);
	}
	
	public static int getPrefix(long number) {
		  int result;
		  result = (int) (number / Math.pow(10, getSize(number) - 2));
		  return result; 
		  }
		  og i "isValid metoden bare teste prefixMatched èn gang
		  
		  altså å skrive bare:
		  return (prefixMatched(number) && getSize(number) <= 16 && 
		  getSize(number) >= 13 && (sum % 10 == 0)); */	
	
	public static int getSize(long d) {
		int count = 0;
		for (count = 0; d > 0; d /= 10) {
			count++;
		}
		return count;
	} // end get size

}
