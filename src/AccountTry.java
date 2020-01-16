import java.util.Date;

public class AccountTry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date startDate = new Date();
		Account myAccount = new Account("Jens Hansen", 1234, 15000, startDate);
		double interest = 5.4;
		myAccount.setAnnualInterestRate(interest);
		
		System.out.println(myAccount);
		
		myAccount.deposit(500, "Sausage sales");
		myAccount.deposit(600, "Cola sales");
		myAccount.deposit(500.3, "Cocoa sales");
		myAccount.withdraw(200, "Grocery items");
		myAccount.withdraw(20, "Bus ticket");
		myAccount.withdraw(8000, "Purchase of new computer");
		
		System.out.printf("%n%s %20s %10s %10s %30s %n", "Date", "Type", "Amount",
				"Balance", "Description");
		
		for (Transaction t: myAccount.getTransactions()) {
			System.out.println(t);
		}

	}

}
