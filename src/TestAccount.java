import java.util.GregorianCalendar;


public class TestAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account2 account = new Account2(1122, 2000);
		System.out.printf("Withdrawing 2500 USD from account, status: %s",
				account.withdraw(2500) ? "succeed\n" : "failed\n");
		System.out.printf("Depositing 3000 to account, status: %s" , 
				account.deposit(3000) ? "succeed\n" : "failed\n");
		account.setAnnualInterstRate(4.5);
		System.out.printf("The balance is: %.2f USD %n", account.getBalance());
		System.out.printf("The monthly interest is: %.2f USD %n", 
				account.getMonthlyInterst());
		System.out.printf("The account was established in %s", 
				account.getDateSetup().getTime());
	}

}

class Account2 {
	private int id;
	private double balance; 
	private static double annualInterestRate;
	private GregorianCalendar dateSetup;
	public Account2(int id, double balance) {
		this.id = id;
		this.balance = balance;
		dateSetup = new GregorianCalendar();
	}
	public int getId() {
		return id;
	}
	public double getBalance() {
		return balance;
	}
	public GregorianCalendar getDateSetup() {
		return dateSetup;
	}
	public static double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterstRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	public double getMonthlyInterst() {
		return balance * (annualInterestRate / 1200);
	}
	public boolean withdraw(double amount) {
		if (amount >= 0 && amount <= balance) {
			balance = balance - amount;
			return true;
		} else return false;
		
	}
	public boolean deposit(double amount) {
		if (amount >= 0) {
			balance = balance + amount;
			return true;
		} else return false;
	}
}
	

