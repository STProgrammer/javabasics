public class BankTest {
	private static final boolean DEBUG = true;
	private static final int ACCOUNT_AMOUNT = 10;
	private static final int INITIAL_BALANCE = 100000;
	
	public BankTest() {};
	
	public static void main(String[] args) {
		Bank b = new Bank(ACCOUNT_AMOUNT, INITIAL_BALANCE, DEBUG);
		int i;
		for (i = 0; i < ACCOUNT_AMOUNT; i++) {
			AccountThread t = new AccountThread(b, i,
					INITIAL_BALANCE, DEBUG);
			t.setPriority(Thread.NORM_PRIORITY + i % 2);
			t.start();
		}
	}
}