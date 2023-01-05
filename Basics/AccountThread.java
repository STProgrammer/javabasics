import java.util.Random;
/**Det står AccountThreads på UML diagrammet, men AccountThread.java som skal innleveres.
 * Fra beskrivelsen av oppgaven og koden ser det ut som klassen skal kjøre bare en tråd.
 * Derfor gav jeg navnet AccountThread og klassen kjører bare en tråd av gangen.
 */

class AccountThread extends Thread {
  private Bank bank;
  private boolean debug;
  private int accountIndex;
  private int maxTransferAmount;
  private Random random;

  public AccountThread(Bank b, int index, int max, boolean debug) {
    this.bank = b;
    this.accountIndex = index;
    this.maxTransferAmount = max;
    this.debug = debug;
    this.random = new Random();
  }

  public void run() {
    try {
      while (!interrupted()) {
        for (int i = 0; i < maxTransferAmount; i++) {
        	int toAccount = random.nextInt(bank.nrOfAccounts());
        	int amount = random.nextInt(maxTransferAmount);
        	bank.transfer(accountIndex, toAccount, amount);
        	sleep(2);
        }
      }
    } catch (InterruptedException ignored) {
    }
  }
}