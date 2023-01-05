import java.util.Scanner;
import java.math.*;

public class GameOfCraps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int roll = getRoll();
		if (roll == 7 | roll == 11) {
			System.out.println("You win!");
			System.exit(1);
		}
		else if (roll == 2 | roll == 3 | roll == 12) {
			System.out.println("You lose!");
			System.exit(2);
		}
		int point = roll;
		do {
			roll = getRoll();
			if (roll == 7) {
				System.out.println("You lose!");
				System.exit(2);
			}
			else if (roll == point) {
				System.out.println("You win!");
				System.exit(1);
			}
			
		} while (roll != 7 && roll != point);
		
	}
	
	public static int getRoll() {
		int dice1;
		int dice2;
		dice1 = (int) (Math.random() * 6 + 1);
		dice2 = (int) (Math.random() * 6 + 1);
		System.out.printf("You rolled %d + %d = %d \n", dice1, dice2, (dice1 + dice2));
		return dice1 + dice2;
	}

}
