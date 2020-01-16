import java.util.Scanner;

public class NumberTypes {
	
	  public static String toHex(int num) {
		  int lastDigit = 0;
		  String hex = ""; String temp = "";
		  while (num > 0) {
			  	lastDigit = num % 16;
			  	if (lastDigit < 10) {temp += lastDigit;}
			  	else {temp += (char)('A' + (lastDigit - 10));}
			  	hex = temp + hex;
			  	temp = "";
			  	num /= 16;
		  }
		  return hex;
	  }
	  
	  
	public static int hexToDecimal(String hex) {
		int num = 0;
		int lastNum = 0;
		int length = hex.length();
		char ch = 'A';
		for (int i = 0; i < length; i++) {
			ch = hex.charAt(i);
			if (!(ch <= '9' && ch >= '0') && !(ch >= 'A' && ch <= 'Z')) {
				return 0;
			}
			if (ch <= '9') {
				lastNum = ch - 48;
				num = lastNum + num*16;
				}
			if (ch >= 'A') {
				lastNum = ch - 55;
				num = lastNum + num*16;
			}
		}
		return num;
	}
	
	public static String toBinary(int num) {
		String binary = "";
		String temp = "";
		int lastDigit = 0;
		while (num > 0) {
			lastDigit = num % 2;
			temp += lastDigit;
			binary = temp + binary;
			num /= 2;
			temp = "";
		}
		return binary;
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Type in a number to convert to Hexadecimal: ");  
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		System.out.println(num + " converted to hex is " + toHex(num));
		System.out.println(toHex(num) + " converted to decimal is " 
					+ hexToDecimal(toHex(num)));
		System.out.println(num + " converted to binary is " + toBinary(num));

	}

}
