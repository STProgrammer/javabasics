import java.util.concurrent.locks.*;

class Bank {
  private static final int TEST_FREQUENCY = 10000;
  private static final int TO_STRING_FREQUENCY = 10000;
  private Lock lock;
  private int deviationCount;
  private int initialBalance;
  private Account[] accounts;
  private long transactionCount;
  private boolean debug;
  private int testCount;
  

  public Bank(int accountAmount, int initialBalance, boolean debug) {
	accounts = new Account[accountAmount];
	this.initialBalance = initialBalance;
	this.debug = debug;
	int i;
	for (i = 0; i < accounts.length; i++)
	  accounts[i] = new Account(i, initialBalance);
	this.transactionCount = 0;
	this.deviationCount = 0;
	this.lock = new ReentrantLock();
  }

  public void transfer(int fromAccount, int toAccount, int amount) {
	  accounts[fromAccount].withdraw(amount);
	  accounts[toAccount].deposit(amount);
	 
	  
//	  for (Account account: accounts) {account.getLock().lock();} 
	  lock.lock();
	  this.transactionCount++;
	  try {
		  if (transactionCount % TEST_FREQUENCY == 0) {
			  test();
		  }
		  if (transactionCount % TO_STRING_FREQUENCY == 0) {
			  System.out.println(toString());
		  }
	  } finally {
          lock.unlock();
      }
//	  for (Account account: accounts) {account.getLock().unlock();}
  }

  public void test() {
    int sum = 0;
    for (Account account : accounts) {account.getLock().lock(); }
    for (Account account : accounts) {sum += account.getBalance(); }
    for (Account account : accounts) {account.getLock().unlock(); }
    
    if (sum != nrOfAccounts()*initialBalance) {deviationCount++; }
    
    System.out.println("Transactions:" + getTransactionCount() + " Balance: " + sum
    		+ " Deviation count: " + getDeviationCount());
    testCount++;
  }
  
  @Override
  public String toString() {
	  String string = String.format("\nTransactions; %d%n"
	  		+ "Initial balance: %d%nNumber of accounts: %d%n"
	  		+ "Deviation count: %d%nTestCount: %d%n"
	  		+ "Error percentage: %.2f%n", 
	  		getTransactionCount(), initialBalance, nrOfAccounts(), 
	  		getDeviationCount(), testCount, getErrorPercentage());
	  if (debug) {
		  for (Account account :accounts) {
			  string = string.concat(String.format("Account nr.: %d, Balance: %d%n", 
					  account.getAccountNumber(), account.getBalance()));
		  }
	  }
	  return string;
  }

  int nrOfAccounts() {
    return accounts.length;
  }
  
  private long getTransactionCount() {
	  return transactionCount;
  }
  
  private int getDeviationCount() {
	  return deviationCount;
  }
  
  private double getErrorPercentage() {
	  double dividend = getDeviationCount();
	  double divisor = testCount;
	  double result = dividend / divisor;
	  return result;
  }
}