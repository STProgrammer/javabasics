public class TriangleExtra extends SimpleGeometricObject {
	private double side1;
	private double side2;
	private double side3;
	private static int numberOfObjects;
	/* This is different from Triangle. While Triangle changes 
	 * the sides to ensure that the triangle is always legal, 
	 * this just throws an exception when the triangle
	 * is illegal. Another difference is that the setSide mehtods are
	 * private and used in construction in TriangleExtra.
	 * But the setSide methods are public on Triangle. It's not excplicitly
	 * asked in the exercise whether these methods should be private
	 * or not, so I just made it that way.*/
	
	//Constructor 1
	public TriangleExtra() throws IllegalTriangleException {
		numberOfObjects += 1;
		checkLegality(1, 1, 1);
		setSide1(1);
		setSide2(1);
		setSide3(1);
		super.setFilled(false);
		super.setColor("Yellow");
	} // end constructor 1
	
	//Constructor 2
	public TriangleExtra(double side) throws IllegalTriangleException {
		checkLegality(side, side, side);	
		setSide1(side);
		setSide2(side);
		setSide3(side);
		super.setFilled(true);
		super.setColor("Blue");
		numberOfObjects += 1;
	} // end contructor 2
	
	//Contructor 3
	public TriangleExtra(double side1, double side2, double side3) 
			throws IllegalTriangleException {
		checkLegality(side1, side2, side3);	
		setSide1(side1);
		setSide2(side2);
		setSide3(side3);
		super.setFilled(false);
		super.setColor("Red");
		numberOfObjects += 1;
	} // end constructor 3
	
	//Check if it's valid triangle
	public boolean checkLegality (double side1, double side2, double side3) 
			throws IllegalTriangleException {
		boolean testSides = (side3 + side2 >= side1) & 
				(side1 >= Math.abs(side3 - side2));
		boolean testPositive = (side1 > 0 & side2 > 0 & side3 > 0);
		if (testSides & testPositive)
			return true;
		else
			throw new IllegalTriangleException(side1, side2, side3);
	} // end checkLegality
	
	//Get side methods
	public double getSide1() {
		return this.side1;
	}
	public double getSide2() {
		return this.side2;
	}
	public double getSide3() {
		return this.side3;
	}  // end get sides
	
	//Set side methods
	private void setSide1(double side1) {
		this.side1 = side1;
	}
	private void setSide2(double side2) {
		this.side2 = side2;
	}
	private void setSide3(double side3) {
		this.side3 = side3;
	} // end set sides
	
	//get area
	public double getArea() {
		double s = (side1 + side2 + side3) / 2;
		double area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
		return area;
	} // end get Area
	
	// get perimeter
	public double getPerimeter() {
		return side1 + side2 + side3;
	} // end get Perimeter
	
	public boolean equals(Object other) {
		return (this.getSide1() == ((TriangleExtra)other).getSide1() &
				this.getSide2() == ((TriangleExtra)other).getSide2() &
				this.getSide3() == ((TriangleExtra)other).getSide3());
	} // end equal()
	
	//get nr of objects (eve if invalid)
	public static int getNrOfObjects() {
		return numberOfObjects;
	}
	
	//to string
	@Override
	public String toString() {
		String s = isFilled() ? "yes": "no";
		return "Sides: " + side1 + " " + side2 + " " + side3 +
				"\nBuilt on " + getDateBuilt() + "\ncolor: " + 
				getColor() + "\nFilled: " + s;
	} // end toString
	
}


