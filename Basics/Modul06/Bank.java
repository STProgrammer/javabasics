package Modul06;

import java.util.concurrent.locks.*;

/**
 * <h1>Bank class.</h1>
 * <br>
 * This class drives the main logistics behind the transactions. It takes
 * care of checking if multithreading works correctly by running tests and
 * printing out results to the console.
 *
 * @author Daniel Aaron Salwerowicz
 * @version 1.0
 * @since 2017-03-21
 */
public class Bank {

  /**
   * Defines frequency at which {@link Bank#toString()} is called.
   */
  private static final int TO_STRING_FREQUENCY = 100000;

  /**
   * Defines frequency at which {@link Bank#test()} is called.
   */
  private static final int TEST_FREQUENCY = 10000;

  /**
   * Locks bank when {@link Bank#transfer(int, int, int)} checks whether
   * {@link Bank#toString()} or {@link Bank#test()} should be called.
   *
   * @see Lock
   * @see ReentrantLock
   */
  private Lock lock = new ReentrantLock();

  /**
   * Counts number of transactions.
   */
  private long transactionCount;

  /**
   * Counts number of times total deviated from norm.
   */
  private int deviationCount;

  /**
   * Holds the value of {@link Account} initial balance
   */
  private int initialBalance;

  /**
   * Holds all of the {@link Account} objects in bank
   */
  private Account[] accounts;

  /**
   * Defines if {@link Bank#toString()} should be more verbose.
   */
  private boolean debug;

  /**
   * Counts number of tests run on this bank.
   */
  private int testCount;

  /**
   * Instantiates a new bank with given number of {@link Account}.
   *
   * @param accountAmount  Amount of {@link Account} objects this bank has.
   * @param initialBalance Initial balance for each {@link Account}.
   * @param debug          True if bank should run in debug mode.
   */
  public Bank(int accountAmount, int initialBalance, boolean debug) {
    accounts = new Account[accountAmount];
    this.initialBalance = initialBalance;
    this.debug = debug;

    for (int i = 0; i < accounts.length; i++) {
      accounts[i] = new Account(i, initialBalance);
    }
  }

  /**
   * Transfers given amount of money from one account to the other.
   * Access is set to package-private.
   *
   * @param fromAccount Account from which money are withdrawn.
   * @param toAccount   Account to which money are deposited.
   * @param amount      Amount of money transferred between accounts.
   */
  void transfer(int fromAccount, int toAccount, int amount) {
    lock.lock();

    transactionCount++;

    if (transactionCount % TO_STRING_FREQUENCY == 0) {
      System.out.println("\n**********************************************************************");
      System.out.println(toString());
      System.out.println("**********************************************************************\n");
    } else if (transactionCount % TEST_FREQUENCY == 0) {
      test();
    }

    lock.unlock();

    accounts[fromAccount].withdraw(amount);
    accounts[toAccount].deposit(amount);
  }

  /**
   * Tests whether total balance matches proper value. Prints out number of transactions,
   * balance and deviation count to console.
   */
  private void test() {
    testCount++;
    int total = 0;

    for (Account account : accounts) account.getLock().lock();
    for (Account account : accounts) total += account.getBalance();
    for (Account account : accounts) account.getLock().unlock();

    if (total != (accounts.length * initialBalance)) deviationCount++;

    System.out.printf("Transaction count: %7d Total balance: %7d Deviation count: %3d\n",
        getTransactionCount(), total, getDeviationCount());
  }

  /**
   * Gathers all relevant information about this bank and formats it into a string.
   * If {@link Bank#debug} is set to true then balance for each account is included.
   *
   * @return String representing this bank object.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    int totalBalance = 0;

    sb.append(String.format("Number of bank clients:\t%10d\n", numberOfAccounts()));
    sb.append(String.format("Number of transactions:\t%10d\n", getTransactionCount()));
    sb.append(String.format("Number of deviations:\t%10d\n", getDeviationCount()));
    sb.append(String.format("Deviation percentage:\t%10.1f\n", getErrorPercentage()));

    for (Account account : accounts) account.getLock().lock();
    for (Account account : accounts) {
      if (debug) {
        sb.append(String.format("Account #%2d balance:\t%10d\n",
            account.getAccountNumber(), account.getBalance()));
      }
      totalBalance += account.getBalance();
    }
    for (Account account : accounts) account.getLock().unlock();

    sb.append(String.format("Total balance in bank:\t%10d", totalBalance));

    return sb.toString();
  }

  /**
   * Returns number of {@link Account} in bank. Access is set to package-private.
   *
   * @return number of Accounts in bank.
   */
  int numberOfAccounts() {
    return accounts.length;
  }

  /**
   * Gets amount of transactions in bank.
   *
   * @return Amount of transactions in bank.
   */
  private long getTransactionCount() {
    return transactionCount;
  }

  /**
   * Gets amount of deviations from expected total.
   *
   * @return Amount of deviations from total.
   */
  private int getDeviationCount() {
    return deviationCount;
  }

  /**
   * Gets error percentage, calculated based on number of tests vs. deviations from expected total.
   *
   * @return Deviation error in percents.
   */
  private double getErrorPercentage() {
    return ( double ) deviationCount / testCount * 100;
  }
}