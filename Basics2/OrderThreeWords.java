import java.util.Scanner;

public class OrderThreeWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.print("Skriv inn første ord: ");
			String ord1 = input.next();
			System.out.print("Skriv inn andre ord: ");
			String ord2 = input.next();
			System.out.print("Skriv inn tredje ord: ");
			String ord3 = input.next();
			if (ord1.compareTo(ord2) > 0) {
				String temp = ord1;
				ord1 = ord2;
				ord2 = temp;
			}
			if (ord1.compareTo(ord3) > 0) {
				String temp = ord1;
				ord1 = ord3;
				ord3 = temp;
			}
			if (ord2.compareTo(ord3) > 0) {
				String temp = ord2;
				ord2 = ord3;
				ord3 = temp;
			}
			System.out.printf("3 ord i alfabetisk rekkefølge er: %s, %s, %s %n",
					ord1, ord2, ord3);
		}
		
	}

}
