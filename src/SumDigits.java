import java.util.Scanner;

public class SumDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		while (true) {
			System.out.print("Oppgi et tall mellom 0 og 999: ");
			int tall = input.nextInt();
			int sumSiffer = (tall / 100) + ((tall % 100) / 10) + 
					(tall % 10);
			System.out.printf("Summen av siffer i %d blir %d %n", tall, sumSiffer);
		}
	}
}
