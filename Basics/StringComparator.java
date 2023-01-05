import java.util.Comparator;

public class StringComparator implements Comparator<String>, java.io.Serializable {
	  public int compare(String str1, String str2) {
		    str1 = str1.toUpperCase();
		    str2 = str2.toUpperCase();
		    
		    if (str1.compareTo(str2) < 0)
		      return -1;
		    else if (str1.compareTo(str2) == 0)
		      return 0;
		    else
		      return 1;
		  }
}
