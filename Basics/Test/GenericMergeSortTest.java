import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

class GenericMergeSortTest {

	@Test
	public void unsorterd_List() {
		String[] stringsUnsorted = {"z", "Aaa", "Z", "t", "l", "c", "o", ""};
		Integer[] integersUnsorted = {7, 1, 2, 9, 3, -3, 7, 1};

		String[] stringsSorted = {"", "Aaa","Z", "c", "l", "o", "t", "z"};
		Integer[] integersSorted = {-3, 1, 1, 2, 3, 7, 7, 9};
		
		GenericMergeSort.mergeSort(stringsUnsorted);
		GenericMergeSort.mergeSort(integersUnsorted);
		assertThat(stringsUnsorted, equalTo(stringsSorted));
		assertThat(integersUnsorted,equalTo(integersSorted));	
	}
	
	@Test 
	public void small_List() {
		String[] stringsUnsorted = {"t", "Aaa"};
		Integer[] integersUnsorted = {7, 2};

		String[] stringsSorted = {"Aaa", "t"};
		Integer[] integersSorted = {2, 7};
		
		GenericMergeSort.mergeSort(stringsUnsorted);
		GenericMergeSort.mergeSort(integersUnsorted);
		assertThat(stringsUnsorted, equalTo(stringsSorted));
		assertThat(integersUnsorted, equalTo(integersSorted));
	}
	
	@Test
	public void unsorterd_ListWithComparator() {
		String[] stringsUnsorted = {"Aaa", "z", "Z", "t", "l", "c", "o", ""};
		String[] stringsSorted = {"", "Aaa", "c", "l", "o", "t", "z", "Z"};
		
		GenericMergeSort.mergeSort(stringsUnsorted, new StringComparator());
		assertThat(stringsUnsorted, equalTo(stringsSorted));
	}


}
