
public class Merge2SortedLists {

	public static void main(String[] args) {
		int[] list1 = {2,4,4,4,5,6,8,9,14,100};
		int[] list2 = {1,2,3,4,5,6,7,8,9,10,11,15,26};
		int[] mergedList = merge(list1, list2);
	
		for (int i: mergedList) {
			System.out.printf("%2d ", i);
		}
		
		
	}
	
	public static int[] merge(int[] list1, int[] list2) {
		int[] temp = new int[list1.length + list2.length];
		int i = 0; int j = 0;
		int k = 0; int length = temp.length;
		while (k < length && i < list1.length && j < list2.length ) {			
			if (list1[i] <= list2[j]) {
				temp[k] = list1[i++];
			}
			else {
				temp[k] = list2[j++];
			}
			k++;
		}
		while (i < list1.length) {
			temp[k] = list1[i++]; k++;
		}
		while (j < list2.length) {
			temp[k] = list2[j++]; k++;
		}
		return temp;
	}

}
