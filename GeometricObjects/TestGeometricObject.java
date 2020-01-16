public class TestGeometricObject {

	public static void main (String args[]) {
		Rectangle rec1 = new Rectangle(5,6, "white", false);
		Rectangle rec2 = new Rectangle(7,7, "white", false);
		Rectangle rec3;
		Triangle tr1 = new Triangle("white", false, 3,4,5);
		Triangle tr2 = new Triangle("white", false, 8, 9, 10);
		Triangle tr3;
		Circle cr1 = new Circle(3, "white", false);
		Circle cr2 = new Circle(8, "white", false);
		Circle cr3;
		System.out.println("The biggest circle: ");
		if (cr1.compareTo(cr2) == -1) {
			System.out.println(cr2);
			cr3 = cr2;
		} else {
			System.out.println(cr1);
			cr3 = cr1;
		}
		
		System.out.println("\nThe biggest rectangle: ");
		if (rec1.compareTo(rec2) == -1) {
			System.out.println(rec2);
			rec3 = rec2;
		} else { 
			System.out.println(rec1);
			rec3 = rec1;
		}
		
		System.out.println("\nThe biggest triangle: ");
		if (tr1.compareTo(tr2) == -1) {
			System.out.println(tr2);
			tr3 = tr2;
		} else {
			System.out.println(tr1);
			tr3 = tr1;
		}
		
		System.out.print("\nThe biggest geometric object is: ");
		if (tr3.compareTo(cr3) == 1) {
			if (tr3.compareTo(rec3) == 1) {
				System.out.println(tr3);
			} else {
				System.out.println(rec3);
			}
		}
		else if (cr3.compareTo(rec3) == 1) {
			System.out.println(cr3);
		} else {
			System.out.println(rec3);
		}
	}
}

	

