
public class GenericBubbleSort {
	
	public static <E extends Comparable<E>> void sort(E[] anArray) {
		
		boolean sorted = false;
		E temp = null;
		
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < anArray.length-1; i++) {
				if (anArray[i].compareTo(anArray[i+1]) > 0) {
					sorted = false;
					temp = anArray[i];
					anArray[i] = anArray[i+1];
					anArray[i+1] = temp;
				}	
			}	
		}
	}
	public static <E extends Comparable<E>> void print(E[] anArray) {
		for (int i = 0; i < anArray.length; i++) {
			System.out.print(anArray[i] +  " ");
		}
		System.out.println();
	}
	
	
}
	


