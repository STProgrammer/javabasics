import java.util.Scanner;

public class PasswordCheck {

	public static void main(String[] args) {
		while (true) {
			Scanner input = new Scanner(System.in);
			String password = "";
			System.out.printf("Type in a password (minimum 8 characters,%n"
					+ "at least 2 digits and no special characters): %n");
			password = input.next();
			if (hasTwoDigits(password) && noSpecialChars(password)
					&& password.length() >= 8) {
				System.out.println("Password is valid!");
			}
			else System.out.println("Password is invalid!");
		} // end while loop
		
	} // end main method

	public static boolean hasTwoDigits(String password) {
		int count = 0;
		int passLength = password.length();
		char ch;
		for (int i = 0; i < passLength && count <= 2; i++) {
			ch = password.charAt(i);
			if (Character.isDigit(ch)) {
				count++;
			}
		} // end for
		return (count >= 2);
	} // end method


	public static boolean noSpecialChars(String password) {
		char ch;
		int passLength = password.length();
		for (int i = 0; i < passLength; i++) {
			ch = password.charAt(i);
			if (!(Character.isLetterOrDigit(ch))) {
				return false;
			}
		} return true;
	} // end method
}
	
