import java.util.Scanner;

public class CharToNumber2 {
		
	public static void main(String[] args) {
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
			int tall = 0;
			int temp = (int)bokstav - 64;
			switch (temp) {
			case -32:
				tall = 0;
				break;
			case -22:
				tall = 15;
				break;
			case -29:
				tall = 15;
				break;
			case 1:
			case 2:
			case 3:
				tall = 2;
				break;
			case 4:
			case 5:
			case 6:
				tall = 3;
				break;
			case 7:
			case 8:
			case 9:
				tall = 4;
				break;
			case 10:
			case 11:
			case 12:
				tall = 5;
				break;
			case 13:
			case 14:
			case 15:
				tall = 6;
				break;
			case 16:
			case 17:
			case 18:
			case 19:
				tall = 7;
				break;
			case 20:
			case 21:
			case 22:
				tall = 8;
				break;
			case 23:
			case 24:
			case 25:
			case 26:
				tall = 9;
				break;
			default:
				tall = 10;
			}
			if (tall == 15) {
				System.out.printf("%c har ikke et responderende tall. %n", bokstav);
			}
			else if (tall == 10) {
				System.out.printf("%c er ikke på tastaturet.", bokstav);
			}
			else if (tall == 0) {
				System.out.printf("Numerisk verdi for [mellomrom] er: %d %n", tall);
			}
			else {
				System.out.printf("Numerisk verdi for %c er: %d %n", bokstav, tall);
			}
			
		}
	}
}