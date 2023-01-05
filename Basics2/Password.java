
public class Password {
	
	public static boolean checkPassword(String password) {
		return (checkLength(password) &&
				checkForOnlyDigitsAndLetters(password) &&
				checkThatContainsAtLeastThreeDigits(password));
	}
	
	private static boolean checkLength(String password) {
		return (password.length() >= 10);
	}
	
	private static boolean checkForOnlyDigitsAndLetters(String password) {
		int length = password.length();
		for (int i = 0; i < length; i++) {
			char ch = password.charAt(i);
			if (!Character.isLetterOrDigit(ch)) {
				return false;
			}
		} 
		return true;
	}
	
	private static boolean checkThatContainsAtLeastThreeDigits(String password) {
		int length = password.length();
		int counter = 0;
		for (int i = 0; i < length; i++) {
			char ch = password.charAt(i);
			counter = Character.isDigit(ch) ? counter + 1 : counter;
			if (counter >= 3) {
				return true;
			}
		}
		return false;
	}
}
