import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

class MyLinkedListTest {
	
	MyLinkedList<Integer> intList = new MyLinkedList<>();
	MyLinkedList<String> strList = new MyLinkedList<>();
	
	
	@BeforeEach
	void setup () {
		strList.addFirst("Paris");
		strList.addFirst("Oslo");
		strList.addFirst("Stockholm");
		strList.addFirst("Moscow");
		strList.addFirst("Copenhagen");
		strList.addFirst("Stockholm");
		strList.addFirst("Paris");
		intList.addFirst(5);
		intList.addFirst(7);
		intList.addFirst(15);
		intList.addFirst(3);
		intList.addFirst(3);
	}
	
	@Test
	void test_contains() {
		assertTrue(strList.contains("Stockholm"));
		assertTrue(strList.contains("Moscow"));
		assertTrue(strList.contains("Oslo"));
		assertFalse(strList.contains(""));
		assertFalse(strList.contains("oslo"));
		assertTrue(intList.contains(15));
		assertFalse(strList.contains(0));
	}

	@Test
	void test_get() {
	    IndexOutOfBoundsException thrown = assertThrows(
	            IndexOutOfBoundsException.class,
	            () -> intList.get(15), "Throw exception");
		assertEquals("Stockholm", strList.get(1));
		assertEquals("Paris", strList.get(0));
		assertEquals(3, intList.get(0));
	}
	
	@Test
	void test_indexOf() {
		assertEquals(1, strList.indexOf("Stockholm"));
		assertEquals(0, strList.indexOf("Paris"));
		assertEquals(-1, strList.indexOf("Tokyo"));
		assertEquals(4, intList.indexOf(5));
		assertEquals(0, intList.indexOf(3));
		assertEquals(-1, intList.indexOf(16));
	}
	
	@Test
	void test_lastIndexOf() {
		assertEquals(4, strList.lastIndexOf("Stockholm"));
		assertEquals(6, strList.lastIndexOf("Paris"));
		assertEquals(-1, strList.lastIndexOf("Tokyo"));
		assertEquals(4, intList.lastIndexOf(5));
		assertEquals(1, intList.lastIndexOf(3));
		assertEquals(-1, intList.lastIndexOf(16));
	}
	
	@Test
	void test_set() {
		assertEquals("Moscow", strList.set(3, "Paris"));
		assertEquals("Paris", strList.get(3));
		strList.set(7, "Kongsberg");
		assertEquals("Kongsberg", strList.get(7));
		assertEquals(7, intList.set(3, 9));
		assertEquals(9, intList.get(3));
		intList.set(5, 45);
		assertEquals(45, intList.get(5));
	}

}
