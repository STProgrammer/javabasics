import java.util.Comparator;


public class SelectionSortWithComparator {
	
	public static <E> E[] selectionSort(E[] list, Comparator<? super E> comparator) {
		int length = list.length;
		E temp = null;
		
		for (int i = 0; i < length-1; i++) {
			int minIndex = i;
			//find the minimum element
			for (int j = i+1; j < length; j++) {
				if (comparator.compare(list[minIndex], list[j]) > 0) {
					minIndex = j;
				}
			}
			//place the minimum element at the beginning
			temp = list[minIndex];
			list[minIndex] = list[i];
			list[i] = temp;
		}
		return list;
	}
}
