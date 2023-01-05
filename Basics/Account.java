import java.util.concurrent.locks.*;

class Account {
  private int balance;
  private int accountNumber;
  private Lock lock;
  private Condition lockCondition;

  public Account(int accountNumber, int balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.lock = new ReentrantLock();
    this.lockCondition = lock.newCondition();
  }

  void withdraw(int amount) {
      lock.lock(); // Acquire the lock
      try {
        while (balance < amount) {
          lockCondition.await();
        }
        balance -= amount;
      }
      catch (InterruptedException ex) {
        ex.printStackTrace();
      }
      finally {
        lock.unlock(); // Release the lock
      }
  }

  void deposit(int amount) {
      lock.lock(); // Acquire the lock
      try {
        balance += amount;
        // Signal thread waiting on the condition
        lockCondition.signalAll();
      }
      finally {
        lock.unlock(); // Release the lock
      }
  }

  int getAccountNumber() {
    return accountNumber;
  }

  public int getBalance() {
    return balance;
  }
  
  Lock getLock() {
	  return lock;
  }
}