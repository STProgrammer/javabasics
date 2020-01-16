public class Test {
  public static Object max(Object o1, Object o2) {
	Object o3 = (Comparable)o1;
	Object o4 = (Comparable)o2;
    if ((Comparable)o1.compareTo((Comparable)o2) >= 0) {
      return o1;
    } else {
      return o2;
    }
  }
  public static void main(String args[]) {
	  Object o1 = new Object();
	  Object o2 = new Object();
	  
	  max(o1, o2);
  }
}