import java.util.Scanner;
import java.lang.Math;

public class NumberPyramide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row = 0; // rad nummber, starter på 0
		int number = 1; //tall som skal skrives ut
		int i = 0;
		int column = 0; //kolonne nummer

		for (row = 0; row < 9; row++) {
			column = 1 + row*2;
			for (i = 9-row; i > 1; i--) {
				System.out.printf("     ");
			}
			for (i = 0; i < column/2+1; i++) {
				System.out.printf("%5d", number);
				number =  number*2;
			}
			number = number/2;
			for (i = column/2+1; i < column; i++) {
				number = number/2;
				System.out.printf("%5d", number);
			}
			System.out.println();
		}

			
		
	}
}
