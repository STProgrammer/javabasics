public class TriangleExtraTest {
	public static void main(String[] args) {
	    try {
	        TriangleExtra tr1 = new TriangleExtra(5);
	        TriangleExtra tr2 = new TriangleExtra(1000, 1, 1);
	        TriangleExtra tr3 = new TriangleExtra(-5, 5, 5);
	        TriangleExtra tr4 = new TriangleExtra(2, 5, 4);
	    }   catch (IllegalTriangleException ex) {
	        System.out.println(ex);
	    }

	      System.out.println("Number of objects constructed: " +
	        TriangleExtra.getNrOfObjects());
	    }

}
