import java.util.Scanner;

public class CharToNumber {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while (true) {
			char bokstav = ' ';
			String s = new String();
			System.out.printf("Oppgi et bokstav: ");
			try {
				s = input.nextLine();
				if (s.length() > 1) {
					System.out.println("Ugyldig input. Bare ett bokstav.");
					System.exit(0);
				}
				bokstav = s.charAt(0);
			} catch (Exception e) {
				System.out.println("Ugyldig input.");
				System.exit(0);
			}
			bokstav = Character.toUpperCase(bokstav);
			int temp = (int)bokstav - 59;
			int tall = temp / 3;
			if (((tall == 9 | tall == 8) & temp % 3 == 0) | (tall == 10)) {
				tall--;
			}
			else if (temp == -27) {
				tall = 0;
			}
			else if (temp == -17 | temp == -24) {
				tall = 10;
			}
			
			if (tall == 10) {
				System.out.printf("%c har ikke et responderende tall. %n", bokstav);
			}
			else if (tall == 0) {
				System.out.printf("Numerisk verdi for [MELLOMROM] er %d %n", tall);
			}
			else if (tall > 10 | tall < 0) {
				System.out.printf("%c ikke er på mobil tastaturet. %n", bokstav);
			}
			else {
				System.out.printf("Numerisk verdi for %c er: %d %n ", bokstav, tall);
			}
			
		}
	}
}


