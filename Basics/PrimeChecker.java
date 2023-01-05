import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PrimeChecker {
	
	private ExecutorService pool = Executors.newCachedThreadPool();
	private boolean isPrime = true;
	private long number = 9223372036854775783L;
	private int numberOfThreads = 10;
	private long[] startValues = new long[numberOfThreads];
	private long[] endValues = new long[numberOfThreads];
	
	public PrimeChecker() {
		System.out.printf("Checking if %d is a prime number, multithreaded.%n%n", number);
		long startTime = System.currentTimeMillis();
		init();
		runThreads();
		long endTime = System.currentTimeMillis();
		System.out.printf("%d is %s prime number.%n", number, isPrime ? "a":"not a");
		System.out.printf("Execution time: %d ms%n%n", endTime - startTime);
		
		System.out.printf("Checking if %d is a prime number, singlethreaded.%n", number);
		startTime = System.currentTimeMillis();
		boolean result = singlethreadedPrimeCheck();
		endTime = System.currentTimeMillis();
		System.out.printf("%d is %s prime number.%n", number, result ? "a":"not a");
		System.out.printf("Execution time: %d ms%n", endTime - startTime);
		
	}
	
	public static void main(String[] args) {
		new PrimeChecker();
		// TODO Auto-generated method stub

	}
	
	private void init() {
		long rooted = (long)Math.ceil(Math.sqrt(number));
		long size = rooted / numberOfThreads;
		startValues[0] = 3;
		endValues[numberOfThreads-1] = rooted;
		for (int i = 0; i < numberOfThreads-1; i++) {
			startValues[i+1] = startValues[i] + size;
			endValues[i] = startValues[i+1] - 1;
		}		
		
	}
	
	private void runThreads() {
		try {
			for (int i = 0; i < numberOfThreads && !pool.isShutdown(); i++) {
				PrimeTask thread = new PrimeTask(startValues[i],
						endValues[i], number);
				pool.execute(thread);
			}
			pool.shutdown();
			pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private synchronized void notPrime() {
		this.isPrime = false;
	}
	
	private boolean singlethreadedPrimeCheck() {
		isPrime = true; //set it back to true if it was false
		long rooted = (long)Math.ceil(Math.sqrt(number));
		try {
			PrimeTask task = new PrimeTask(3, rooted, number);
			Thread thread = new Thread(task);
			thread.start();
			thread.join(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return isPrime;
	}
	
	
	/**PrimeTask class*/
	private class PrimeTask implements Runnable {
		long number;
		long startValue;
		long endValue;
		
		public PrimeTask(long startValue, long endValue, long number) {
			this.number = number;
			this.startValue = startValue;
			this.endValue = endValue;
		}
		
		
		public void run() {
			if (number == 1 || number == 0 || number % 2 == 0) {
				notPrime();
			}
			long num = (startValue % 2 == 0) ? startValue + 1: startValue;
			
			while(isPrime && num <= endValue) 
			{	
				if (number % num == 0) {
					notPrime();
				}
				num += 2;
			}
		}
	}

}
