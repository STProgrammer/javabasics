import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TriangleTest {
	
	Triangle tr1;

	@BeforeEach
	void setup() {
		tr1 = new Triangle();
	}
	
	
	@Test
	void testEquals() {
		tr1 = new Triangle(1);
		Triangle tr2 = new Triangle(3, 4, 6);
		Triangle tr3 = new Triangle(3, 4, 6);
		Triangle tr4 = new Triangle(5);
		Triangle tr5 = new Triangle(5,5,5);
		Triangle tr6 = new Triangle(1,1,1);
		Triangle tr7 = new Triangle(3, 6, 4);
		assertTrue(tr1.equals(tr6));
		assertTrue(tr2.equals(tr3));
		assertTrue(tr4.equals(tr5));
		assertFalse(tr1.equals(tr2));
		assertFalse(tr1.equals(tr5));
		assertFalse(tr3.equals(tr7));
	}
		
	@ParameterizedTest
	@CsvSource ({"3,4,5", "2,2,2", "100,101,200"})
	void test_true_CheckLegality(double side1, double side2, double side3) {
		assertTrue(tr1.checkLegality(side1, side2, side3));
		
	}
	
	@ParameterizedTest
	@CsvSource ({"3,4,8", "2,1,-1", "100,101,600"})
	void test_false_CheckLegality(double side1, double side2, double side3) {
		assertFalse(tr1.checkLegality(side1, side2, side3));
	}
	
	@ParameterizedTest
	@CsvSource ({"3,4,5", "2,2,2", "100,101,200"})
	void testGetArea(double side1, double side2, double side3) {
		double s = (side1 + side2 + side3) / 2;
		double area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3)); 
		tr1 = new Triangle(side1, side2, side3);
		assertEquals(tr1.getArea(), area);
	}
	
	@ParameterizedTest
	@CsvSource ({"3,4,5", "2,2,2", "100,101,200"})
	void testGetPerimeter(double side1, double side2, double side3) {
		double perimeter = side1 + side2 + side3;
		tr1 = new Triangle(side1, side2, side3);
		assertEquals(tr1.getPerimeter(), perimeter);
	}
	
	

}
