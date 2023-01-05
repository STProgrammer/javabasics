import java.util.ArrayList;
import java.util.Arrays;


public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String[] str = {"a","a","a","g","g","w","r","s","s"};
	    ArrayList<String> strings1 = new ArrayList<>(Arrays.asList(str));
	    
		ArrayList<String> strings2 = removeDuplicates(strings1);
		
		System.out.println(strings2);

	}
	
	public static <E> ArrayList <E> removeDuplicates(ArrayList<E> list) {
		ArrayList<E> newList = new ArrayList<>();
		
		for (E e: list) {
			if (!newList.contains(e))
				newList.add(e);
		}
		
		return newList;
	}

}
