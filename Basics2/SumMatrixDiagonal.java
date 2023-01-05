import java.util.Scanner;

public class SumMatrixDiagonal {

	public static void main(String[] args) {
		while (true) {
			Scanner input = new Scanner(System.in);
			int[][] myMatrix = new int[4][4];
			System.out.println("Type in your 4x4 matrx:");
			try {
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						myMatrix[i][j] = input.nextInt();
					}
				} 
			} catch (Exception e) {
				System.out.println("Please try again!");
				continue;
			}
			
			// printing the matrix
			System.out.println("Here is the matrix: ");
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					System.out.printf("%4d", myMatrix[i][j]);
				}
				System.out.println(" \n");
			}
			int sum = 0;
			for (int i = 0; i < 4; i++) {
					sum = sum + myMatrix[i][i];
			}
			double mean = (double)sum / 4;
			System.out.println("The sum of the diagonale is " + sum);
			System.out.println("The mean of the diagonale is " + mean);
		}

	}
}
