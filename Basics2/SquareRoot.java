import java.util.Scanner;

public class SquareRoot {

	public static void main(String[] args) {
		while (true) {
			Scanner input = new Scanner(System.in);
			double number;
			System.out.println("Type in a number: ");
			try {
				number = input.nextDouble();
			} catch (Exception e) {
				System.out.println("Invalid input, try again!");
				continue;
			} //end try catch
			double rootNum = findRoot(number);
			System.out.println("Square root of " + number + " is " + rootNum);
			System.out.println();
			double rootNum2 = findRoot2(number);
			System.out.println("Square root of " + number + " is " + rootNum2);
			int integer = (int) number;
			int rootNum3 = findRoot2(integer);
			System.out.println("Square root of " + integer + " is " + rootNum3);
		} // end while loop
	} //end main
	
	public static double findRoot(double num) {
		double lastGuess = 2;
		double nextGuess = lastGuess;
		do {
			lastGuess = nextGuess;
			nextGuess = (lastGuess + num / lastGuess) / 2;
		} while (java.lang.Math.abs(nextGuess - lastGuess) > 0.00001);
		return nextGuess;
		
	}
	
	public static double findRoot2(double num) {
		double guess = 2;
		while (guess*guess - num > 0.0000000000001 | guess*guess - num < -0.0000000000001) {
			guess = (guess + num / guess) / 2;
		}
		return guess;
	}
	public static int findRoot2 (int num) {
		int max = num;
		int min = 1;
		int x = (max + min) / 2;
		while(!((x+1)*(x+1) > num & x*x <= num)) {
			if (x*x < num)
				min = x + 1;
				x = (max + min) / 2;
			if (x*x > num)
				max = x - 1;
				x = (max + min) / 2;

			if (x*x == num)
				return x;

			if ((x+1)*(x+1) > num & x*x < num)
				if ((num - x*x) < ((x+1)*(x+1) - num))
					return x;
				else 
					return x+1;
				
			}
		return x;

		}

}
