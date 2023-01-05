import java.util.Scanner;
import java.lang.Math;

public class DagerIMaaneden {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.print("År: ");
			int aar = 0;
			try {
				aar = input.nextInt();
				if (aar < 0 || aar > 9999) {
					System.out.println("Nummere må være mellom 0 og 9999");
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println("Ugyldig input.");
				System.exit(0);
			}
			System.out.print("Måned (bare 3 tegn): ");
			input.nextLine();
			String mnd = new String();
			try {
				mnd = input.nextLine();
				if (mnd.length() != 3) {
					System.out.println("Måned skal være bare 3 tegn.");
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println("Ugyldig input.");
				System.exit(0);
			}
			mnd = mnd.toLowerCase();
		 int antallDager = 0;
				switch (mnd) {
				case "jan":
					antallDager = 31;
					break;
				case "feb":
					if (aar % 4 == 0 & (aar % 100 != 0 | aar % 400 == 0)) {
						antallDager = 29;
					}
					else {
						antallDager = 28;
					}
					break;
				case "mar":
					antallDager = 31;
					break;
				case "apr":
					antallDager = 30;
					break;
				case "mai":
					antallDager = 31;
					break;
				case "jun":
					antallDager = 30;
					break;
				case "jul":
					antallDager = 31;
					break;
				case "aug":
					antallDager = 31;
					break;
				case "sep":
					antallDager = 30;
					break;
				case "okt":
					antallDager = 31;
					break;
				case "nov":
					antallDager = 30;
					break;
				case "des":
					antallDager = 31;
					break;
				}
				
			System.out.println("Det er " + antallDager + " dager i måneden.");
		}
	}
}
