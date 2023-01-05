import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PasswortTest {
	@ParameterizedTest
	@ValueSource (strings = {"sdflkj","324kkdduk", "kkgfdkk22o",
			"123kkhjkjlkk¤2"})
	public void testPassword_allShouldReturnFalse(String input) {
		assertFalse(Password.checkPassword(input));
	}

}
