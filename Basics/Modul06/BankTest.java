package Modul06;

/**
 * <h1> BankTest class.</h1>
 * <br>
 * This class starts the test with predefined values by creating new thread
 * for each {@link Account}.
 *
 * @author Daniel Aaron Salwerowicz
 * @version 1.0
 * @since 2017-03-21
 */
public class BankTest {

  /**
   * If true it runs the test faster and it prints out more data to console.
   */
  private static final boolean DEBUG = true;

  /**
   * Defines amount of {@link Account} objects in {@link Bank}.
   */
  private static final int ACCOUNT_AMOUNT = 100;

  /**
   * Defines initial balance for each {@link Account} object in {@link Bank}.
   */
  private static final int INITIAL_BALANCE = 10000;

  /**
   * It sets up the test and runs it.
   *
   * @param args Command line arguments, in this case they are ignored.
   */
  public static void main(String[] args) {
    Bank bank = new Bank(ACCOUNT_AMOUNT, INITIAL_BALANCE, DEBUG);

    System.out.printf("Testing synchronized bank with %d %s.\n",
        bank.numberOfAccounts(), bank.numberOfAccounts() == 1 ? "account" : "accounts");

    for (int i = 0; i < ACCOUNT_AMOUNT; i++) {
      AccountThreads t = new AccountThreads(bank, i, INITIAL_BALANCE, DEBUG);

      // Give threads different priorities.
      t.setPriority(Thread.NORM_PRIORITY + i % 2);

      // Start threads.
      t.start();
    }
  }
}