import java.util.concurrent.locks.*;

public class Deadlock2 {
	public int commonNr;
	public static Deadlock2 x = new Deadlock2 ();
	public static A a = x.new A();
	public static B b = x.new B();
	
	public static void main (String args[]) {
		
		Thread threadA = new Thread(a);
		Thread threadB = new Thread(b);
		
			threadA.start();
			threadB.start();
	}
	
	class A implements Runnable {
		Lock lock = new ReentrantLock();
		
		public void run() {
			lock.lock();
			System.out.println("Object A locked in thread A");
			try { Thread.sleep(100); } catch (Exception ignored) { }
			System.out.println("Attempt to lock object B in thread A");
			b.getLock().lock();
			System.out.println("Object B locked in thread A");
			b.getLock().unlock();
			lock.unlock();
			System.out.println("Thread A finished");
		}
		
		public Lock getLock() {
			return lock;
		}
	}
	
	class B implements Runnable {
		Lock lock = new ReentrantLock();
		
		public void run() {
			lock.lock();
			System.out.println("Object B is locked in thread B");
			try { Thread.sleep(100); } catch (Exception ignored) { }
			System.out.println("Attempt to lock object A in thread B");
			a.getLock().lock();
			System.out.println("Object A is locked in thread B");
			a.getLock().unlock();
			lock.unlock();
			System.out.println("Thread B is finished");
		}
		
		public Lock getLock() {
			return lock;
		}
	}

}
