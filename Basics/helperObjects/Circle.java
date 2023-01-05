package helperObjects;

public class Circle extends GeometricObject {
  private double radius;

  public Circle() {
  }

  public Circle(double radius) {
    this.radius = radius;
  }
  
  public Circle(double radius, String color, boolean filled) {
	  this.radius = radius;
	  this.setColor(color);
	  this.setFilled(filled);
  }

  /** Return radius */
  public double getRadius() {
    return radius;
  }

  /** Set a new radius */
  public void setRadius(double radius) {
    this.radius = radius;
  }

  @Override /** Return area */
  public double getArea() {
    return radius * radius * Math.PI;
  }

  @Override /** Return perimeter */
  public double getPerimeter() {
    return 2 * radius * Math.PI;
  }
  
  @Override /** Check if equal */
  public boolean equals(Object other) {
	  if (other instanceof Circle) {
		  return (this.getRadius() == ((Circle)other).getRadius() &
					this.getColor() == ((Circle)other).getColor() &
					this.isFilled() == ((Circle)other).isFilled());
	  }
	  else return false;
	} 
  
  /** return String */
  public String toString() {
	    return "Circle" + "\nRadius: " +  radius +
	    "\nContructed on: " + this.getDateBuilt().getTime()  + "\nColor: " + this.getColor() +
	      "\nFilled: " + (this.isFilled() ? "yes": "no");
  }
}
