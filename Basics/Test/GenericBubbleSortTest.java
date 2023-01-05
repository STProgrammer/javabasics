import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

class GenericBubbleSortTest {
	
	
	@BeforeEach
	void setup() {

	}

	
	@Test
	public void unsorterd_List() {
		String[] stringsUnsorted = {"Aaa", "z", "t", "l", "c", "o"};
		Integer[] integersUnsorted = {1, 7, 2, 9, 3, 7, 1};

		String[] stringsSorted = {"Aaa", "c", "l", "o", "t", "z"};
		Integer[] integersSorted = {1, 1, 2, 3, 7, 7, 9};
		GenericBubbleSort.sort(stringsUnsorted);
		GenericBubbleSort.sort(integersUnsorted);
		assertThat(stringsUnsorted, is(equalTo(stringsSorted)));
		assertThat(integersUnsorted, is(equalTo(integersSorted)));	
	}
	
	@Test public void small_List() {
		String[] stringsUnsorted = {"t", "Aaa"};
		Integer[] integersUnsorted = {7, 2};

		String[] stringsSorted = {"Aaa", "t"};
		Integer[] integersSorted = {2, 7};
		GenericBubbleSort.sort(stringsUnsorted);
		GenericBubbleSort.sort(integersUnsorted);
		assertThat(stringsUnsorted, is(equalTo(stringsSorted)));
		assertThat(integersUnsorted, is(equalTo(integersSorted)));
	}

}
