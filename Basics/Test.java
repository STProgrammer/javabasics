import java.util.*;

public class Test extends Thread {
  public static void main(String[] args) {
	  
	  Test test = new Test();
	  
	  test.start();
	  
	  
}

  public void run() {
    for(;;) {
      // CODE GOES HERE
      System.out.printf("%tT %n", new Date());
      try { Thread.sleep(1000); } catch(InterruptedException e) { } 
    }
  }
}