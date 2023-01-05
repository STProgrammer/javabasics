import java.util.Scanner;

public class FindTwoBestStudents {

	public static void main(String[] args) {
		while (true) {
			Scanner input = new Scanner(System.in);
			int antStud = 0;
			try {
				System.out.print("Oppgi antall studenter: ");
				antStud = input.nextInt();
				if (antStud < 0) {
					System.out.println("Ugyldig input, prøv igjen");
					continue;
				}
			} catch (Exception e) {
				System.out.println("Ugyldig input, prøv igjen");
				continue;
			}
			int firstScore = 0;
			int secondScore = 0;
			int tempScore = 0;
			String firstStudent = new String();
			String secondStudent = new String();
			String tempStudent = new String();
			
			try {
				for (int i = 0; i < antStud; i++) {
					System.out.printf("Oppgi studentens score og navn: ");
					tempScore = input.nextInt();
					tempStudent = input.nextLine().trim();
					if (firstScore < tempScore) {
						secondScore = firstScore;
						secondStudent = firstStudent;
						firstScore = tempScore;
						firstStudent = tempStudent;
					}
					else if (secondScore < tempScore) {
						secondScore = tempScore;
						secondStudent = tempStudent;
					} 
				}
			} catch (Exception e) {
				System.out.println("Ugyldig input, vi starter igjen!");
				continue;
			}
			System.out.printf("Top to studenter: %n");
			System.out.printf("Første plass: %s med score %d %n", firstStudent, firstScore);
			System.out.printf("Andre plass: %s med score %d %n", secondStudent, secondScore);
			System.out.println("Prøver igjen");
		}			
	}
}


