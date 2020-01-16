import java.util.Scanner;

public class PalindromeTest {

	public static void main(String[] args) {
		while (true) {
			// TODO Auto-generated method stub
			int number;
			try {
				Scanner input = new Scanner(System.in);
				System.out.println("Write a positive integer: ");
				number = input.nextInt();
			}  catch (Exception e) {
				System.out.println("Invalid input, try again!");
				continue;
			} //end try-catch
			boolean palBool = checkPalindrome(number);
			if (palBool == true) {
				System.out.println(number + " is palindrome");
			} else System.out.println(number + " is not palindrome");
		}// end loop

	} //end main void
	
	public static boolean checkPalindrome(int num) {
		int reverseNum = reverseInt(num);
		return (reverseNum == num);
	} //end CheckPalindrome
	
	public static int reverseInt(int num) {
		int revNum = 0;
		int lastDigit = 0;
		while (num > 0)	{
			lastDigit = num % 10;
			revNum = revNum * 10 + lastDigit;
			num /= 10;
		} // end while loop
		return revNum;
	} // end Reverse

}
