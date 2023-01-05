//import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import org.junit.jupiter.api.Test;

class MyHashMapTest {
	
	MyMap<String, Integer> map = new MyHashMap<>();
	java.util.Set<Integer> set = new java.util.HashSet<Integer>();

	@BeforeEach
	void setup () {
	    map.put("Smith", 30);
	    map.put("Anderson", 31);
	    map.put("Lewis", 29);
	    map.put("Cook", 29);
	    map.put("Smith", 65);
	    map.put("Smith", 65);
	    set.add(65);
	    set.add(30);
	}
	
	@Test
	void test_contains() {
		assertTrue(map.containsKey("Smith"));
		assertTrue(map.containsKey("Anderson"));
		assertTrue(map.containsKey("Lewis"));
		assertFalse(map.containsKey(""));
		assertFalse(map.containsKey("oslo"));
		assertTrue(map.containsValue(30));
		assertTrue(map.containsValue(65));
		assertFalse(map.containsValue(0));
	}
	
	@Test
	void test_getAll() {
		assertEquals(set, map.getAll("Smith"));
		set.add(45);
		assertThat(set, not(map.getAll("Smith")));
		
	}
	
	

}
