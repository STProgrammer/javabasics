import java.util.Date;
import java.util.ArrayList;

public class Transaction {
	private Date dateMade;
	private char type;
	private double amount;
	private double balance;
	private String description;
	
	public Transaction(char type, double amount, 
			String description, double balance) {
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.description = description;
		this.dateMade = new Date();
	}
	
	public Date getDateMade() {
		return dateMade;
	}
	public char getType() {
		return type;
	}
	public double getAmount() {
		return amount;
	}
	public double getBalance() {
		return balance;
	}
	public String getDescription() {
		return description;
	} // end get() methods
	
	public String toString() {
		return String.format("%tF %tT %5c %10.1f %10.1f %30s", 
				dateMade, dateMade, type, amount, balance, description);
	}
	

}
