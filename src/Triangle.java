public class Triangle extends SimpleGeometricObject {
	private double side1;
	private double side2;
	private double side3;
	
	/* This is different from TriangleExtra. This (Triangle) changes 
	 * the sides to ensure that the triangle is always legal.
	 * But TriangleExtra just throws an exception when the triangle
	 * is illegal. Another difference is that the setSide methods are
	 * private and used in construction in TriangleExtra.
	 * But the setSide methods are public on Triangle. It's not explicitly
	 * asked in the exercise whether these methods should be private
	 * or not, so I just made it that way.*/
	
	//Constructor 1
	public Triangle() {
		super("Yellow", false);
		this.side1 = this.side2 = this.side3 = 1.0;
	} // end constructor 1
	
	//Constructior 2
	public Triangle(double side) {
		super("Blue", true);
		if (side <= 0)
			side = 1;
		this.side1 = this.side2 = this.side3 = side;
	} // end contructor 2
	
	//Contsructor 3
	public Triangle(double side1, double side2, double side3) {
		super("Red", false);
		if (!checkLegality(side1, side2, side3)) {
			if (side1 <= 0)
				side1 = 1;
			if (side2 <= 0)
				side2 = 1;
			if (side3 <= 0)
				side3 = 1;
			if ((side3 + side2 <= side1) || 
				(side1 <= Math.abs(side3 - side2)))
				side3 = side1 + side2 - 1;
		}
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	} // end constructor 3
	
	//Check if the triangle is valid
	
	public boolean checkLegality(double side1, double side2, double side3) {
		boolean testSides = (side3 + side2 >= side1) & 
				(side1 >= Math.abs(side3 - side2));
		boolean testPositive = (side1 > 0 & side2 > 0 & side3 > 0);
		return (testSides & testPositive);
	} // end checkLegality
	
	//Get sides
	public double getSide1() {
		return this.side1;
	}
	public double getSide2() {
		return this.side2;
	}
	public double getSide3() {
		return this.side3;
	}  // end get sides

	/*Set sides, the set side methods are public, so user
	can change side of the triangle without making the triangle
	illegal (by changing other sides)*/
	public void setSide1(double side1) {
		if (side1 <= 0)
			side1 = 1;
		this.side1 = side1;
		if (!checkLegality(side1, this.side2, this.side3))
			this.side3 = side1 + this.side2 - 1;
	} // end set side1
	public void setSide2(double side2) {
		if (side2 <= 0)
			side2 = 1;
		this.side2 = side2;
		if (!checkLegality(this.side1, side2, this.side3))
			this.side3 = side1 + this.side2 - 1;
	}// end set side2
	public void setSide3(double side3) {
		if (side3 <= 0)
			side3 = 1;
		this.side3 = side3;
		if (!checkLegality(this.side1, this.side2, side3))
			this.side2 = side3 + this.side1 - 1;
	} // end set side3

	//Get area
	public double getArea() {
		double s = (side1 + side2 + side3) / 2;
		double area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
		return area;
	} // end get Area
	
	//Get perimeter
	public double getPerimeter() {
		return getSide1() + getSide2() + getSide3();
	} // end get Perimeter
	
	//Check if two triangles have equal sides
	public boolean equals(Object other) {
		return (this.getSide1() == ((Triangle)other).getSide1() &
				this.getSide2() == ((Triangle)other).getSide2() &
				this.getSide3() == ((Triangle)other).getSide3());
	} // end equal()
	
	// To string
	@Override
	public String toString() {
		String s = isFilled() ? "yes": "no";
		return "Sides: " + side1 + " " + side2 + " " + side3 +
				"\nConstructed on " + getDateBuilt() + "\ncolor: " + 
				getColor() + "\nFilled: " + s;
	} // end toString

}
