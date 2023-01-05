import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArraySearch {
	
	private int number = 1000000;
	private int nrOfThreads = 10;
	private int[] array = new int[number];
	private int[] startValues = new int[nrOfThreads];
	private int[] endValues = new int[nrOfThreads];
	private int foundIndex = -1;
	private int findingThread = -1;
	private boolean running = true;
	private ExecutorService pool = Executors.newCachedThreadPool();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ArraySearch();

	}
	
	public ArraySearch() {
		init();
		runThreads();
		System.out.printf("Thread nr %d: %d is on index %d", findingThread, number, foundIndex);
	}
	
	
	private void init() {
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		for (int i = 0; i < nrOfThreads; i++) {
			int index = (int)(Math.random()*number);
			array[index] = number;
		}
		int size = number / nrOfThreads;
		startValues[0] = 0;
		endValues[nrOfThreads - 1] = number-1;
		
		for (int i = 0; i < nrOfThreads - 1; i++) {
			startValues[i + 1] = startValues[i] + size;
			endValues[i] = startValues[i + 1] - 1;
		}
	}
	
	private void runThreads() {
		try {
			for (int i = 0; i < nrOfThreads && !pool.isShutdown(); i++) {
				ArraySearchTask thread = new ArraySearchTask(startValues[i],
						endValues[i], number, i);
				pool.execute(thread);
			}
			pool.shutdown();
			pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
	}
	
	private synchronized void numberFound(int index, int threadNr) {
		this.foundIndex = index;
		this.findingThread = threadNr;
		this.running = false;
	}
	
	
	/**ArraySearchTask class */
	private class ArraySearchTask implements Runnable {
		private int number;
		private int startValue;
		private int endValue;
		private int threadNr;
		
		
		public ArraySearchTask(int startValue, int endValue, int number, int threadNr) {
			this.number = number;
			this.startValue = startValue;
			this.endValue = endValue;
			this.threadNr = threadNr;
		}
		
		public void run() {
			int i = startValue;
			do {
				if (array[i] == number) {
					numberFound(i, threadNr);
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				i++;
			} while (running && i <= endValue);
			
		}	
	}
}
