package helperObjects;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Account implements Comparable<Account> {
	// legg inn en referanse til en ArrayList av Transaction objekter
	private static double annualInterestRate;
	private double balance;
	private GregorianCalendar dateBuilt;
	private int id;
	private String name;
	ArrayList<Transaction> transactions;
	
	public Account(GregorianCalendar dateEstablished) {
		this.dateBuilt = dateEstablished;
		this.transactions = new ArrayList<>();
	}
	
	public Account(String name, int id, double balance, GregorianCalendar dateBuilt) {
		this.name = name;
		this.id = id;
		this.balance = balance;
		this.dateBuilt = dateBuilt;
		this.transactions = new ArrayList<>();
		// opprett arraylist av Transaction objekter
	}
	
	/** get and set methods */
	public ArrayList<Transaction> getTransactions() {
		return transactions;}
	
	public GregorianCalendar getDateBuilt() {return dateBuilt;}
	
	public double getBalance() {return balance;}
	
	public String getName() {return name;}
	
	public int getID() {return id;}
	
	public void setBalance(double balance) {this.balance = balance;}
	
	public void setID(int id) {this.id = id;}
	
	public static double getAnnualInterestRate() {return annualInterestRate;}
	
	public double getMonthlyInterest() {
	    return balance * (annualInterestRate / 1200);
	}
	
	public static void setAnnualInterestRate(double newAnnualInterestRate) {
	    annualInterestRate = newAnnualInterestRate;
	  }
	// Withdraw
	public void withdraw(double amount, String description) {
		this.balance -= amount;
		transactions.add(new Transaction('W', amount, description, 
				this.balance));
	}
	// Deposit
	public void deposit(double amount, String description) {
		this.balance += amount;
		transactions.add(new Transaction('D', amount, description,
				this.balance));
	}
	
	/** Compare two accounts */
	@Override
	public int compareTo(Account otherAccount) {
		if (getBalance() > otherAccount.getBalance()) {
			return 1;
		}
		else if (getBalance() < otherAccount.getBalance()) {
			return -1;
		} else {
			return getDateBuilt().compareTo(otherAccount.getDateBuilt());
		}
			
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s, %nID: %d %nAnnual Interest Rate: %.1f"
				+ "%nBalance: %.1f"
				+ "%nDate established: %tF %tT", name, 
				id, annualInterestRate, balance, dateBuilt, dateBuilt);
	}
	
}