
public class IllegalTriangleException extends Exception {
	private double side1;
	private double side2;
	private double side3;
	
	public IllegalTriangleException (double side1, 
			double side2, double side3) {
		super("Invalid triangle with sides " + side1 + " "
				+ side2 + " and " + side3);
		super.toString();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
}
