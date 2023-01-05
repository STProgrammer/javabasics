import java.util.Scanner;

public class EkteBroek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.print("Oppgi teller: ");
			int teller = input.nextInt();
			System.out.print("Oppgi nevner: ");
			int nevner = input.nextInt();
			if (teller < nevner) {
				/*kode for å forkorte brøk:*/
				int teller2 = teller;
				int nevner2 = nevner;
				int i = 2;
				while (i <= teller2) {
				    while (teller2 % i == 0 && nevner2 % i == 0) {
			            teller2 = teller2 / i;
			            nevner2 = nevner2 / i;
			        }
				    if (i == 2) {
				    	i += 1;
				    } else i += 2;
				}
				System.out.printf(" %d / %d er ekte brøk %n", teller, nevner);
				System.out.printf("Kan skrives som %d / %d %n", 
						teller2, nevner2);
			}
			else if (teller % nevner == 0) {
				System.out.printf("%d / %d er en uekte brøk %n", teller, nevner);
				System.out.printf("%d / %d kan reduseres til %d %n", teller, nevner, 
						(teller/nevner));
			}
			else if (teller % nevner != 0) {
				System.out.printf("%d / %d er en uekte brøk %n", teller, nevner);
				/*kode for å forkorte brøk:*/
				int teller2 = (teller % nevner);
				int nevner2 = nevner;
				int i = 2;
				while (i <= teller2) {
				    while (teller2 % i == 0 && nevner2 % i == 0) {
			            teller2 = teller2 / i;
			            nevner2 = nevner2 / i;
			        }
				    if (i == 2) {
				    	i += 1;
				    } else i += 2;
				}
				System.out.printf("%d / %d er et blandet tall %n", teller, nevner);
				System.out.printf("Kan skrives som %d + %d / %d %n", 
						(teller/nevner), teller2, nevner2);
			}
		}

	}

}
