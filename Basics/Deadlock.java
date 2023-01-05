public class Deadlock {
  private final Object object1 = new Object();
  private final Object object2 = new Object();

  public static void main(String[] args) {
    new Deadlock();
  }

  public Deadlock() {
    new Thread1().start();
    new Thread2().start();
  }

  class Thread1 extends Thread {
    public void run() {
      synchronized (object1) {
        System.out.println("Locked object1 in Thread1");

        try { Thread.sleep(100); } catch (Exception ignored) { }

        System.out.println("Attempt to lock object2 in Thread1");

        synchronized (object2) {
          System.out.println("Locked object2 in Thread1");
        }
      }
    }
  }

  class Thread2 extends Thread {
    public void run() {
      synchronized (object2) {
        System.out.println("Locked object2 in Thread2");

        try { Thread.sleep(100); } catch (Exception ignored) { }

        System.out.println("Attempt to lock object1 in Thread2");

        synchronized (object1) {
          System.out.println("Locked object1 in Thread2");
        }
      }
    }
  }
}