import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ClockTest {

	@Test
	void incrementSecondsShouldReturn_1_FromDefaultClock() {
		Clock myClock = new Clock();
		assertEquals(myClock.incrementSeconds(), 1);
	}
	
	@Test
	void incrementSecondsShouldReturn_0_235959() {
		Clock myClock = new Clock();
		myClock.setTime(23, 59, 59);
		assertEquals(myClock.incrementSeconds(), 0);
	}

}
