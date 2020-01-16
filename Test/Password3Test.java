import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Password3Test {
	
	
	
	@Test
	public void test_checkPassword() {
		assertTrue(Password3.checkPassword("asdfg23g4j"));
		assertFalse(Password3.checkPassword("qweewqqwpop23poimo"));
		assertFalse(Password3.checkPassword("234jrilow"));
		assertFalse(Password3.checkPassword("asdj3k4k2lk¤"));
		}
}
