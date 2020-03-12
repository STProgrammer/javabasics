import java.util.*;


public class Test {

    public static void main(String[] args) {
    	int nr = 1;
    	ArrayList list = new ArrayList();
    	String string = new String("A");
    	Object [] elements = new Object[10];
    	elements[1] = new Triangle(5, 2, 5);
    	System.out.println(elements[1]);
    	int[] numbers = {1, 2, 3};
    	numbers[--nr] = 7;
  
    	

    	
    	System.out.println(java.util.Arrays.toString(elements));
    	
    	list.add(string);
    	
    	testMethodTwo(list);
    	nr = testMethod(nr);
    	System.out.println(nr);
    	
    	
    }
    
    public static int testMethod(int nr) {
    	return nr;
    }
    
    public static void testMethodTwo(ArrayList<String> list) {
    	System.out.println(list.toString());
    }
}