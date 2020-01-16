public abstract class GeometricObject {
  private String color = "white";
  private boolean filled;
  private java.util.GregorianCalendar dateCreated;

  /** Construct a default geometric object */
  protected GeometricObject() {
    dateCreated = new java.util.GregorianCalendar();
  }

  /** Construct a geometric object with color and filled value */
  protected GeometricObject(String color, boolean filled) {
    dateCreated = new java.util.GregorianCalendar();
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

  /** Get dateCreated */
  public java.util.GregorianCalendar getDateCreated() {
    return dateCreated;
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
    return "contructed on " + this.getDateCreated().getTime()  + "\ncolor: " + color +
      " and filled: " + filled;
  }

}
