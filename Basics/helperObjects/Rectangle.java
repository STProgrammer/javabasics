package helperObjects;

public class Rectangle extends GeometricObject {
  private double width;
  private double height;

  public Rectangle() {
  }

  public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }
  
  public Rectangle(double width, double height, String color, boolean filled) {
	    this.width = width;
	    this.height = height;
	    this.setColor(color);
	    this.setFilled(filled);
	  }

  /** Return width */
  public double getWidth() {
    return width;
  }

  /** Set a new width */
  public void setWidth(double width) {
    this.width = width;
  }

  /** Return height */
  public double getHeight() {
    return height;
  }

  /** Set a new height */
  public void setHeight(double height) {
    this.height = height;
  }

  @Override /** Return area */
  public double getArea() {
    return width * height;
  }

  @Override /** Return perimeter */
  public double getPerimeter() {
    return 2 * (width + height);
  }
  
  @Override /** Check if equals */
  public boolean equals(Object other) {
	  if (other instanceof Rectangle) {
		boolean a = this.getWidth() == ((Rectangle)other).getWidth();
		boolean b = this.getHeight() == ((Rectangle)other).getHeight();
		boolean c = this.isFilled() == ((Rectangle)other).isFilled();
		boolean d = this.getColor() == ((Rectangle)other).getColor();
		return ((a & b ) & (c & d));
	  }
	  else return false;
  }

  @Override /** To string */
  public String toString() {
	    return "Rectangle" + "\nWidth: " +  width + " Height: " + height +
	    "\nContructed on: " + this.getDateBuilt().getTime() + "\nColor: " + this.getColor() +
	      "\nFilled: " + (this.isFilled() ? "yes": "no");
  }
} 
  
