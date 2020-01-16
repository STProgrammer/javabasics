public class Password3 {
	public static String password; //ikke brukt men kan brukes
	
	public static boolean checkPassword(String password) {
		return (checkLength(password, 10) && 
		checkForOnlyDigitsAndLetters(password) &&
		checkThatContainsAtLeastThreeDigits(password));
	}
	
	public static boolean checkLength(String password, int length) {
		return password.length() >= length;
		}
	
	public static boolean checkForOnlyDigitsAndLetters(String password) {
	int length = password.length();
	char ch = 'A';
	for (int i = 0; i < length; i++) {
		ch = password.charAt(i);
		if (!Character.isLetterOrDigit(ch)) {
			return false;
			}
		}
		return true;
	}
	
	public static boolean checkThatContainsAtLeastThreeDigits(String password) {
		int length = password.length();
		char ch = 'A';
		int counter = 0;
		for (int i = 0; i < length; i++) {
			ch = password.charAt(i);
			if (Character.isDigit(ch)) {counter++;}
			if (counter >= 3) {return true;}
		}
		return false;
	}
}