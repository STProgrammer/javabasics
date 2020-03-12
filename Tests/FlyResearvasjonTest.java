import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class FlyReservasjonTest {
	FlyReservasjon f1;
	FlyReservasjon f2;
	
	@BeforeEach
	void setup() {
		f1 = new FlyReservasjon();
		f2 = new FlyReservasjon(150);
	}
	
	@Test
	public void test_reserveSeat() {
		assertTrue(f1.reserveSeat(1, 'A'));
		assertFalse(f1.reserveSeat(1, 'A'));
		assertTrue(f2.reserveSeat(50, 'D'));
		assertFalse(f2.reserveSeat(101, 'D'));
	}
	
}
