import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Skriv inn en tekst under som programmet skal reversere: ");
		String aStr = new String(input.nextLine());
		String reverseStr = "";
		
		for (int i = aStr.length() - 1; i >= 0; i--) {
			reverseStr = reverseStr + aStr.charAt(i);
		}
	
	System.out.println("Dette er teksten du skrev: " + aStr);
	System.out.println("Og dette er reversen på teksten: " + reverseStr);

	}

}
