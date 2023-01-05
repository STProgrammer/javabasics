import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestGenericStack {

	@Test
	void test_genericStackStrings() {
		GenericStack<String> gsString = new GenericStack<>(1);
		gsString.push("one");
		gsString.push("two");
		assertTrue(gsString.peek().equals("two"));
		gsString.push("three");
		assertTrue(gsString.peek().equals("three"));
		assertTrue(gsString.pop().equals("three"));
		assertTrue(gsString.peek().equals("two"));
		assertFalse(gsString.peek().equals("three"));
		gsString.pop(); gsString.pop();
		assertTrue(gsString.isEmpty());
		assertNull(gsString.pop());
	}

	@Test
	void test_genericStackIntegers() {
		GenericStack<Integer> gsInteger = new GenericStack<>(1);
		gsInteger.push(1);
		gsInteger.push(2);
		assertTrue(gsInteger.peek() == 2);
		gsInteger.push(3);
		assertTrue(gsInteger.peek() == 3);
		assertTrue(gsInteger.pop() == 3);
		assertTrue(gsInteger.peek() == 2);
		assertFalse(gsInteger.peek() == 3);
		gsInteger.pop(); gsInteger.pop();
		assertTrue(gsInteger.isEmpty());
		assertNull(gsInteger.pop());
	}

}
