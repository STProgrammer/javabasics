import java.util.Scanner;


public class GaltonBox {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int balls;
		int traces;
		while (true) {
			try {
				System.out.print("Specify number of balls: ");
				balls = input.nextInt();
				System.out.print("Specify number of spots: ");
				traces = input.nextInt();
				if (traces <= 0) {
					System.out.println("||");
					continue;
				}
			} catch (Exception e) {
				continue;
			} // end try catch
			int[] slots = new int[traces];
			int index;  //support variabel
			for (int h = 0; h < balls; h++) {
				index = traces - 1;
				for (int i = 1; i < traces; i++) {
					index = index + getPathForOneBall();
				}
				slots[index]++;
				System.out.println(" ");	
			}
			printResult(slots);
		} // end while-loop


	} //end main
	
	private static int getPathForOneBall() {
		boolean left = (Math.random() < 0.5) ? true : false;
		if (left) {
			System.out.print("L");
			return -1;
		} else {
			System.out.print("R");
			return 0;
		}
		
	}
	private static void printResult(int[] slots) {
		System.out.println("\n");
		int max = max(slots);
		for (int i = max; i > 0; i--) {
			for (int j = 0; j < slots.length; j++) {
				if (i <= slots[j]) {
					System.out.print(" O ");
				}
				else {
					System.out.print("   ");
				}	
			}
			System.out.println("");
		}
		for (int i = 0; i < slots.length; i++) {
			  System.out.print("|" + i + "|");
			}
		System.out.println("");
	}
	
	private static int max(int[] slots) {
		int max = slots[0];
		for (int i = 0; i < slots.length; i++) {
			if (max < slots[i]) {
				max = slots[i];
			}	
		}
		return max;
	}

}
