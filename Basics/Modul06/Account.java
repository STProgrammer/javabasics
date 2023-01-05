package Modul06;

import java.util.concurrent.locks.*;

/**
 * <h1>Account class.</h1>
 * <br>
 * This class is used to represent a bank account. It uses {@link ReentrantLock}
 * and {@link Condition} in order to avoid problems associated with multithreading.
 *
 * @author Daniel Aaron Salwerowicz
 * @version 1.0
 * @since 2017-03-21
 */
public class Account {

  /**
   * Represents balance for this account.
   */
  private int balance;

  /**
   * Represents account number for this account.
   */
  private int accountNumber;

  /**
   * Locks account for deposits and withdraws.
   *
   * @see Lock
   * @see ReentrantLock
   */
  private Lock lock = new ReentrantLock();

  /**
   * Used to wait for new deposit when balance is lower than the withdraw amount.
   *
   * @see Condition
   */
  private Condition lockCondition = lock.newCondition();

  /**
   * Instantiates a new Account object.
   *
   * @param accountNumber This accounts number.
   * @param balance       The initial balance for this account.
   */
  public Account(int accountNumber, int balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  /**
   * Withdraws money from this account. It uses {@link ReentrantLock} in order to
   * lock this account before trying to withdraw money from the bank account.
   * If withdrawal amount is greater than balance it uses {@link Condition#await()}
   * to wait until someone deposits money to this account.
   *
   * @param amount Amount of money to be withdrawn.
   */
  void withdraw(int amount) {
    lock.lock();

    try {
      while (balance - amount < 0) {
        lockCondition.await();
      }
      balance -= amount;
    } catch (InterruptedException ignored) {
    } finally {
      lock.unlock();
    }
  }

  /**
   * Deposits money to this account. It uses {@link ReentrantLock} in order to
   * lock this account before trying to deposit money to this bank account. It uses
   * {@link Condition#signalAll()} to signal other threads that a deposit was made.
   *
   * @param amount Amount of money to be deposited.
   */
  void deposit(int amount) {
    lock.lock();

    balance += amount;
    lockCondition.signalAll();

    lock.unlock();
  }

  /**
   * Gets this accounts number/index in {@link Bank}.
   *
   * @return Account number.
   */
  int getAccountNumber() {
    return accountNumber;
  }

  /**
   * Gets this accounts balance.
   *
   * @return Balance for this account.
   */
  public int getBalance() {
    return balance;
  }

  /**
   * Gets lock object for this account.
   *
   * @return Lock object for this account.
   * @see Lock
   * @see ReentrantLock
   */
  Lock getLock() {
    return lock;
  }
}