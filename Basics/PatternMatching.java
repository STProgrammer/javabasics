import java.util.*;


public class PatternMatching {
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Write a text: ");
		String str = input.nextLine();
		
		System.out.println("Write a pattern to search in the text: ");
		String pattern = input.nextLine();
		
		int index = patternMatch(str, pattern);
		
		System.out.println("The pattern " + pattern + " has been found "
				+ "first in the index: " + index);
		
		input.close();
		
	}
	
	public static int patternMatch(String str, String pattern) {
		if (str == null || pattern == null ||
				str == "" || pattern == "") {
			return -1;
		}
		int k = 0;
		int matchIndex = 0; //indeks av start match
		int patternLength = pattern.length();
		int strLength = str.length();
		for (int i = 0; i < strLength; i++) {
			if (k == patternLength) {
				return matchIndex;
			}
			else if (str.charAt(i) == pattern.charAt(k)) {
				k++;
			}	
			else {
				i -= k;
				k = 0;
				matchIndex = i + 1;
				}
			}
		if (k == patternLength) {
			return matchIndex;
		}
		return -1;
	}

		

}
