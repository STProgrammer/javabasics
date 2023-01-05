import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class RadTest {
	Rad r1;
	Rad r2;
	
	@BeforeEach
	void setup() {
		r1 = new Rad();
		r2 = new Rad(10);
	}
	
	@Test
	public void test_isLegalSeat() {
		assertTrue(r1.isLegalSeat('A'));
		assertTrue(r1.isLegalSeat('D'));
		assertTrue(r1.isLegalSeat('a'));
		assertTrue(r1.isLegalSeat('d'));
		assertFalse(r1.isLegalSeat('E'));
		assertTrue(r2.isLegalSeat('J'));
		assertFalse(r2.isLegalSeat('K'));
	}
	
	@Test
	public void test_assignSeat() {
		assertTrue(r1.assignSeat('a'));
		assertFalse(r1.assignSeat('A'));
	}
}
