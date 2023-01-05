
public class TestRectangle {

	public static void main(String[] args) {
		MyRectangle rec1 = new MyRectangle(40, 4);
		MyRectangle rec2 = new MyRectangle();
		rec2.setHeight(6.3);
		rec2.setWidth(5.4);
		System.out.printf("Rectangle with sides: %14.2f and %2.2f %n", 
				rec1.getHeight(), rec1.getWidth());
		System.out.printf("has an area equal to: %20.2f %n"
				+ "and has a perimeter equal to: %12.2f %n %n", 
				rec1.getArea(), rec1.getPerimeter());
		System.out.printf("Rectangle with sides: %14.2f and %2.2f %n", 
				rec2.getHeight(), rec2.getWidth());
		System.out.printf("has an area equal to: %20.2f %n"
				+ "and has a perimeter equal to: %12.2f %n", 
				rec2.getArea(), rec2.getPerimeter());
	}	
}
	

class MyRectangle {
	private double height, width;
	
	public MyRectangle() {
		height = 1.0;
		width = 1.0;
	}
	
	public MyRectangle(double h, double w) {
		height = h;
		width = w;
	}
	public double getHeight() {
		return height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double w) {
		width = w;
	}
	public void setHeight(double h) {
		height = h;
	}
	public double getArea() {
		return height * width;
	}
	public double getPerimeter() {
		return 2*(height + width);
	}
}