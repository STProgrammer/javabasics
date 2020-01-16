
public class TriangleTry {

	public static void main(String[] args) {
		Triangle tr1 = new Triangle();
		Triangle tr2 = new Triangle(-5);
		Triangle tr3 = new Triangle(1, -2, 100);
		Triangle tr4 = new Triangle(1, 200, 1);
		Triangle tr5 = new Triangle(200, 2, 1);
		
		System.out.println("tr1 equals to tr2? " + tr1.equals(tr2));
		System.out.println("\nside1 and side2 of tr1 equals? " + (tr1.getSide1() == tr1.getSide2()));
		
		System.out.println("\ntr1: \n" + tr1);
		System.out.println("Area of tr1 " + tr1.getArea());
		System.out.println("Perimeter of tr1 " + tr1.getPerimeter());
		
		System.out.println("\ntr2: \n" + tr2);
		System.out.println("Area of tr2 " + tr2.getArea());
		System.out.println("Perimeter of tr2 " + tr2.getPerimeter());
		
		System.out.println("\ntr3: \n" + tr3);
		System.out.println("Area of tr3 " + tr3.getArea());
		System.out.println("Perimeter of tr3 " + tr3.getPerimeter());
		
		System.out.println("\ntr4: \n" + tr4);
		System.out.println("Area of tr4 " + tr4.getArea());
		System.out.println("Perimeter of tr4 " + tr4.getPerimeter());
		
		System.out.println("\ntr5: \n" + tr5);
		System.out.println("Area of tr5 " + tr5.getArea());
		System.out.println("Perimeter of tr5 " + tr5.getPerimeter());
		tr4.setSide3(-1);
		tr1.setSide2(600);
		
		System.out.println("\ntr4: \n" + tr4);
		System.out.println("Area of tr4 " + tr4.getArea());
		System.out.println("Perimeter of tr4 " + tr4.getPerimeter());
		
		System.out.println("\ntr1: \n" + tr1);
		System.out.println("Area of tr1 " + tr1.getArea());
		System.out.println("Perimeter of tr1 " + tr1.getPerimeter());

	}

}
