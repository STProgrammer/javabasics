import java.util.Scanner;

public class ReverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Type in 10 integers in an array: \n");
		Scanner input = new Scanner(System.in);
		int[] list = new int[10];
		for (int i = 0; i < list.length; i++) {
			list[i] = input.nextInt();
		}
		for (int i: list) {
			System.out.print(i + " ");
		}
		System.out.println("\nHere is the reverse array: ");
		list = reverse(list);
		for (int i: list) {
			System.out.print(i + " ");
		}

	}
	public static int[] reverse(int[] list) {
		int j = list.length - 1;
		int firstValue;
		int lastValue;
		for (int i = 0 ; i < j; i++, j--) {
			firstValue = list[i];
			lastValue = list[j];
			list[i] = lastValue;
			list[j] = firstValue;
		}
		return list;
	}

}
