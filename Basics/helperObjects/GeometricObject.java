package helperObjects;

public abstract class GeometricObject implements Comparable<GeometricObject> {
  private String color = "white";
  private boolean filled;
  private java.util.GregorianCalendar dateBuilt;

  /** Construct a default geometric object */
  protected GeometricObject() {
    dateBuilt = new java.util.GregorianCalendar();
  }

  /** Construct a geometric object with color and filled value */
  protected GeometricObject(String color, boolean filled) {
    dateBuilt = new java.util.GregorianCalendar();
    this.color = color;
    this.filled = filled;
  }

  /** Return color */
  public String getColor() {
    return color;
  }

  /** Set a new color */
  public void setColor(String color) {
    this.color = color;
  }

  /** Return filled. Since filled is boolean,
   *  the get method is named isFilled */
  public boolean isFilled() {
    return filled;
  }

  /** Set a new filled */
  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  /** Get dateBuilt */
  public java.util.GregorianCalendar getDateBuilt() {
    return dateBuilt;
  }
  
  /** Abstract method getArea */
  public abstract double getArea();

  /** Abstract method getPerimeter */
  public abstract double getPerimeter();
  
  /** get max, if equal get obj1 */
  public static GeometricObject max(GeometricObject obj1, GeometricObject obj2) {
	  int num = obj1.compareTo(obj2);
	  if (num == -1) { return obj2; }
	  else return obj1;
  }
  
  /** compare areas of both objects */
  public int compareTo(GeometricObject other) {
	  if (this.getArea() < other.getArea()) {
		  return -1;
	  }
	  if (this.getArea() == other.getArea()) {
		  return 0;
	  }
	  else return 1;
  }
  
  /** Abstract mehtod check equals */
  public abstract boolean equals(Object other);

  /** Return a string representation of this object */
  public String toString() {
    return "contructed on " + this.getDateBuilt().getTime()  + "\ncolor: " + color +
      " and filled: " + filled;
  }

}
