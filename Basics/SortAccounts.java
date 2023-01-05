import helperObjects.Account;


import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

public class SortAccounts {

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

	}

}
