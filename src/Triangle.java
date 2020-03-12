public class Triangle extends SimpleGeometricObject {
	private double side1;
	private double side2;
	private double side3;
	
	public Triangle() {
		super("yellow", true);
		side1 = side2 = side3 = 1.0;
	}
	
	public Triangle(double side) {
		super("Blue", true);
		if (side <= 0) {side = 1.0;}
		side1 = side2 = side3 = side;
	}
	
	public Triangle(double side1, double side2, double side3) {
		super("Red", true);
		if (checkLegality(side1, side2, side3)) {
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		}
		else {
			if (side1 <= 0) {side1 = 1.0;}
			if (side2 <= 0) {side2 = 1.0;}
			if (side3 <= 0) {side3 = 1.0;}
			side3 = side1 + side2 - 1;
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		}
	}
	
	public boolean checkLegality(double side1, double side2, double side3) {
		boolean rule1 = (side1 > 0 && side2 > 0 && side3 > 0);
		boolean rule2 = ((side1 < side2 + side3) & 
						(side2 < side3 + side1) & 
						(side3 < side1 + side2));
		return (rule1 && rule2);
	}
	
	
	public double getSide1() {return this.side1;}
	public double getSide2() {return this.side2;}
	public double getSide3() {return this.side3;}
	
	public void setSide1(double side1) {
		if (checkLegality(side1, this.side2, this.side3)) {
			this.side1 = side1;
			}
		else {
			if(side1 <= 0) {side1 = 1.0;}
			this.side3 = side1 + this.side2 - 1;
			this.side1 = side1;
		}
	}
	
	public void setSide2(double side2) {
		if (checkLegality(side1, side2, this.side3)) {
			this.side2 = side2;
			}
		else {
			if(side2 <= 0) {side2 = 1.0;}
			this.side3 = side2 + this.side1 - 1;
			this.side2 = side2;
		}
	}
	
	public void setSide3(double side3) {
		if (checkLegality(this.side1, this.side2, side3)) {
			this.side3 = side3;
			}
		else {
			if(side3 <= 0) {side3 = 1.0;}
			this.side2 = side3 + this.side1 - 1;
			this.side3 = side3;
		}
	}
	
	public double getArea() {
		double s = (side1 + side2 + side3) / 2;
		double area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
		return area;
	}
	
	public double getPerimeter() {
		double perimeter = side1 + side2 + side3;
		return perimeter;
	}
	
	public boolean equals(Object other) {
		return (side1 == ((Triangle)other).getSide1() &&
				side2 == ((Triangle)other).getSide2() &&
				side3 == ((Triangle)other).getSide3());
	}
	
	public String toString() {
		String s = "\nSides: " + side1 + ", " + side2 + ", " + side3 +
				"\nConstructed on: " + super.getDateBuilt() + 
				"\nColor: " + super.getColor() +
				"\nIs filled: ";
		s += super.isFilled() ? "Yes": "No";
		return s;
		
	}
	
	public static void main(String args[]) {
		Triangle tr1 = new Triangle(5);
		Triangle tr2 = new Triangle(-15);
		Triangle tr3 = new Triangle(4, 50, 6);
		
		System.out.println("Triangle 1:");
		System.out.println("Area: " + tr1.getArea());
		System.out.println("Perimeter: " + tr1.getArea());
		System.out.println(tr1.toString());
				
		System.out.println("Triangle 2:");
		System.out.println("Area: " + tr2.getArea());
		System.out.println("Perimeter: " + tr2.getArea());
		System.out.println(tr2.toString());
		
				
		System.out.println("Triangle 3:");
		System.out.println("Area: " + tr3.getArea());
		System.out.println("Perimeter: " + tr3.getArea());
		System.out.println(tr3.toString());	
	}
}
