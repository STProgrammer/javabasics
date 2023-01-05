package Modul06;

import java.util.Random;

/**
 * <h1>AccountThreads class.</h1>
 * <br>
 * This class extends {@link Thread} class and uses its run method to find a random account,
 * random amount to transfer and then waiting for a bit before executing another transaction.
 *
 * @author Daniel Aaron Salwerowicz
 * @version 1.0
 * @since 2017-03-21
 */
public class AccountThreads extends Thread {

  /**
   * Reference to the {@link Bank} object used in transactions.
   */
  private Bank bank;

  /**
   * Defines if {@link AccountThreads#run()} method should run faster.
   */
  private boolean debug;

  /**
   * Defines index for {@link Account} in {@link Bank} that this thread is running
   * transactions for.
   */
  private int accountIndex;

  /**
   * Defines maximum transfer amount.
   */
  private int maxTransferAmount;

  /**
   * Used to generate random numbers for waiting time and transaction amounts.
   *
   * @see Random
   */
  private Random random = new Random(System.nanoTime());

  /**
   * Instantiates a new AccountThreads object.
   *
   * @param bank              Reference to bank object.
   * @param accountIndex      Account index in bank that this thread is running transactions for.
   * @param maxTransferAmount Maximum transfer amount.
   * @param debug             True if transactions should happen faster, used in debugging.
   */
  public AccountThreads(Bank bank, int accountIndex, int maxTransferAmount, boolean debug) {
    this.bank = bank;
    this.debug = debug;
    this.accountIndex = accountIndex;
    this.maxTransferAmount = maxTransferAmount;
  }

  /**
   * Transfers money from this account to other accounts and then waits for 2 milliseconds if
   * {@link AccountThreads#debug} is set to true, random amount of milliseconds otherwise.
   */
  public void run() {
    try {
      while (!interrupted()) {
        bank.transfer(
            accountIndex,
            random.nextInt(bank.numberOfAccounts()),
            random.nextInt(maxTransferAmount));

        sleep(debug ? 2 : random.nextInt(11));
      }
    } catch (InterruptedException ignored) {
    }
  }
}