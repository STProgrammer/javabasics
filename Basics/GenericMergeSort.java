import java.util.Comparator;

public class GenericMergeSort {
	
	public static void main(String args[]) {
		
		int[] list = {12, -2, 7, 4};
		
		mergeSort(list);

		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");	
		}
		System.out.println();
		
		String[] strings = {"Jlkj","Aasd","kng","Asdr","mvzz","are"};
		
		mergeSort(strings);
		
		System.out.println("Generic merge sort:");
		for (int i = 0; i < strings.length; i++) {
			System.out.print(strings[i] + " ");	
		}
		System.out.println();
		
		GenericStack<String> stack = new GenericStack<>();
		StringComparator comparator = new StringComparator();
		
		mergeSort(strings, comparator);
		
		System.out.println("Generic merge sort med Comparator<String>");
		for (int i = 0; i < strings.length; i++) {
			System.out.print(strings[i] + " ");	
		}
	}
	
	/**Generic merge sort*/
	public static <E extends Comparable<E>> void mergeSort (E[] list) {
		if (list.length > 1) {
			mergeSort(list, 0, list.length-1);
		}
	}
	
	public static <E extends Comparable<E>> void mergeSort(E[] list, int startPt, int endPt) {
		if (endPt > startPt) {
			int middlePt = (endPt + startPt) / 2;		
			mergeSort(list, startPt, middlePt);
			mergeSort(list, middlePt+1, endPt);
			merge(list, middlePt, startPt, endPt);
		}
	}
	
	//merge method
	public static <E extends Comparable<E>> void merge(E[] list, int middlePt, int startPt, int endPt) {
		E[] temp = (E[]) new Comparable[endPt+1];
		
		//Index of left and right arrays
		int leftIndex = startPt; int rightIndex = middlePt+1;
		int tmpIndex = 0; //index of temp array
		
		
		while (leftIndex <= middlePt && rightIndex <= endPt) {
			if (list[leftIndex].compareTo(list[rightIndex]) > 0) {
				temp[tmpIndex] = list[rightIndex++];
			} else {
				temp[tmpIndex] = list[leftIndex++];
			}
			tmpIndex++;
		}
		while (leftIndex <= middlePt) {
			temp[tmpIndex++] = list[leftIndex++];
		}
		while (rightIndex <= endPt) {
			temp[tmpIndex++] = list[rightIndex++];
		}
		// copy from temp to list
		tmpIndex = 0;
		while (startPt <= endPt) {
			list[startPt++] = temp[tmpIndex++];
		}
	}
	
	
	/** Generic merge sort using comparator */
	//Helper method with comparator
	public static <E> void mergeSort(E[] list, Comparator<? super E> comparator) {
		if (list.length > 1) {
			mergeSort(list, 0, list.length-1, comparator);
		}	
	}
	
	// Merge sort method
	public static <E> void mergeSort(E[] list, int startPt, int endPt, 
			Comparator<? super E> comparator) {
		
		if (endPt > startPt) {
			int middlePt = (endPt + startPt) / 2;		
			mergeSort(list, startPt, middlePt, comparator);
			mergeSort(list, middlePt+1, endPt, comparator);
			merge(list, middlePt, startPt, endPt, comparator);
		}
			
	}
	
	//merge method
	public static <E> void merge(E[] list, int middlePt, int startPt, int endPt,
			Comparator<? super E> comparator) {
		E[] temp = (E[]) new Object[endPt+1];
		
		//Index of left and right arrays
		int leftIndex = startPt; int rightIndex = middlePt+1;
		int tmpIndex = 0; //index of temp array
		
		
		while (leftIndex <= middlePt && rightIndex <= endPt) {
			if (comparator.compare(list[leftIndex], list[rightIndex]) > 0) {
				temp[tmpIndex] = list[rightIndex++];
			} else {
				temp[tmpIndex] = list[leftIndex++];
			}
			tmpIndex++;
		}
		while (leftIndex <= middlePt) {
			temp[tmpIndex++] = list[leftIndex++];
		}
		while (rightIndex <= endPt) {
			temp[tmpIndex++] = list[rightIndex++];
		}
		// copy from temp to list
		tmpIndex = 0;
		while (startPt <= endPt) {
			list[startPt++] = temp[tmpIndex++];
		}
	}
	
	
	/** Simple merge sort with integers */
	//Helping method, method that prepares to the main method
	public static void mergeSort(int[] list) {
		if (list.length > 1) {
			mergeSort(list, 0, list.length-1);
		}
	}
	
	//main mergeSort method
	public static void mergeSort(int[] list, int startPt, int endPt) {
		if (endPt > startPt) {
			int middlePt = (endPt + startPt) / 2;		
			mergeSort(list, startPt, middlePt);
			mergeSort(list, middlePt+1, endPt);
			merge(list, middlePt, startPt, endPt);
		}
	}
	
	// merge method
	public static void merge(int[] list, int middlePt, int startPt, int endPt) {
		int[] temp = new int[endPt+1];
		
		//Index of left and right arrays
		int leftIndex = startPt; int rightIndex = middlePt+1;
		int tmpIndex = 0; //index of temp array
		
		while (leftIndex <= middlePt && rightIndex <= endPt) {
			if (list[leftIndex] > list[rightIndex]) {
				temp[tmpIndex] = list[rightIndex++];
			} else {
				temp[tmpIndex] = list[leftIndex++];
			}
			tmpIndex++;
		}
		while (leftIndex <= middlePt) {
			temp[tmpIndex++] = list[leftIndex++];
		}
		while (rightIndex <= endPt) {
			temp[tmpIndex++] = list[rightIndex++];
		}
		// copy from temp to list
		tmpIndex = 0;
		while (startPt <= endPt) {
			list[startPt++] = temp[tmpIndex++];
		}
	}

	
}
	

	

