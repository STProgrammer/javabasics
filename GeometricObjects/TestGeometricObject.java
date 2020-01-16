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
		cr3 = (Circle)GeometricObject.max(cr1, cr2);
		System.out.println(cr3);
		
		System.out.println("\nThe biggest rectangle: ");
		rec3 = (Rectangle)GeometricObject.max(rec1, rec2);
		System.out.println(rec3);
		
		System.out.println("\nThe biggest triangle: ");
		tr3 = (Triangle)GeometricObject.max(tr1, tr2);
		System.out.println(tr3);
		
		GeometricObject obj;
		obj = GeometricObject.max(GeometricObject.max(cr3, rec3), tr3);
		System.out.print("\nThe biggest geometric object is: ");
		
		if (obj instanceof Circle)
				System.out.println(cr3);
		if (obj instanceof Rectangle)
			System.out.println(rec3);
		if (obj instanceof Triangle)
			System.out.println(tr3);
		
	}
}

	

