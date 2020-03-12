import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Collections;

public class AccountTry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double interest = 5.4;
		Account.setAnnualInterestRate(interest);
		
		Account accountOne = new Account("Hans Hansen", 2231, 100000, 
				new GregorianCalendar());
		Account accountTwo = new Account("John Johnsen", 2325, 100000, 
				new GregorianCalendar(1972, 5, 15, 14, 15, 45));
		Account accountThree = new Account("Per Tone", 1223, 50000,
				new GregorianCalendar(1972, 5, 15, 14, 15, 45));
		Account accountFour = new Account("Steffen Larsen", 0007, 50000,
				new GregorianCalendar());
		
		ArrayList<Account> accounts = new ArrayList<>();
		
		accounts.add(accountOne); accounts.add(accountTwo);
		accounts.add(accountThree); accounts.add(accountFour);
		
		Collections.sort(accounts);
		
		for (Account A: accounts) {
			System.out.println(A);
		}
		
/**
		Account anAccount = new Account("Jens Hansen", 1234, 15000, new GregorianCalendar());
		
		System.out.println(anAccount);
		
		anAccount.deposit(500, "Sausage sales");
		anAccount.deposit(600, "Cola sales");
		anAccount.deposit(500.3, "Cocoa sales");
		anAccount.withdraw(200, "Grocery items");
		anAccount.withdraw(20, "Bus ticket");
		anAccount.withdraw(8000, "Purchase of new computer");
		
		System.out.printf("%n%s %20s %10s %10s %30s %n", "Date", "Type", "Amount",
				"Balance", "Description");
		
		for (Transaction t: anAccount.getTransactions()) {
			System.out.println(t);
		}
**/
	}

}
