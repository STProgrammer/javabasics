import java.util.List;
import java.util.Scanner;

/*Koden er noe forskjellig fra den som er vist på videoen i forelesningen*/

public class SteinSaksPapir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String[] spill = new String[] {"saks", "stein", "papir"};
		System.out.println("Dette er saks, stein og papir spillet. ");
		while (true) {
			int playerChoice = 0;
			System.out.print("Saks (0), Stein (1) eller Papir (2)? ");
			try {
				playerChoice = (int)input.nextInt();
			    if (playerChoice > 2 || playerChoice < 0) {
			    	System.out.println("Invalid value!");
			    	System.exit(0);
			    }
			} catch (java.util.InputMismatchException e) {
				System.out.println("Invalid value!");
				System.exit(0);
			}
			int computerChoice = (int) (Math.random()*3);
			if (playerChoice == computerChoice)  {
				System.out.println("Datamaskinen har " + spill[computerChoice] + 
						". Du har " + spill[playerChoice] + 
						". Uavgjort!");
				}
			else if (playerChoice - computerChoice == -2 || 
					playerChoice - computerChoice == 1) {
				System.out.println("Datamaskinen har " + spill[computerChoice] + 
						". Du har " + spill[playerChoice] + 
						". Du har vunnet!");
			}
			else if (playerChoice - computerChoice == 2 || 
					playerChoice - computerChoice == -1) {
				System.out.println("Datamaskinen har " + spill[computerChoice] + 
						". Du har " + spill[playerChoice] + 
						". Du har tapt!");
			}
		}
	}
}
