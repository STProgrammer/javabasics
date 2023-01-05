import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class TriangleTest {
	
	Triangle tr1;
	Triangle tr2;
	Triangle tr3;
	
	@BeforeEach
	public void setup() {
		tr1 = new Triangle();
		tr2 = new Triangle(-1);
		tr3 = new Triangle(-3, 5, 600);
	}
	
	@Test
	public void test_checkLegality() {
		assertTrue(tr1.checkLegality(3, 4, 5));
		assertFalse(tr1.checkLegality(300, 1, 5));
		assertFalse(tr1.checkLegality(0, 4, 4));	
	}
	
	@Test
	public void test_equals() {
		assertTrue(tr1.equals(tr2));
		assertFalse(tr2.equals(tr3));
	}
	
	@Test
	public void test_getArea() {
		assertTrue(tr1.getArea() == tr2.getArea());
	}
	
	@Test
	public void test_getPerimeter() {
		assertTrue((1+1+1) == tr1.getPerimeter());
	}
}
	
	
	
	
	
	
	
	