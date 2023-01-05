import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

class RemoveDuplicatesTest {

	@Test
	void test_WithStrings() {
	    String[] str = {"a","a","a","g","g","w","r","s","s"};
	    ArrayList<String> input = new ArrayList<>(Arrays.asList(str));
		ArrayList<String> expected = new ArrayList<>(Arrays.asList("a","g","w","r","s"));
		ArrayList<String> result = RemoveDuplicates.removeDuplicates(input);
		assertThat(result, equalTo(expected));
	}
	
	@Test
	void test_WithIntegers() {
	    Integer[] ints = {1,2,3,3,3,34,5,6,6,6,6,7};
	    ArrayList<Integer> input = new ArrayList<>(Arrays.asList(ints));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1,2,3,34,5,6,7));
		ArrayList<Integer> result = RemoveDuplicates.removeDuplicates(input);
		assertThat(result, equalTo(expected));
		result = RemoveDuplicates.removeDuplicates(expected);
		assertThat(result, equalTo(expected));
	}


}
