import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class PatternMatchingTest {
	
	@ParameterizedTest
	@CsvSource(value = {"aaabb cc ddd aaaab:aab:1", 
			"fdddddddf:df:7", "::-1",
			"fdsfdsfdsssddff:sdf:-1", "poioppoi werku:ku:12",
			"abcdef:abcdefg:-1","abcdef:abcdef:0",
			"aaa:aaa:0","aaa:aaaa:-1","uiooppoiop:iop:7",":rwe:-1","wer::-1"},
			delimiter = ':')
	void test_PatternMatcher(String str, String pattern, int index) {
		assertEquals(index, PatternMatching.patternMatch(str, pattern));
	}
	
	@Test
	void test_PatternMatcherWithSpaces() {
		assertEquals(3, PatternMatching.patternMatch("rew tt ffg", " tt "));
		assertEquals(-1, PatternMatching.patternMatch("rewttffg", " tt "));
		assertEquals(3, PatternMatching.patternMatch("rew tutffg", " tu"));
		assertEquals(3, PatternMatching.patternMatch("rew tutffg", " "));
	}
	
	@Test
	void test_PatternMatcherEmptyStrings() {
		assertEquals(-1, PatternMatching.patternMatch("", ""));
		assertEquals(-1, PatternMatching.patternMatch("", "abcd"));
		assertEquals(-1, PatternMatching.patternMatch("abcd", ""));
	}
	

}
