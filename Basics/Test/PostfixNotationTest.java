import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class PostfixNotationTest {

	
	@ParameterizedTest
	@CsvSource(value = {"9:4 5 +", "15:3 5 *",
			"3:9 3 /", "-5:4 9 -", "25:5 10 - 0   5 - *",
			"-15:10 15 - 3 *", "8: 70 6-2/2/2/",
			"5:15 7 1 1 + - / 3 * 2 1 1 + + -", "5:5"}, delimiter = ':')
	void test_validExpression(int result, String input) {
		assertEquals(result, PostfixNotation.evaluateExpression(input));
	}
	
	@ParameterizedTest
	@CsvSource(value = {"0:4 +", "0:3 5 5 *",
			"0:9r 3 /", "0:abtrc", "0: 4 4 4 4 + +",
			"0: 5 + +", "0:10 + 5", "0:10 + 5 +", 
			"0:55+", "0:-5", "0: 4 0 /", "5 5 5 - /"}, delimiter = ':')
	void test_invalidExpression(String input) {
		assertEquals(0, PostfixNotation.evaluateExpression(input));
	}
	
	@Test
	void test_printResult() {
		assertEquals("Undefined (can't divide by zero)!", 
				PostfixNotation.printResult("4 0 /"));
		assertEquals("Undefined (can't divide by zero)!", 
				PostfixNotation.printResult("5 5 5 - /"));
		assertEquals("Invalid expression!", 
				PostfixNotation.printResult("4 0 / /"));
		assertEquals("Invalid expression!", 
				PostfixNotation.printResult("4 5 6 +"));
		assertEquals("Invalid expression!", 
				PostfixNotation.printResult("4 3 / /"));
		assertEquals(" ", 
				PostfixNotation.printResult(""));
		assertEquals("Invalid characters!", 
				PostfixNotation.printResult("4 3 + abc"));
		assertEquals("4", 
				PostfixNotation.printResult("2 2 +"));
	}
	
	@Test
	void test_emptyString() {
		assertEquals(0, PostfixNotation.evaluateExpression(""));
	}

}
