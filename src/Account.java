import java.util.ArrayList;
import java.util.Date;

public class Account  {
	// legg inn en referanse til en ArrayList av Transaction objekter
	private static double annualInterestRate;
	private double balance;
	private Date dateBuilt;
	private int id;
	private String name;
	ArrayList<Transaction> transactions;
	
	public Account(Date dateCreated) {
		this.dateBuilt = dateCreated;
		this.transactions = new ArrayList<>();
	}
	
	public Account(String name, int id, double balance, Date dateBuilt) {
		this.name = name;
		this.id = id;
		this.balance = balance;
		this.dateBuilt = dateBuilt;
		this.transactions = new ArrayList<>();
		// opprett arraylist av Transaction objekter
	}
	
	public ArrayList<Transaction> getTransactions() {
		return transactions;}
	
	public Date getDateBuilt() {return dateBuilt;}
	
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
	
	/*public String getTransactions() {
		int size = transactions.size();
		String summary = String.format("Name: %s %nAnnual Interest Rate: %.2f Balance: %.2f, %n%s %2s %10s %10s %10s", name, 
				annualInterestRate, balance, "Date", "Type", "Amount", 
				"Balance", "Description");
		System.out.println(summary);
		String transact = "";
		for(int i = 0; i < size; i++) {
			transact += transactions.get(i).toString();
		}
		summary = summary + transact;
		return summary;
	}*/
		
	@Override
	public String toString() {
		return String.format("Name: %s, %nID: %d %nAnnual Interest Rate: %.1f"
				+ "%nBalance: %.1f"
				+ "%nDate established: %tF %tT", name, 
				id, annualInterestRate, balance, dateBuilt, dateBuilt);
	}
	
}