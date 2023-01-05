import java.util.Scanner;

public class TestArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Type in integer between 1 and 100: ");
		int[] myArray = new int[100];
		int num = 4;
		while (true) {
			try {
				num = input.nextInt();
				if (num < 1 || num > 100) {
					break;
				}
				myArray[num-1]++;
			} catch (Exception e) {
				break;
			}
			
		}
		for (int i = 0; i < myArray.length; i++) {
			if (myArray[i] > 0) {
				System.out.println((i + 1) + " specified " + myArray[i] 
						+ ((myArray[i] == 1) ? " time" :" times"));
			}
			}
		
		}
		
}
