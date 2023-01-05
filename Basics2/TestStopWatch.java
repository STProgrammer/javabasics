
public class TestStopWatch {

	public static void main(String[] args) {
		StopWatch time1 = new StopWatch();
		StopWatch time2 = new StopWatch();
		
		final int NUMBER_OF_PRIMES = 30000;
		int count = 0;
		long number = 1;
		
		time1.start();
		while (count <= NUMBER_OF_PRIMES) {
			if (isPrimeBad(number++)) count++;
		}
		time1.end();
		
		number = 1;
		count = 0;
		
		time2.start();
		while (count <= NUMBER_OF_PRIMES) {
			if (isPrimeGood(number++)) count++;
		}
		time2.end();
		
		String text = new String("Time to find 30000 prime numbers with");
		
		System.out.printf("%s isPrimeBad is %10d nanoseconds %n", 
				text, time1.getElapsedTime());
		
		System.out.printf("%s isPrimeGood is %10d nanoseconds %n", 
				text, time2.getElapsedTime());
		
	}
	private static boolean isPrimeBad(long number) {
		for (int divisor = 2; divisor <= number / 2; divisor++) {
			if (number % divisor == 0) {
				return false;
				}
			}
		return true;
		}
	
	private static boolean isPrimeGood(long number) {
		if (number == 2) return true;
		if (number % 2 == 0 || number == 1) {
			return false;
		}
		double max = Math.sqrt(number);
		for (int divisor = 3; divisor <= max; divisor += 2) {
			if (number % divisor == 0) {
				return false;
				}
			}
		return true;
		}
	
}

class StopWatch {
	private long startTime, endTime;
	public StopWatch() {
		
	}
	
	public void start() {
		startTime = System.nanoTime();
	}
	public void end() {
		endTime = System.nanoTime();
	}
	public long getElapsedTime() {
		return endTime - startTime;
	}
	
	
}