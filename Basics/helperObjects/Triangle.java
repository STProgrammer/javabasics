package helperObjects;

public class Triangle extends GeometricObject {
	private double side1;
	private double side2;
	private double side3;
	
	//Constructor 1
	public Triangle() {
		this.side1 = this.side2 = this.side3 = 1.0;
	} // end constructor 1
	
	//Constructior 2
	public Triangle(double side) {
		if (side <= 0)
			side = 1;
		this.side1 = this.side2 = this.side3 = side;
	} // end contructor 2
	
	//Contsructor 3
	public Triangle(double side1, double side2, double side3) {
		super("Red", false);
		if (side1 <= 0) {side1 = 1;}
		if (side2 <= 0) {side2 = 1;}
		if (side3 <= 0) {side3 = 1;}
		if ((side3 + side2 <= side1) || 
			(side1 <= Math.abs(side3 - side2))) {
			side3 = side1 + side2 - 1;
		}
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	} // end constructor 3
	
	//Contsructor 4
	public Triangle(String color, boolean filled, double side1, 
			double side2, double side3) {
		this.setColor(color);
		this.setFilled(filled);
		if (side1 <= 0) {side1 = 1;}
		if (side2 <= 0) {side2 = 1;}
		if (side3 <= 0) {side3 = 1;}
		if ((side3 + side2 <= side1) || 
			(side1 <= Math.abs(side3 - side2))) {
			side3 = side1 + side2 - 1;
		}
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	} // end constructor 3
	
	/*Set sides, the set side methods are public, so user
	can change side of the triangle without making the triangle
	illegal (by changing other sides)*/
	
	public double getSide1() {
		return this.side1;
	}
	
	public void setSide1(double side1) {
		if (side1 <= 0) {side1 = 1;}
		if ((side3 + side2 <= side1) || 
				(side1 <= Math.abs(side3 - side2))) {
				side3 = side1 + side2 - 1;
		}
		this.side1 = side1;
	} // end set side1
	
	public double getSide2() {
		return this.side2;
	}
	
	public void setSide2(double side2) {
		if (side2 <= 0) {side2 = 1;}
		if ((side3 + side2 <= side1) || 
				(side1 <= Math.abs(side3 - side2))) {
				side3 = side1 + side2 - 1;
		}
		this.side2 = side2;
	} // end set side2
	
	public double getSide3() {
		return this.side3;
	}  // end get sides
	
	public void setSide3(double side3) {
		if (side3 <= 0) {side3 = 1;}
		if ((side3 + side2 <= side1) || 
				(side1 <= Math.abs(side3 - side2))) {
				side2 = side1 + side3 - 1;
		}
		this.side3 = side3;
	} // end set side3

	@Override //Get area
	public double getArea() {
		double s = (side1 + side2 + side3) / 2;
		double area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
		return area;
	} // end get Area
	
	@Override //Get perimeter
	public double getPerimeter() {
		return getSide1() + getSide2() + getSide3();
	} // end get Perimeter
	
	@Override //Check if two triangles have equal sides
	public boolean equals(Object other) {
		if (other instanceof Triangle) {
			return (this.getSide1() == ((Triangle)other).getSide1() &
					this.getSide2() == ((Triangle)other).getSide2() &
					this.getSide3() == ((Triangle)other).getSide3() &
					this.getColor() == ((Triangle)other).getColor() &
					this.isFilled() == ((Triangle)other).isFilled());
		}
		else return false;
	} // end equal()
	
	// To string
	@Override
	public String toString() {
		String s = this.isFilled() ? "yes": "no";
		return "Triangle" + "\nSides: " + side1 + ",  " + side2 + ",  " + side3 +
				"\nConstructed on: " + this.getDateBuilt().getTime() + "\ncolor: " + 
				this.getColor() + "\nFilled: " + s;
	} // end toString

}